/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.sms.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.opencps.sms.model.SMSGatewayLog;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for SMSGatewayLog. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author khoa
 * @see SMSGatewayLogLocalServiceUtil
 * @see org.opencps.sms.service.base.SMSGatewayLogLocalServiceBaseImpl
 * @see org.opencps.sms.service.impl.SMSGatewayLogLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SMSGatewayLogLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SMSGatewayLogLocalServiceUtil} to access the sms gateway log local service. Add custom service methods to {@link org.opencps.sms.service.impl.SMSGatewayLogLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the sms gateway log to the database. Also notifies the appropriate model listeners.
	*
	* @param smsGatewayLog the sms gateway log
	* @return the sms gateway log that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public SMSGatewayLog addSMSGatewayLog(SMSGatewayLog smsGatewayLog);

	/**
	* Creates a new sms gateway log with the primary key. Does not add the sms gateway log to the database.
	*
	* @param smsId the primary key for the new sms gateway log
	* @return the new sms gateway log
	*/
	@Transactional(enabled = false)
	public SMSGatewayLog createSMSGatewayLog(long smsId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the sms gateway log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param smsId the primary key of the sms gateway log
	* @return the sms gateway log that was removed
	* @throws PortalException if a sms gateway log with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public SMSGatewayLog deleteSMSGatewayLog(long smsId)
		throws PortalException;

	/**
	* Deletes the sms gateway log from the database. Also notifies the appropriate model listeners.
	*
	* @param smsGatewayLog the sms gateway log
	* @return the sms gateway log that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public SMSGatewayLog deleteSMSGatewayLog(SMSGatewayLog smsGatewayLog);

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sms.model.impl.SMSGatewayLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sms.model.impl.SMSGatewayLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SMSGatewayLog fetchSMSGatewayLog(long smsId);

	/**
	* Returns the sms gateway log matching the UUID and group.
	*
	* @param uuid the sms gateway log's UUID
	* @param groupId the primary key of the group
	* @return the matching sms gateway log, or <code>null</code> if a matching sms gateway log could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SMSGatewayLog fetchSMSGatewayLogByUuidAndGroupId(String uuid,
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the sms gateway log with the primary key.
	*
	* @param smsId the primary key of the sms gateway log
	* @return the sms gateway log
	* @throws PortalException if a sms gateway log with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SMSGatewayLog getSMSGatewayLog(long smsId) throws PortalException;

	/**
	* Returns the sms gateway log matching the UUID and group.
	*
	* @param uuid the sms gateway log's UUID
	* @param groupId the primary key of the group
	* @return the matching sms gateway log
	* @throws PortalException if a matching sms gateway log could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SMSGatewayLog getSMSGatewayLogByUuidAndGroupId(String uuid,
		long groupId) throws PortalException;

	/**
	* Returns a range of all the sms gateway logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sms.model.impl.SMSGatewayLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sms gateway logs
	* @param end the upper bound of the range of sms gateway logs (not inclusive)
	* @return the range of sms gateway logs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SMSGatewayLog> getSMSGatewayLogs(int start, int end);

	/**
	* Returns all the sms gateway logs matching the UUID and company.
	*
	* @param uuid the UUID of the sms gateway logs
	* @param companyId the primary key of the company
	* @return the matching sms gateway logs, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SMSGatewayLog> getSMSGatewayLogsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	* Returns a range of sms gateway logs matching the UUID and company.
	*
	* @param uuid the UUID of the sms gateway logs
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of sms gateway logs
	* @param end the upper bound of the range of sms gateway logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching sms gateway logs, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SMSGatewayLog> getSMSGatewayLogsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SMSGatewayLog> orderByComparator);

	/**
	* Returns the number of sms gateway logs.
	*
	* @return the number of sms gateway logs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSMSGatewayLogsCount();

	/**
	* Updates the sms gateway log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param smsGatewayLog the sms gateway log
	* @return the sms gateway log that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public SMSGatewayLog updateSMSGatewayLog(SMSGatewayLog smsGatewayLog);
}