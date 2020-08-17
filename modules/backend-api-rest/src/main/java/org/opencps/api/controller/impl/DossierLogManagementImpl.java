package org.opencps.api.controller.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.net.HttpURLConnection;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.opencps.api.controller.DossierLogManagement;
import org.opencps.api.controller.DossierManagement;
import org.opencps.api.controller.util.DossierLogUtils;
import org.opencps.api.controller.util.DossierUtils;
import org.opencps.api.controller.util.MessageUtil;
import org.opencps.api.dossier.model.DossierResultsModel;
import org.opencps.api.dossier.model.DossierSearchModel;
import org.opencps.api.dossieraction.model.DossierActionResultsModel;
import org.opencps.api.dossierlog.model.DossierLogModel;
import org.opencps.api.dossierlog.model.DossierLogResultsModel;
import org.opencps.api.dossierlog.model.DossierLogSearchModel;
import org.opencps.auth.utils.APIDateTimeUtils;
import org.opencps.dossiermgt.action.DossierActions;
import org.opencps.dossiermgt.action.DossierLogActions;
import org.opencps.dossiermgt.action.impl.DossierActionsImpl;
import org.opencps.dossiermgt.action.impl.DossierLogActionsImpl;
import org.opencps.dossiermgt.action.util.ConstantUtils;
import org.opencps.dossiermgt.action.util.ReadFilePropertiesUtils;
import org.opencps.dossiermgt.constants.DossierLogTerm;
import org.opencps.dossiermgt.constants.DossierTerm;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierAction;
import org.opencps.dossiermgt.model.DossierLog;

import backend.auth.api.exception.BusinessExceptionImpl;
import org.opencps.dossiermgt.model.ServiceProcess;
import org.opencps.dossiermgt.service.DossierActionLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceProcessLocalServiceUtil;

public class DossierLogManagementImpl implements DossierLogManagement {

