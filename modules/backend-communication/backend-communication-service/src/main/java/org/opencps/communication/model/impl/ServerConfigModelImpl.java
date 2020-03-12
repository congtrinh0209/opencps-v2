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

package org.opencps.communication.model.impl;

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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.communication.model.ServerConfig;
import org.opencps.communication.model.ServerConfigModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ServerConfig service. Represents a row in the &quot;opencps_serverconfig&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ServerConfigModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ServerConfigImpl}.
 * </p>
 *
 * @author khoavd
 * @see ServerConfigImpl
 * @see ServerConfig
 * @see ServerConfigModel
 * @generated
 */
@ProviderType
public class ServerConfigModelImpl extends BaseModelImpl<ServerConfig>
	implements ServerConfigModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a server config model instance should use the {@link ServerConfig} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_serverconfig";
	public static final Object[][] TABLE_COLUMNS = {
			{ "serverConfigId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "govAgencyCode", Types.VARCHAR },
			{ "serverNo", Types.VARCHAR },
			{ "serverName", Types.VARCHAR },
			{ "protocol", Types.VARCHAR },
			{ "configs", Types.CLOB },
			{ "lastSync", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("serverConfigId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("govAgencyCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serverNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serverName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("protocol", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("configs", Types.CLOB);
		TABLE_COLUMNS_MAP.put("lastSync", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_serverconfig (serverConfigId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(255) null,createDate DATE null,modifiedDate DATE null,govAgencyCode VARCHAR(255) null,serverNo VARCHAR(255) null,serverName TEXT null,protocol VARCHAR(255) null,configs TEXT null,lastSync DATE null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_serverconfig";
	public static final String ORDER_BY_JPQL = " ORDER BY serverConfig.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_serverconfig.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(backend.communication.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.communication.model.ServerConfig"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(backend.communication.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.communication.model.ServerConfig"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(backend.communication.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.communication.model.ServerConfig"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long PROTOCOL_COLUMN_BITMASK = 2L;
	public static final long SERVERNAME_COLUMN_BITMASK = 4L;
	public static final long SERVERNO_COLUMN_BITMASK = 8L;
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(backend.communication.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.communication.model.ServerConfig"));

	public ServerConfigModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _serverConfigId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setServerConfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _serverConfigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ServerConfig.class;
	}

	@Override
	public String getModelClassName() {
		return ServerConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serverConfigId", getServerConfigId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("serverNo", getServerNo());
		attributes.put("serverName", getServerName());
		attributes.put("protocol", getProtocol());
		attributes.put("configs", getConfigs());
		attributes.put("lastSync", getLastSync());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serverConfigId = (Long)attributes.get("serverConfigId");

		if (serverConfigId != null) {
			setServerConfigId(serverConfigId);
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

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		String serverNo = (String)attributes.get("serverNo");

		if (serverNo != null) {
			setServerNo(serverNo);
		}

		String serverName = (String)attributes.get("serverName");

		if (serverName != null) {
			setServerName(serverName);
		}

		String protocol = (String)attributes.get("protocol");

		if (protocol != null) {
			setProtocol(protocol);
		}

		String configs = (String)attributes.get("configs");

		if (configs != null) {
			setConfigs(configs);
		}

		Date lastSync = (Date)attributes.get("lastSync");

		if (lastSync != null) {
			setLastSync(lastSync);
		}
	}

	@Override
	public long getServerConfigId() {
		return _serverConfigId;
	}

	@Override
	public void setServerConfigId(long serverConfigId) {
		_serverConfigId = serverConfigId;
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
		_columnBitmask = -1L;

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
	public String getGovAgencyCode() {
		if (_govAgencyCode == null) {
			return "";
		}
		else {
			return _govAgencyCode;
		}
	}

	@Override
	public void setGovAgencyCode(String govAgencyCode) {
		_govAgencyCode = govAgencyCode;
	}

	@Override
	public String getServerNo() {
		if (_serverNo == null) {
			return "";
		}
		else {
			return _serverNo;
		}
	}

	@Override
	public void setServerNo(String serverNo) {
		_columnBitmask |= SERVERNO_COLUMN_BITMASK;

		if (_originalServerNo == null) {
			_originalServerNo = _serverNo;
		}

		_serverNo = serverNo;
	}

	public String getOriginalServerNo() {
		return GetterUtil.getString(_originalServerNo);
	}

	@Override
	public String getServerName() {
		if (_serverName == null) {
			return "";
		}
		else {
			return _serverName;
		}
	}

	@Override
	public void setServerName(String serverName) {
		_columnBitmask |= SERVERNAME_COLUMN_BITMASK;

		if (_originalServerName == null) {
			_originalServerName = _serverName;
		}

		_serverName = serverName;
	}

	public String getOriginalServerName() {
		return GetterUtil.getString(_originalServerName);
	}

	@Override
	public String getProtocol() {
		if (_protocol == null) {
			return "";
		}
		else {
			return _protocol;
		}
	}

	@Override
	public void setProtocol(String protocol) {
		_columnBitmask |= PROTOCOL_COLUMN_BITMASK;

		if (_originalProtocol == null) {
			_originalProtocol = _protocol;
		}

		_protocol = protocol;
	}

	public String getOriginalProtocol() {
		return GetterUtil.getString(_originalProtocol);
	}

	@Override
	public String getConfigs() {
		if (_configs == null) {
			return "";
		}
		else {
			return _configs;
		}
	}

	@Override
	public void setConfigs(String configs) {
		_configs = configs;
	}

	@Override
	public Date getLastSync() {
		return _lastSync;
	}

	@Override
	public void setLastSync(Date lastSync) {
		_lastSync = lastSync;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ServerConfig.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ServerConfig toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ServerConfig)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ServerConfigImpl serverConfigImpl = new ServerConfigImpl();

		serverConfigImpl.setServerConfigId(getServerConfigId());
		serverConfigImpl.setGroupId(getGroupId());
		serverConfigImpl.setCompanyId(getCompanyId());
		serverConfigImpl.setUserId(getUserId());
		serverConfigImpl.setUserName(getUserName());
		serverConfigImpl.setCreateDate(getCreateDate());
		serverConfigImpl.setModifiedDate(getModifiedDate());
		serverConfigImpl.setGovAgencyCode(getGovAgencyCode());
		serverConfigImpl.setServerNo(getServerNo());
		serverConfigImpl.setServerName(getServerName());
		serverConfigImpl.setProtocol(getProtocol());
		serverConfigImpl.setConfigs(getConfigs());
		serverConfigImpl.setLastSync(getLastSync());

		serverConfigImpl.resetOriginalValues();

		return serverConfigImpl;
	}

	@Override
	public int compareTo(ServerConfig serverConfig) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), serverConfig.getCreateDate());

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

		if (!(obj instanceof ServerConfig)) {
			return false;
		}

		ServerConfig serverConfig = (ServerConfig)obj;

		long primaryKey = serverConfig.getPrimaryKey();

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
		ServerConfigModelImpl serverConfigModelImpl = this;

		serverConfigModelImpl._originalGroupId = serverConfigModelImpl._groupId;

		serverConfigModelImpl._setOriginalGroupId = false;

		serverConfigModelImpl._setModifiedDate = false;

		serverConfigModelImpl._originalServerNo = serverConfigModelImpl._serverNo;

		serverConfigModelImpl._originalServerName = serverConfigModelImpl._serverName;

		serverConfigModelImpl._originalProtocol = serverConfigModelImpl._protocol;

		serverConfigModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ServerConfig> toCacheModel() {
		ServerConfigCacheModel serverConfigCacheModel = new ServerConfigCacheModel();

		serverConfigCacheModel.serverConfigId = getServerConfigId();

		serverConfigCacheModel.groupId = getGroupId();

		serverConfigCacheModel.companyId = getCompanyId();

		serverConfigCacheModel.userId = getUserId();

		serverConfigCacheModel.userName = getUserName();

		String userName = serverConfigCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			serverConfigCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			serverConfigCacheModel.createDate = createDate.getTime();
		}
		else {
			serverConfigCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			serverConfigCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			serverConfigCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		serverConfigCacheModel.govAgencyCode = getGovAgencyCode();

		String govAgencyCode = serverConfigCacheModel.govAgencyCode;

		if ((govAgencyCode != null) && (govAgencyCode.length() == 0)) {
			serverConfigCacheModel.govAgencyCode = null;
		}

		serverConfigCacheModel.serverNo = getServerNo();

		String serverNo = serverConfigCacheModel.serverNo;

		if ((serverNo != null) && (serverNo.length() == 0)) {
			serverConfigCacheModel.serverNo = null;
		}

		serverConfigCacheModel.serverName = getServerName();

		String serverName = serverConfigCacheModel.serverName;

		if ((serverName != null) && (serverName.length() == 0)) {
			serverConfigCacheModel.serverName = null;
		}

		serverConfigCacheModel.protocol = getProtocol();

		String protocol = serverConfigCacheModel.protocol;

		if ((protocol != null) && (protocol.length() == 0)) {
			serverConfigCacheModel.protocol = null;
		}

		serverConfigCacheModel.configs = getConfigs();

		String configs = serverConfigCacheModel.configs;

		if ((configs != null) && (configs.length() == 0)) {
			serverConfigCacheModel.configs = null;
		}

		Date lastSync = getLastSync();

		if (lastSync != null) {
			serverConfigCacheModel.lastSync = lastSync.getTime();
		}
		else {
			serverConfigCacheModel.lastSync = Long.MIN_VALUE;
		}

		return serverConfigCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{serverConfigId=");
		sb.append(getServerConfigId());
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
		sb.append(", govAgencyCode=");
		sb.append(getGovAgencyCode());
		sb.append(", serverNo=");
		sb.append(getServerNo());
		sb.append(", serverName=");
		sb.append(getServerName());
		sb.append(", protocol=");
		sb.append(getProtocol());
		sb.append(", configs=");
		sb.append(getConfigs());
		sb.append(", lastSync=");
		sb.append(getLastSync());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.opencps.communication.model.ServerConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>serverConfigId</column-name><column-value><![CDATA[");
		sb.append(getServerConfigId());
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
			"<column><column-name>govAgencyCode</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverNo</column-name><column-value><![CDATA[");
		sb.append(getServerNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverName</column-name><column-value><![CDATA[");
		sb.append(getServerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>protocol</column-name><column-value><![CDATA[");
		sb.append(getProtocol());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>configs</column-name><column-value><![CDATA[");
		sb.append(getConfigs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastSync</column-name><column-value><![CDATA[");
		sb.append(getLastSync());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ServerConfig.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ServerConfig.class, ModelWrapper.class
		};
	private long _serverConfigId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _govAgencyCode;
	private String _serverNo;
	private String _originalServerNo;
	private String _serverName;
	private String _originalServerName;
	private String _protocol;
	private String _originalProtocol;
	private String _configs;
	private Date _lastSync;
	private long _columnBitmask;
	private ServerConfig _escapedModel;
}