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

package org.opencps.dossiermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.dossiermgt.model.DossierRequestUD;
import org.opencps.dossiermgt.model.DossierRequestUDModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DossierRequestUD service. Represents a row in the &quot;opencps_dossierrequests&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DossierRequestUDModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DossierRequestUDImpl}.
 * </p>
 *
 * @author huymq
 * @see DossierRequestUDImpl
 * @see DossierRequestUD
 * @see DossierRequestUDModel
 * @generated
 */
@ProviderType
public class DossierRequestUDModelImpl extends BaseModelImpl<DossierRequestUD>
	implements DossierRequestUDModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dossier request ud model instance should use the {@link DossierRequestUD} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_dossierrequests";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "dossierRequestId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "dossierId", Types.BIGINT },
			{ "referenceUid", Types.VARCHAR },
			{ "requestType", Types.VARCHAR },
			{ "comment_", Types.VARCHAR },
			{ "isNew", Types.INTEGER },
			{ "statusReg", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dossierRequestId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dossierId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("referenceUid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("requestType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("comment_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isNew", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusReg", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_dossierrequests (uuid_ VARCHAR(75) null,dossierRequestId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(255) null,createDate DATE null,modifiedDate DATE null,dossierId LONG,referenceUid VARCHAR(75) null,requestType VARCHAR(128) null,comment_ TEXT null,isNew INTEGER,statusReg INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table opencps_dossierrequests";
	public static final String ORDER_BY_JPQL = " ORDER BY dossierRequestUD.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_dossierrequests.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.DossierRequestUD"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.DossierRequestUD"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.DossierRequestUD"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long DOSSIERID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long ISNEW_COLUMN_BITMASK = 8L;
	public static final long REQUESTTYPE_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.DossierRequestUD"));

	public DossierRequestUDModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dossierRequestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDossierRequestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dossierRequestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DossierRequestUD.class;
	}

	@Override
	public String getModelClassName() {
		return DossierRequestUD.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dossierRequestId", getDossierRequestId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("referenceUid", getReferenceUid());
		attributes.put("requestType", getRequestType());
		attributes.put("comment", getComment());
		attributes.put("isNew", getIsNew());
		attributes.put("statusReg", getStatusReg());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dossierRequestId = (Long)attributes.get("dossierRequestId");

		if (dossierRequestId != null) {
			setDossierRequestId(dossierRequestId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		String referenceUid = (String)attributes.get("referenceUid");

		if (referenceUid != null) {
			setReferenceUid(referenceUid);
		}

		String requestType = (String)attributes.get("requestType");

		if (requestType != null) {
			setRequestType(requestType);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Integer isNew = (Integer)attributes.get("isNew");

		if (isNew != null) {
			setIsNew(isNew);
		}

		Integer statusReg = (Integer)attributes.get("statusReg");

		if (statusReg != null) {
			setStatusReg(statusReg);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getDossierRequestId() {
		return _dossierRequestId;
	}

	@Override
	public void setDossierRequestId(long dossierRequestId) {
		_dossierRequestId = dossierRequestId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_columnBitmask |= DOSSIERID_COLUMN_BITMASK;

		if (!_setOriginalDossierId) {
			_setOriginalDossierId = true;

			_originalDossierId = _dossierId;
		}

		_dossierId = dossierId;
	}

	public long getOriginalDossierId() {
		return _originalDossierId;
	}

	@Override
	public String getReferenceUid() {
		if (_referenceUid == null) {
			return "";
		}
		else {
			return _referenceUid;
		}
	}

	@Override
	public void setReferenceUid(String referenceUid) {
		_referenceUid = referenceUid;
	}

	@Override
	public String getRequestType() {
		if (_requestType == null) {
			return "";
		}
		else {
			return _requestType;
		}
	}

	@Override
	public void setRequestType(String requestType) {
		_columnBitmask |= REQUESTTYPE_COLUMN_BITMASK;

		if (_originalRequestType == null) {
			_originalRequestType = _requestType;
		}

		_requestType = requestType;
	}

	public String getOriginalRequestType() {
		return GetterUtil.getString(_originalRequestType);
	}

	@Override
	public String getComment() {
		if (_comment == null) {
			return "";
		}
		else {
			return _comment;
		}
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;
	}

	@Override
	public int getIsNew() {
		return _isNew;
	}

	@Override
	public void setIsNew(int isNew) {
		_columnBitmask |= ISNEW_COLUMN_BITMASK;

		if (!_setOriginalIsNew) {
			_setOriginalIsNew = true;

			_originalIsNew = _isNew;
		}

		_isNew = isNew;
	}

	public int getOriginalIsNew() {
		return _originalIsNew;
	}

	@Override
	public int getStatusReg() {
		return _statusReg;
	}

	@Override
	public void setStatusReg(int statusReg) {
		_statusReg = statusReg;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				DossierRequestUD.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DossierRequestUD.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DossierRequestUD toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DossierRequestUD)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DossierRequestUDImpl dossierRequestUDImpl = new DossierRequestUDImpl();

		dossierRequestUDImpl.setUuid(getUuid());
		dossierRequestUDImpl.setDossierRequestId(getDossierRequestId());
		dossierRequestUDImpl.setCompanyId(getCompanyId());
		dossierRequestUDImpl.setGroupId(getGroupId());
		dossierRequestUDImpl.setUserId(getUserId());
		dossierRequestUDImpl.setUserName(getUserName());
		dossierRequestUDImpl.setCreateDate(getCreateDate());
		dossierRequestUDImpl.setModifiedDate(getModifiedDate());
		dossierRequestUDImpl.setDossierId(getDossierId());
		dossierRequestUDImpl.setReferenceUid(getReferenceUid());
		dossierRequestUDImpl.setRequestType(getRequestType());
		dossierRequestUDImpl.setComment(getComment());
		dossierRequestUDImpl.setIsNew(getIsNew());
		dossierRequestUDImpl.setStatusReg(getStatusReg());

		dossierRequestUDImpl.resetOriginalValues();

		return dossierRequestUDImpl;
	}

	@Override
	public int compareTo(DossierRequestUD dossierRequestUD) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				dossierRequestUD.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierRequestUD)) {
			return false;
		}

		DossierRequestUD dossierRequestUD = (DossierRequestUD)obj;

		long primaryKey = dossierRequestUD.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		DossierRequestUDModelImpl dossierRequestUDModelImpl = this;

		dossierRequestUDModelImpl._originalUuid = dossierRequestUDModelImpl._uuid;

		dossierRequestUDModelImpl._originalCompanyId = dossierRequestUDModelImpl._companyId;

		dossierRequestUDModelImpl._setOriginalCompanyId = false;

		dossierRequestUDModelImpl._originalGroupId = dossierRequestUDModelImpl._groupId;

		dossierRequestUDModelImpl._setOriginalGroupId = false;

		dossierRequestUDModelImpl._setModifiedDate = false;

		dossierRequestUDModelImpl._originalDossierId = dossierRequestUDModelImpl._dossierId;

		dossierRequestUDModelImpl._setOriginalDossierId = false;

		dossierRequestUDModelImpl._originalRequestType = dossierRequestUDModelImpl._requestType;

		dossierRequestUDModelImpl._originalIsNew = dossierRequestUDModelImpl._isNew;

		dossierRequestUDModelImpl._setOriginalIsNew = false;

		dossierRequestUDModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DossierRequestUD> toCacheModel() {
		DossierRequestUDCacheModel dossierRequestUDCacheModel = new DossierRequestUDCacheModel();

		dossierRequestUDCacheModel.uuid = getUuid();

		String uuid = dossierRequestUDCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dossierRequestUDCacheModel.uuid = null;
		}

		dossierRequestUDCacheModel.dossierRequestId = getDossierRequestId();

		dossierRequestUDCacheModel.companyId = getCompanyId();

		dossierRequestUDCacheModel.groupId = getGroupId();

		dossierRequestUDCacheModel.userId = getUserId();

		dossierRequestUDCacheModel.userName = getUserName();

		String userName = dossierRequestUDCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dossierRequestUDCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dossierRequestUDCacheModel.createDate = createDate.getTime();
		}
		else {
			dossierRequestUDCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dossierRequestUDCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dossierRequestUDCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dossierRequestUDCacheModel.dossierId = getDossierId();

		dossierRequestUDCacheModel.referenceUid = getReferenceUid();

		String referenceUid = dossierRequestUDCacheModel.referenceUid;

		if ((referenceUid != null) && (referenceUid.length() == 0)) {
			dossierRequestUDCacheModel.referenceUid = null;
		}

		dossierRequestUDCacheModel.requestType = getRequestType();

		String requestType = dossierRequestUDCacheModel.requestType;

		if ((requestType != null) && (requestType.length() == 0)) {
			dossierRequestUDCacheModel.requestType = null;
		}

		dossierRequestUDCacheModel.comment = getComment();

		String comment = dossierRequestUDCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			dossierRequestUDCacheModel.comment = null;
		}

		dossierRequestUDCacheModel.isNew = getIsNew();

		dossierRequestUDCacheModel.statusReg = getStatusReg();

		return dossierRequestUDCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", dossierRequestId=");
		sb.append(getDossierRequestId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append(", referenceUid=");
		sb.append(getReferenceUid());
		sb.append(", requestType=");
		sb.append(getRequestType());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", isNew=");
		sb.append(getIsNew());
		sb.append(", statusReg=");
		sb.append(getStatusReg());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.DossierRequestUD");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierRequestId</column-name><column-value><![CDATA[");
		sb.append(getDossierRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referenceUid</column-name><column-value><![CDATA[");
		sb.append(getReferenceUid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestType</column-name><column-value><![CDATA[");
		sb.append(getRequestType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNew</column-name><column-value><![CDATA[");
		sb.append(getIsNew());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusReg</column-name><column-value><![CDATA[");
		sb.append(getStatusReg());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DossierRequestUD.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DossierRequestUD.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _dossierRequestId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _dossierId;
	private long _originalDossierId;
	private boolean _setOriginalDossierId;
	private String _referenceUid;
	private String _requestType;
	private String _originalRequestType;
	private String _comment;
	private int _isNew;
	private int _originalIsNew;
	private boolean _setOriginalIsNew;
	private int _statusReg;
	private long _columnBitmask;
	private DossierRequestUD _escapedModel;
}