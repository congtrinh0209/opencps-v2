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

package org.opencps.adminconfig.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.adminconfig.model.DynamicReport;
import org.opencps.adminconfig.model.DynamicReportModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DynamicReport service. Represents a row in the &quot;opencps_dynamicreport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DynamicReportModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DynamicReportImpl}.
 * </p>
 *
 * @author binhth
 * @see DynamicReportImpl
 * @see DynamicReport
 * @see DynamicReportModel
 * @generated
 */
@ProviderType
public class DynamicReportModelImpl extends BaseModelImpl<DynamicReport>
	implements DynamicReportModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dynamic report model instance should use the {@link DynamicReport} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_dynamicreport";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dynamicReportId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "sharing", Types.INTEGER },
			{ "reportName", Types.VARCHAR },
			{ "reportCode", Types.VARCHAR },
			{ "filterConfig", Types.VARCHAR },
			{ "tableConfig", Types.VARCHAR },
			{ "userConfig", Types.VARCHAR },
			{ "reportType", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("dynamicReportId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("sharing", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("reportName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("reportCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filterConfig", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tableConfig", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userConfig", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("reportType", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_dynamicreport (dynamicReportId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(255) null,createDate DATE null,modifiedDate DATE null,sharing INTEGER,reportName VARCHAR(1024) null,reportCode VARCHAR(128) null,filterConfig TEXT null,tableConfig TEXT null,userConfig VARCHAR(1000) null,reportType VARCHAR(128) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_dynamicreport";
	public static final String ORDER_BY_JPQL = " ORDER BY dynamicReport.reportCode ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_dynamicreport.reportCode ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(backend.admin.config.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.adminconfig.model.DynamicReport"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(backend.admin.config.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.adminconfig.model.DynamicReport"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(backend.admin.config.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.adminconfig.model.DynamicReport"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long REPORTCODE_COLUMN_BITMASK = 2L;
	public static final long REPORTTYPE_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(backend.admin.config.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.adminconfig.model.DynamicReport"));

	public DynamicReportModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dynamicReportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDynamicReportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dynamicReportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DynamicReport.class;
	}

	@Override
	public String getModelClassName() {
		return DynamicReport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dynamicReportId", getDynamicReportId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("sharing", getSharing());
		attributes.put("reportName", getReportName());
		attributes.put("reportCode", getReportCode());
		attributes.put("filterConfig", getFilterConfig());
		attributes.put("tableConfig", getTableConfig());
		attributes.put("userConfig", getUserConfig());
		attributes.put("reportType", getReportType());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dynamicReportId = (Long)attributes.get("dynamicReportId");

		if (dynamicReportId != null) {
			setDynamicReportId(dynamicReportId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Integer sharing = (Integer)attributes.get("sharing");

		if (sharing != null) {
			setSharing(sharing);
		}

		String reportName = (String)attributes.get("reportName");

		if (reportName != null) {
			setReportName(reportName);
		}

		String reportCode = (String)attributes.get("reportCode");

		if (reportCode != null) {
			setReportCode(reportCode);
		}

		String filterConfig = (String)attributes.get("filterConfig");

		if (filterConfig != null) {
			setFilterConfig(filterConfig);
		}

		String tableConfig = (String)attributes.get("tableConfig");

		if (tableConfig != null) {
			setTableConfig(tableConfig);
		}

		String userConfig = (String)attributes.get("userConfig");

		if (userConfig != null) {
			setUserConfig(userConfig);
		}

		String reportType = (String)attributes.get("reportType");

		if (reportType != null) {
			setReportType(reportType);
		}
	}

	@Override
	public long getDynamicReportId() {
		return _dynamicReportId;
	}

	@Override
	public void setDynamicReportId(long dynamicReportId) {
		_dynamicReportId = dynamicReportId;
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
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

		_modifiedDate = modifiedDate;
	}

	@Override
	public int getSharing() {
		return _sharing;
	}

	@Override
	public void setSharing(int sharing) {
		_sharing = sharing;
	}

	@Override
	public String getReportName() {
		if (_reportName == null) {
			return "";
		}
		else {
			return _reportName;
		}
	}

	@Override
	public void setReportName(String reportName) {
		_reportName = reportName;
	}

	@Override
	public String getReportCode() {
		if (_reportCode == null) {
			return "";
		}
		else {
			return _reportCode;
		}
	}

	@Override
	public void setReportCode(String reportCode) {
		_columnBitmask = -1L;

		if (_originalReportCode == null) {
			_originalReportCode = _reportCode;
		}

		_reportCode = reportCode;
	}

	public String getOriginalReportCode() {
		return GetterUtil.getString(_originalReportCode);
	}

	@Override
	public String getFilterConfig() {
		if (_filterConfig == null) {
			return "";
		}
		else {
			return _filterConfig;
		}
	}

	@Override
	public void setFilterConfig(String filterConfig) {
		_filterConfig = filterConfig;
	}

	@Override
	public String getTableConfig() {
		if (_tableConfig == null) {
			return "";
		}
		else {
			return _tableConfig;
		}
	}

	@Override
	public void setTableConfig(String tableConfig) {
		_tableConfig = tableConfig;
	}

	@Override
	public String getUserConfig() {
		if (_userConfig == null) {
			return "";
		}
		else {
			return _userConfig;
		}
	}

	@Override
	public void setUserConfig(String userConfig) {
		_userConfig = userConfig;
	}

	@Override
	public String getReportType() {
		if (_reportType == null) {
			return "";
		}
		else {
			return _reportType;
		}
	}

	@Override
	public void setReportType(String reportType) {
		_columnBitmask |= REPORTTYPE_COLUMN_BITMASK;

		if (_originalReportType == null) {
			_originalReportType = _reportType;
		}

		_reportType = reportType;
	}

	public String getOriginalReportType() {
		return GetterUtil.getString(_originalReportType);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DynamicReport.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DynamicReport toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DynamicReport)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DynamicReportImpl dynamicReportImpl = new DynamicReportImpl();

		dynamicReportImpl.setDynamicReportId(getDynamicReportId());
		dynamicReportImpl.setGroupId(getGroupId());
		dynamicReportImpl.setCompanyId(getCompanyId());
		dynamicReportImpl.setUserId(getUserId());
		dynamicReportImpl.setUserName(getUserName());
		dynamicReportImpl.setCreateDate(getCreateDate());
		dynamicReportImpl.setModifiedDate(getModifiedDate());
		dynamicReportImpl.setSharing(getSharing());
		dynamicReportImpl.setReportName(getReportName());
		dynamicReportImpl.setReportCode(getReportCode());
		dynamicReportImpl.setFilterConfig(getFilterConfig());
		dynamicReportImpl.setTableConfig(getTableConfig());
		dynamicReportImpl.setUserConfig(getUserConfig());
		dynamicReportImpl.setReportType(getReportType());

		dynamicReportImpl.resetOriginalValues();

		return dynamicReportImpl;
	}

	@Override
	public int compareTo(DynamicReport dynamicReport) {
		int value = 0;

		value = getReportCode().compareTo(dynamicReport.getReportCode());

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

		if (!(obj instanceof DynamicReport)) {
			return false;
		}

		DynamicReport dynamicReport = (DynamicReport)obj;

		long primaryKey = dynamicReport.getPrimaryKey();

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
		DynamicReportModelImpl dynamicReportModelImpl = this;

		dynamicReportModelImpl._originalGroupId = dynamicReportModelImpl._groupId;

		dynamicReportModelImpl._setOriginalGroupId = false;

		dynamicReportModelImpl._setModifiedDate = false;

		dynamicReportModelImpl._originalReportCode = dynamicReportModelImpl._reportCode;

		dynamicReportModelImpl._originalReportType = dynamicReportModelImpl._reportType;

		dynamicReportModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DynamicReport> toCacheModel() {
		DynamicReportCacheModel dynamicReportCacheModel = new DynamicReportCacheModel();

		dynamicReportCacheModel.dynamicReportId = getDynamicReportId();

		dynamicReportCacheModel.groupId = getGroupId();

		dynamicReportCacheModel.companyId = getCompanyId();

		dynamicReportCacheModel.userId = getUserId();

		dynamicReportCacheModel.userName = getUserName();

		String userName = dynamicReportCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dynamicReportCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dynamicReportCacheModel.createDate = createDate.getTime();
		}
		else {
			dynamicReportCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dynamicReportCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dynamicReportCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dynamicReportCacheModel.sharing = getSharing();

		dynamicReportCacheModel.reportName = getReportName();

		String reportName = dynamicReportCacheModel.reportName;

		if ((reportName != null) && (reportName.length() == 0)) {
			dynamicReportCacheModel.reportName = null;
		}

		dynamicReportCacheModel.reportCode = getReportCode();

		String reportCode = dynamicReportCacheModel.reportCode;

		if ((reportCode != null) && (reportCode.length() == 0)) {
			dynamicReportCacheModel.reportCode = null;
		}

		dynamicReportCacheModel.filterConfig = getFilterConfig();

		String filterConfig = dynamicReportCacheModel.filterConfig;

		if ((filterConfig != null) && (filterConfig.length() == 0)) {
			dynamicReportCacheModel.filterConfig = null;
		}

		dynamicReportCacheModel.tableConfig = getTableConfig();

		String tableConfig = dynamicReportCacheModel.tableConfig;

		if ((tableConfig != null) && (tableConfig.length() == 0)) {
			dynamicReportCacheModel.tableConfig = null;
		}

		dynamicReportCacheModel.userConfig = getUserConfig();

		String userConfig = dynamicReportCacheModel.userConfig;

		if ((userConfig != null) && (userConfig.length() == 0)) {
			dynamicReportCacheModel.userConfig = null;
		}

		dynamicReportCacheModel.reportType = getReportType();

		String reportType = dynamicReportCacheModel.reportType;

		if ((reportType != null) && (reportType.length() == 0)) {
			dynamicReportCacheModel.reportType = null;
		}

		return dynamicReportCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{dynamicReportId=");
		sb.append(getDynamicReportId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", sharing=");
		sb.append(getSharing());
		sb.append(", reportName=");
		sb.append(getReportName());
		sb.append(", reportCode=");
		sb.append(getReportCode());
		sb.append(", filterConfig=");
		sb.append(getFilterConfig());
		sb.append(", tableConfig=");
		sb.append(getTableConfig());
		sb.append(", userConfig=");
		sb.append(getUserConfig());
		sb.append(", reportType=");
		sb.append(getReportType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("org.opencps.adminconfig.model.DynamicReport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dynamicReportId</column-name><column-value><![CDATA[");
		sb.append(getDynamicReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>sharing</column-name><column-value><![CDATA[");
		sb.append(getSharing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportName</column-name><column-value><![CDATA[");
		sb.append(getReportName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportCode</column-name><column-value><![CDATA[");
		sb.append(getReportCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filterConfig</column-name><column-value><![CDATA[");
		sb.append(getFilterConfig());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tableConfig</column-name><column-value><![CDATA[");
		sb.append(getTableConfig());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userConfig</column-name><column-value><![CDATA[");
		sb.append(getUserConfig());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportType</column-name><column-value><![CDATA[");
		sb.append(getReportType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DynamicReport.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DynamicReport.class, ModelWrapper.class
		};
	private long _dynamicReportId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _sharing;
	private String _reportName;
	private String _reportCode;
	private String _originalReportCode;
	private String _filterConfig;
	private String _tableConfig;
	private String _userConfig;
	private String _reportType;
	private String _originalReportType;
	private long _columnBitmask;
	private DynamicReport _escapedModel;
}