	@Override
	public Response addDossierLogByDossierId(HttpServletRequest request, HttpHeaders header, Company company,
			Locale locale, User user, ServiceContext serviceContext, long id, String notificationType, String author,
			String payload, String content) {

		long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));

		try {

			DossierLogActions action = new DossierLogActionsImpl();

			DossierLog dossierLog = action.addDossierLog(groupId, id, author, content, notificationType, payload,
					serviceContext);

			DossierLogModel result = DossierLogUtils.mappingToDossierLogModel(dossierLog);

			return Response.status(HttpURLConnection.HTTP_OK).entity(result).build();

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response getDossierLogs(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext, DossierLogSearchModel query) {

		long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));

		try {

			DossierLogResultsModel results = new DossierLogResultsModel();

			DossierLogActions action = new DossierLogActionsImpl();

			JSONObject dossierLogJsonObject = action.getDossierLogs(groupId, query.getNotificationType(),
					query.isOwner(), query.getStart(), query.getEnd(), query.getSort(), query.getOrder(),
					serviceContext);

			List<Document> documents = (List<Document>) dossierLogJsonObject.get(ConstantUtils.DATA);
			//
			results.setTotal(dossierLogJsonObject.getInt(ConstantUtils.TOTAL));
			results.getData().addAll(DossierLogUtils.mappingToDossierLogResultsModel(documents));

			return Response.status(HttpURLConnection.HTTP_OK).entity(results).build();

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response getDossierLogById(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext, DossierLogSearchModel query, long dossierId, String password) {

		long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));
		try {

			JSONObject results = JSONFactoryUtil.createJSONObject();

			DossierLogActions action = new DossierLogActionsImpl();

			JSONObject dossierLogJsonObject = action.getDossierLogById(groupId, dossierId, password, query.isOwner(),
					query.getStart(),

					query.getEnd(), query.getSort(), query.getOrder(), serviceContext);

			List<Document> documents = (List<Document>) dossierLogJsonObject.get(ConstantUtils.DATA);

			JSONArray models = JSONFactoryUtil.createJSONArray();

			for (Document document : documents) {

				JSONObject model = JSONFactoryUtil.createJSONObject();

				long dossierLogId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

				model.put(DossierLogTerm.DOSSIER_LOG_ID, dossierLogId);

				model.put(DossierLogTerm.AUTHOR, document.get(DossierLogTerm.AUTHOR) != null ? document.get(DossierLogTerm.AUTHOR).toUpperCase() : StringPool.BLANK);

				model.put(DossierLogTerm.CONTENT, document.get(DossierLogTerm.CONTENT));

				String strDate = document.get(DossierLogTerm.CREATE_DATE);

				Date date = null;

				if (Validator.isNotNull(strDate)) {
					date = APIDateTimeUtils.convertStringToDate(strDate, ReadFilePropertiesUtils.get(ConstantUtils.PATTERN_LUCENE));
				}

//				model.put("createDate", date != null
//						? APIDateTimeUtils.convertDateToString(date, APIDateTimeUtils._TIMESTAMP) : strDate);

				model.put(DossierLogTerm.CREATE_DATE, date != null
				? date.getTime() : 0l);

				model.put(DossierLogTerm.NOTIFICATION_TYPE, document.get(DossierLogTerm.NOTIFICATION_TYPE));

				JSONObject payload = JSONFactoryUtil.createJSONObject(document.get(DossierLogTerm.PAYLOAD));

				model.put(DossierLogTerm.PAYLOAD, payload);

				models.put(model);

			}

			results.put(ConstantUtils.TOTAL, dossierLogJsonObject.getInt(ConstantUtils.TOTAL));

			results.put(ConstantUtils.DATA, models);

			return Response.status(HttpURLConnection.HTTP_OK).entity(results.toJSONString()).build();

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	@Override
	public Response getRevisionLogByGroupId(HttpServletRequest request, HttpHeaders header, Company company,
											Locale locale, User user, ServiceContext serviceContext, DossierSearchModel query) {
		LinkedHashMap<String, Object> params =
				new LinkedHashMap<>();
		List<Dossier> lstDossier = new ArrayList<>();
		DossierActions actions = new DossierActionsImpl();
		DossierActionResultsModel results = new DossierActionResultsModel();


		try {
			if (Validator.isNull(query.getEnd()) || query.getEnd() == 0) {
				query.setStart(QueryUtil.ALL_POS);
				query.setEnd(QueryUtil.ALL_POS);
			}
			String dossierIds = "";
			long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));
			params.put(Field.GROUP_ID, String.valueOf(groupId));

			String createDateStart =
					APIDateTimeUtils.convertNormalDateToLuceneDate(
							query.getCreateDateStart());
			String createDateEnd =
					APIDateTimeUtils.convertNormalDateToLuceneDate(
							query.getCreateDateEnd());

			if(Validator.isNotNull(createDateStart)){
				params.put(DossierTerm.CREATE_DATE_START, createDateStart);
			}
			if(Validator.isNotNull(createDateEnd)){
				params.put(DossierTerm.CREATE_DATE_END, createDateEnd);
			}
			Sort[] sorts = null;
			if (Validator.isNull(query.getSort())) {
				String dateSort = String.format(MessageUtil.getMessage(org.opencps.api.constants.ConstantUtils.QUERY_NUMBER_SORT), DossierTerm.CREATE_DATE);
				sorts = new Sort[]{
						SortFactoryUtil.create(
								dateSort, Sort.LONG_TYPE,
								GetterUtil.getBoolean(query.getOrder()))
				};
			} else {
				String querySort = String.format(MessageUtil.getMessage(org.opencps.api.constants.ConstantUtils.QUERY_STRING_SORT), query.getSort());
				sorts = new Sort[]{
						SortFactoryUtil.create(
								querySort, Sort.STRING_TYPE,
								GetterUtil.getBoolean(query.getOrder()))
				};
			}


			if (lstDossier.size() < 1) {
				lstDossier = DossierLocalServiceUtil.findDossierByGroup(groupId);
			}
			if (lstDossier.isEmpty()) {
				throw new Exception(MessageUtil.getMessage(org.opencps.api.constants.ConstantUtils.DOSSIER_MESSAGE_KHONGTIMTHAY));
			}
			if (lstDossier != null && lstDossier.size() > 0) {
			for(Dossier dossier : lstDossier) {
				if(Validator.isNotNull(dossier.getDossierId())){
					dossierIds += "," + dossier.getDossierId();
				}
			}
			if(Validator.isNotNull(dossierIds)){
				dossierIds = dossierIds.substring(1);
				params.put(DossierTerm.DOSSIER_ID, dossierIds);
			}
				JSONObject jsonData = actions.getDossierActionsList(
						user.getUserId(), company.getCompanyId(), groupId, params,
						sorts, query.getStart(), query.getEnd(), serviceContext);
				if (jsonData != null && jsonData.getInt(ConstantUtils.TOTAL) > 0) {
					results.getData().addAll(
							DossierUtils.mappingForListDossierActions(
									(List<Document>) jsonData.get(ConstantUtils.DATA)));

				}

				results.setTotal(jsonData.getInt(ConstantUtils.TOTAL));
		}
			return Response.status(HttpURLConnection.HTTP_OK).entity(results).build();


		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}
}
