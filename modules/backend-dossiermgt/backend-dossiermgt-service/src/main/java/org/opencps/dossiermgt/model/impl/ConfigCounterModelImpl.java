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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.dossiermgt.model.ConfigCounter;
import org.opencps.dossiermgt.model.ConfigCounterModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ConfigCounter service. Represents a row in the &quot;opencps_configcounter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ConfigCounterModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ConfigCounterImpl}.
 * </p>
 *
 * @author huymq
 * @see ConfigCounterImpl
 * @see ConfigCounter
 * @see ConfigCounterModel
 * @generated
 */
@ProviderType
public class ConfigCounterModelImpl extends BaseModelImpl<ConfigCounter>
	implements ConfigCounterModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a config counter model instance should use the {@link ConfigCounter} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_configcounter";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "configCounterId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "counterCode", Types.VARCHAR },
			{ "patternCode", Types.VARCHAR },
			{ "startCounter", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("configCounterId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("counterCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("patternCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("startCounter", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_configcounter (uuid_ VARCHAR(75) null,configCounterId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(255) null,createDate DATE null,modifiedDate DATE null,counterCode VARCHAR(255) null,patternCode VARCHAR(255) null,startCounter INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table opencps_configcounter";
	public static final String ORDER_BY_JPQL = " ORDER BY configCounter.configCounterId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_configcounter.configCounterId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.ConfigCounter"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.ConfigCounter"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.ConfigCounter"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long COUNTERCODE_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long CONFIGCOUNTERID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.ConfigCounter"));

	public ConfigCounterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _configCounterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConfigCounterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _configCounterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ConfigCounter.class;
	}

	@Override
	public String getModelClassName() {
		return ConfigCounter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("configCounterId", getConfigCounterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("counterCode", getCounterCode());
		attributes.put("patternCode", getPatternCode());
		attributes.put("startCounter", getStartCounter());

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

		Long configCounterId = (Long)attributes.get("configCounterId");

		if (configCounterId != null) {
			setConfigCounterId(configCounterId);
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

		String counterCode = (String)attributes.get("counterCode");

		if (counterCode != null) {
			setCounterCode(counterCode);
		}

		String patternCode = (String)attributes.get("patternCode");

		if (patternCode != null) {
			setPatternCode(patternCode);
		}

		Integer startCounter = (Integer)attributes.get("startCounter");

		if (startCounter != null) {
			setStartCounter(startCounter);
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
	public long getConfigCounterId() {
		return _configCounterId;
	}

	@Override
	public void setConfigCounterId(long configCounterId) {
		_configCounterId = configCounterId;
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

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getCounterCode() {
		if (_counterCode == null) {
			return "";
		}
		else {
			return _counterCode;
		}
	}

	@Override
	public void setCounterCode(String counterCode) {
		_columnBitmask |= COUNTERCODE_COLUMN_BITMASK;

		if (_originalCounterCode == null) {
			_originalCounterCode = _counterCode;
		}

		_counterCode = counterCode;
	}

	public String getOriginalCounterCode() {
		return GetterUtil.getString(_originalCounterCode);
	}

	@Override
	public String getPatternCode() {
		if (_patternCode == null) {
			return "";
		}
		else {
			return _patternCode;
		}
	}

	@Override
	public void setPatternCode(String patternCode) {
		_patternCode = patternCode;
	}

	@Override
	public int getStartCounter() {
		return _startCounter;
	}

	@Override
	public void setStartCounter(int startCounter) {
		_startCounter = startCounter;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ConfigCounter.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ConfigCounter.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ConfigCounter toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ConfigCounter)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ConfigCounterImpl configCounterImpl = new ConfigCounterImpl();

		configCounterImpl.setUuid(getUuid());
		configCounterImpl.setConfigCounterId(getConfigCounterId());
		configCounterImpl.setCompanyId(getCompanyId());
		configCounterImpl.setGroupId(getGroupId());
		configCounterImpl.setUserId(getUserId());
		configCounterImpl.setUserName(getUserName());
		configCounterImpl.setCreateDate(getCreateDate());
		configCounterImpl.setModifiedDate(getModifiedDate());
		configCounterImpl.setCounterCode(getCounterCode());
		configCounterImpl.setPatternCode(getPatternCode());
		configCounterImpl.setStartCounter(getStartCounter());

		configCounterImpl.resetOriginalValues();

		return configCounterImpl;
	}

	@Override
	public int compareTo(ConfigCounter configCounter) {
		long primaryKey = configCounter.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConfigCounter)) {
			return false;
		}

		ConfigCounter configCounter = (ConfigCounter)obj;

		long primaryKey = configCounter.getPrimaryKey();

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
		ConfigCounterModelImpl configCounterModelImpl = this;

		configCounterModelImpl._originalUuid = configCounterModelImpl._uuid;

		configCounterModelImpl._originalCompanyId = configCounterModelImpl._companyId;

		configCounterModelImpl._setOriginalCompanyId = false;

		configCounterModelImpl._originalGroupId = configCounterModelImpl._groupId;

		configCounterModelImpl._setOriginalGroupId = false;

		configCounterModelImpl._setModifiedDate = false;

		configCounterModelImpl._originalCounterCode = configCounterModelImpl._counterCode;

		configCounterModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ConfigCounter> toCacheModel() {
		ConfigCounterCacheModel configCounterCacheModel = new ConfigCounterCacheModel();

		configCounterCacheModel.uuid = getUuid();

		String uuid = configCounterCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			configCounterCacheModel.uuid = null;
		}

		configCounterCacheModel.configCounterId = getConfigCounterId();

		configCounterCacheModel.companyId = getCompanyId();

		configCounterCacheModel.groupId = getGroupId();

		configCounterCacheModel.userId = getUserId();

		configCounterCacheModel.userName = getUserName();

		String userName = configCounterCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			configCounterCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			configCounterCacheModel.createDate = createDate.getTime();
		}
		else {
			configCounterCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			configCounterCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			configCounterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		configCounterCacheModel.counterCode = getCounterCode();

		String counterCode = configCounterCacheModel.counterCode;

		if ((counterCode != null) && (counterCode.length() == 0)) {
			configCounterCacheModel.counterCode = null;
		}

		configCounterCacheModel.patternCode = getPatternCode();

		String patternCode = configCounterCacheModel.patternCode;

		if ((patternCode != null) && (patternCode.length() == 0)) {
			configCounterCacheModel.patternCode = null;
		}

		configCounterCacheModel.startCounter = getStartCounter();

		return configCounterCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", configCounterId=");
		sb.append(getConfigCounterId());
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
		sb.append(", counterCode=");
		sb.append(getCounterCode());
		sb.append(", patternCode=");
		sb.append(getPatternCode());
		sb.append(", startCounter=");
		sb.append(getStartCounter());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.ConfigCounter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>configCounterId</column-name><column-value><![CDATA[");
		sb.append(getConfigCounterId());
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
			"<column><column-name>counterCode</column-name><column-value><![CDATA[");
		sb.append(getCounterCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patternCode</column-name><column-value><![CDATA[");
		sb.append(getPatternCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startCounter</column-name><column-value><![CDATA[");
		sb.append(getStartCounter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ConfigCounter.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ConfigCounter.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _configCounterId;
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
	private String _counterCode;
	private String _originalCounterCode;
	private String _patternCode;
	private int _startCounter;
	private long _columnBitmask;
	private ConfigCounter _escapedModel;
}