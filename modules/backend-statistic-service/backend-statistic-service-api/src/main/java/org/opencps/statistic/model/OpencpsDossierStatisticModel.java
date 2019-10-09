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

package org.opencps.statistic.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the OpencpsDossierStatistic service. Represents a row in the &quot;opencps_statistic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.statistic.model.impl.OpencpsDossierStatisticModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.statistic.model.impl.OpencpsDossierStatisticImpl}.
 * </p>
 *
 * @author khoavu
 * @see OpencpsDossierStatistic
 * @see org.opencps.statistic.model.impl.OpencpsDossierStatisticImpl
 * @see org.opencps.statistic.model.impl.OpencpsDossierStatisticModelImpl
 * @generated
 */
@ProviderType
public interface OpencpsDossierStatisticModel extends BaseModel<OpencpsDossierStatistic>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a opencps dossier statistic model instance should use the {@link OpencpsDossierStatistic} interface instead.
	 */

	/**
	 * Returns the primary key of this opencps dossier statistic.
	 *
	 * @return the primary key of this opencps dossier statistic
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this opencps dossier statistic.
	 *
	 * @param primaryKey the primary key of this opencps dossier statistic
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this opencps dossier statistic.
	 *
	 * @return the uuid of this opencps dossier statistic
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this opencps dossier statistic.
	 *
	 * @param uuid the uuid of this opencps dossier statistic
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the dossier statistic ID of this opencps dossier statistic.
	 *
	 * @return the dossier statistic ID of this opencps dossier statistic
	 */
	public long getDossierStatisticId();

	/**
	 * Sets the dossier statistic ID of this opencps dossier statistic.
	 *
	 * @param dossierStatisticId the dossier statistic ID of this opencps dossier statistic
	 */
	public void setDossierStatisticId(long dossierStatisticId);

	/**
	 * Returns the company ID of this opencps dossier statistic.
	 *
	 * @return the company ID of this opencps dossier statistic
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this opencps dossier statistic.
	 *
	 * @param companyId the company ID of this opencps dossier statistic
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this opencps dossier statistic.
	 *
	 * @return the group ID of this opencps dossier statistic
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this opencps dossier statistic.
	 *
	 * @param groupId the group ID of this opencps dossier statistic
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this opencps dossier statistic.
	 *
	 * @return the user ID of this opencps dossier statistic
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this opencps dossier statistic.
	 *
	 * @param userId the user ID of this opencps dossier statistic
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this opencps dossier statistic.
	 *
	 * @return the user uuid of this opencps dossier statistic
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this opencps dossier statistic.
	 *
	 * @param userUuid the user uuid of this opencps dossier statistic
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this opencps dossier statistic.
	 *
	 * @return the user name of this opencps dossier statistic
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this opencps dossier statistic.
	 *
	 * @param userName the user name of this opencps dossier statistic
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this opencps dossier statistic.
	 *
	 * @return the create date of this opencps dossier statistic
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this opencps dossier statistic.
	 *
	 * @param createDate the create date of this opencps dossier statistic
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this opencps dossier statistic.
	 *
	 * @return the modified date of this opencps dossier statistic
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this opencps dossier statistic.
	 *
	 * @param modifiedDate the modified date of this opencps dossier statistic
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the month of this opencps dossier statistic.
	 *
	 * @return the month of this opencps dossier statistic
	 */
	public int getMonth();

	/**
	 * Sets the month of this opencps dossier statistic.
	 *
	 * @param month the month of this opencps dossier statistic
	 */
	public void setMonth(int month);

	/**
	 * Returns the year of this opencps dossier statistic.
	 *
	 * @return the year of this opencps dossier statistic
	 */
	public int getYear();

	/**
	 * Sets the year of this opencps dossier statistic.
	 *
	 * @param year the year of this opencps dossier statistic
	 */
	public void setYear(int year);

	/**
	 * Returns the total count of this opencps dossier statistic.
	 *
	 * @return the total count of this opencps dossier statistic
	 */
	public int getTotalCount();

	/**
	 * Sets the total count of this opencps dossier statistic.
	 *
	 * @param totalCount the total count of this opencps dossier statistic
	 */
	public void setTotalCount(int totalCount);

	/**
	 * Returns the denied count of this opencps dossier statistic.
	 *
	 * @return the denied count of this opencps dossier statistic
	 */
	public int getDeniedCount();

	/**
	 * Sets the denied count of this opencps dossier statistic.
	 *
	 * @param deniedCount the denied count of this opencps dossier statistic
	 */
	public void setDeniedCount(int deniedCount);

	/**
	 * Returns the cancelled count of this opencps dossier statistic.
	 *
	 * @return the cancelled count of this opencps dossier statistic
	 */
	public int getCancelledCount();

	/**
	 * Sets the cancelled count of this opencps dossier statistic.
	 *
	 * @param cancelledCount the cancelled count of this opencps dossier statistic
	 */
	public void setCancelledCount(int cancelledCount);

	/**
	 * Returns the process count of this opencps dossier statistic.
	 *
	 * @return the process count of this opencps dossier statistic
	 */
	public int getProcessCount();

	/**
	 * Sets the process count of this opencps dossier statistic.
	 *
	 * @param processCount the process count of this opencps dossier statistic
	 */
	public void setProcessCount(int processCount);

	/**
	 * Returns the remaining count of this opencps dossier statistic.
	 *
	 * @return the remaining count of this opencps dossier statistic
	 */
	public int getRemainingCount();

	/**
	 * Sets the remaining count of this opencps dossier statistic.
	 *
	 * @param remainingCount the remaining count of this opencps dossier statistic
	 */
	public void setRemainingCount(int remainingCount);

	/**
	 * Returns the received count of this opencps dossier statistic.
	 *
	 * @return the received count of this opencps dossier statistic
	 */
	public int getReceivedCount();

	/**
	 * Sets the received count of this opencps dossier statistic.
	 *
	 * @param receivedCount the received count of this opencps dossier statistic
	 */
	public void setReceivedCount(int receivedCount);

	/**
	 * Returns the online count of this opencps dossier statistic.
	 *
	 * @return the online count of this opencps dossier statistic
	 */
	public int getOnlineCount();

	/**
	 * Sets the online count of this opencps dossier statistic.
	 *
	 * @param onlineCount the online count of this opencps dossier statistic
	 */
	public void setOnlineCount(int onlineCount);

	/**
	 * Returns the onegate count of this opencps dossier statistic.
	 *
	 * @return the onegate count of this opencps dossier statistic
	 */
	public int getOnegateCount();

	/**
	 * Sets the onegate count of this opencps dossier statistic.
	 *
	 * @param onegateCount the onegate count of this opencps dossier statistic
	 */
	public void setOnegateCount(int onegateCount);

	/**
	 * Returns the release count of this opencps dossier statistic.
	 *
	 * @return the release count of this opencps dossier statistic
	 */
	public int getReleaseCount();

	/**
	 * Sets the release count of this opencps dossier statistic.
	 *
	 * @param releaseCount the release count of this opencps dossier statistic
	 */
	public void setReleaseCount(int releaseCount);

	/**
	 * Returns the betimes count of this opencps dossier statistic.
	 *
	 * @return the betimes count of this opencps dossier statistic
	 */
	public int getBetimesCount();

	/**
	 * Sets the betimes count of this opencps dossier statistic.
	 *
	 * @param betimesCount the betimes count of this opencps dossier statistic
	 */
	public void setBetimesCount(int betimesCount);

	/**
	 * Returns the ontime count of this opencps dossier statistic.
	 *
	 * @return the ontime count of this opencps dossier statistic
	 */
	public int getOntimeCount();

	/**
	 * Sets the ontime count of this opencps dossier statistic.
	 *
	 * @param ontimeCount the ontime count of this opencps dossier statistic
	 */
	public void setOntimeCount(int ontimeCount);

	/**
	 * Returns the overtime count of this opencps dossier statistic.
	 *
	 * @return the overtime count of this opencps dossier statistic
	 */
	public int getOvertimeCount();

	/**
	 * Sets the overtime count of this opencps dossier statistic.
	 *
	 * @param overtimeCount the overtime count of this opencps dossier statistic
	 */
	public void setOvertimeCount(int overtimeCount);

	/**
	 * Returns the done count of this opencps dossier statistic.
	 *
	 * @return the done count of this opencps dossier statistic
	 */
	public int getDoneCount();

	/**
	 * Sets the done count of this opencps dossier statistic.
	 *
	 * @param doneCount the done count of this opencps dossier statistic
	 */
	public void setDoneCount(int doneCount);

	/**
	 * Returns the releasing count of this opencps dossier statistic.
	 *
	 * @return the releasing count of this opencps dossier statistic
	 */
	public int getReleasingCount();

	/**
	 * Sets the releasing count of this opencps dossier statistic.
	 *
	 * @param releasingCount the releasing count of this opencps dossier statistic
	 */
	public void setReleasingCount(int releasingCount);

	/**
	 * Returns the unresolved count of this opencps dossier statistic.
	 *
	 * @return the unresolved count of this opencps dossier statistic
	 */
	public int getUnresolvedCount();

	/**
	 * Sets the unresolved count of this opencps dossier statistic.
	 *
	 * @param unresolvedCount the unresolved count of this opencps dossier statistic
	 */
	public void setUnresolvedCount(int unresolvedCount);

	/**
	 * Returns the processing count of this opencps dossier statistic.
	 *
	 * @return the processing count of this opencps dossier statistic
	 */
	public int getProcessingCount();

	/**
	 * Sets the processing count of this opencps dossier statistic.
	 *
	 * @param processingCount the processing count of this opencps dossier statistic
	 */
	public void setProcessingCount(int processingCount);

	/**
	 * Returns the undue count of this opencps dossier statistic.
	 *
	 * @return the undue count of this opencps dossier statistic
	 */
	public int getUndueCount();

	/**
	 * Sets the undue count of this opencps dossier statistic.
	 *
	 * @param undueCount the undue count of this opencps dossier statistic
	 */
	public void setUndueCount(int undueCount);

	/**
	 * Returns the overdue count of this opencps dossier statistic.
	 *
	 * @return the overdue count of this opencps dossier statistic
	 */
	public int getOverdueCount();

	/**
	 * Sets the overdue count of this opencps dossier statistic.
	 *
	 * @param overdueCount the overdue count of this opencps dossier statistic
	 */
	public void setOverdueCount(int overdueCount);

	/**
	 * Returns the pausing count of this opencps dossier statistic.
	 *
	 * @return the pausing count of this opencps dossier statistic
	 */
	public int getPausingCount();

	/**
	 * Sets the pausing count of this opencps dossier statistic.
	 *
	 * @param pausingCount the pausing count of this opencps dossier statistic
	 */
	public void setPausingCount(int pausingCount);

	/**
	 * Returns the ontime percentage of this opencps dossier statistic.
	 *
	 * @return the ontime percentage of this opencps dossier statistic
	 */
	public int getOntimePercentage();

	/**
	 * Sets the ontime percentage of this opencps dossier statistic.
	 *
	 * @param ontimePercentage the ontime percentage of this opencps dossier statistic
	 */
	public void setOntimePercentage(int ontimePercentage);

	/**
	 * Returns the gov agency code of this opencps dossier statistic.
	 *
	 * @return the gov agency code of this opencps dossier statistic
	 */
	@AutoEscape
	public String getGovAgencyCode();

	/**
	 * Sets the gov agency code of this opencps dossier statistic.
	 *
	 * @param govAgencyCode the gov agency code of this opencps dossier statistic
	 */
	public void setGovAgencyCode(String govAgencyCode);

	/**
	 * Returns the group agency code of this opencps dossier statistic.
	 *
	 * @return the group agency code of this opencps dossier statistic
	 */
	@AutoEscape
	public String getGroupAgencyCode();

	/**
	 * Sets the group agency code of this opencps dossier statistic.
	 *
	 * @param groupAgencyCode the group agency code of this opencps dossier statistic
	 */
	public void setGroupAgencyCode(String groupAgencyCode);

	/**
	 * Returns the gov agency name of this opencps dossier statistic.
	 *
	 * @return the gov agency name of this opencps dossier statistic
	 */
	@AutoEscape
	public String getGovAgencyName();

	/**
	 * Sets the gov agency name of this opencps dossier statistic.
	 *
	 * @param govAgencyName the gov agency name of this opencps dossier statistic
	 */
	public void setGovAgencyName(String govAgencyName);

	/**
	 * Returns the domain code of this opencps dossier statistic.
	 *
	 * @return the domain code of this opencps dossier statistic
	 */
	@AutoEscape
	public String getDomainCode();

	/**
	 * Sets the domain code of this opencps dossier statistic.
	 *
	 * @param domainCode the domain code of this opencps dossier statistic
	 */
	public void setDomainCode(String domainCode);

	/**
	 * Returns the domain name of this opencps dossier statistic.
	 *
	 * @return the domain name of this opencps dossier statistic
	 */
	@AutoEscape
	public String getDomainName();

	/**
	 * Sets the domain name of this opencps dossier statistic.
	 *
	 * @param domainName the domain name of this opencps dossier statistic
	 */
	public void setDomainName(String domainName);

	/**
	 * Returns the reporting of this opencps dossier statistic.
	 *
	 * @return the reporting of this opencps dossier statistic
	 */
	public boolean getReporting();

	/**
	 * Returns <code>true</code> if this opencps dossier statistic is reporting.
	 *
	 * @return <code>true</code> if this opencps dossier statistic is reporting; <code>false</code> otherwise
	 */
	public boolean isReporting();

	/**
	 * Sets whether this opencps dossier statistic is reporting.
	 *
	 * @param reporting the reporting of this opencps dossier statistic
	 */
	public void setReporting(boolean reporting);

	/**
	 * Returns the overtime inside of this opencps dossier statistic.
	 *
	 * @return the overtime inside of this opencps dossier statistic
	 */
	public int getOvertimeInside();

	/**
	 * Sets the overtime inside of this opencps dossier statistic.
	 *
	 * @param overtimeInside the overtime inside of this opencps dossier statistic
	 */
	public void setOvertimeInside(int overtimeInside);

	/**
	 * Returns the overtime outside of this opencps dossier statistic.
	 *
	 * @return the overtime outside of this opencps dossier statistic
	 */
	public int getOvertimeOutside();

	/**
	 * Sets the overtime outside of this opencps dossier statistic.
	 *
	 * @param overtimeOutside the overtime outside of this opencps dossier statistic
	 */
	public void setOvertimeOutside(int overtimeOutside);

	/**
	 * Returns the interoperating count of this opencps dossier statistic.
	 *
	 * @return the interoperating count of this opencps dossier statistic
	 */
	public int getInteroperatingCount();

	/**
	 * Sets the interoperating count of this opencps dossier statistic.
	 *
	 * @param interoperatingCount the interoperating count of this opencps dossier statistic
	 */
	public void setInteroperatingCount(int interoperatingCount);

	/**
	 * Returns the waiting count of this opencps dossier statistic.
	 *
	 * @return the waiting count of this opencps dossier statistic
	 */
	public int getWaitingCount();

	/**
	 * Sets the waiting count of this opencps dossier statistic.
	 *
	 * @param waitingCount the waiting count of this opencps dossier statistic
	 */
	public void setWaitingCount(int waitingCount);

	/**
	 * Returns the outside count of this opencps dossier statistic.
	 *
	 * @return the outside count of this opencps dossier statistic
	 */
	public int getOutsideCount();

	/**
	 * Sets the outside count of this opencps dossier statistic.
	 *
	 * @param outsideCount the outside count of this opencps dossier statistic
	 */
	public void setOutsideCount(int outsideCount);

	/**
	 * Returns the inside count of this opencps dossier statistic.
	 *
	 * @return the inside count of this opencps dossier statistic
	 */
	public int getInsideCount();

	/**
	 * Sets the inside count of this opencps dossier statistic.
	 *
	 * @param insideCount the inside count of this opencps dossier statistic
	 */
	public void setInsideCount(int insideCount);

	/**
	 * Returns the system of this opencps dossier statistic.
	 *
	 * @return the system of this opencps dossier statistic
	 */
	@AutoEscape
	public String getSystem();

	/**
	 * Sets the system of this opencps dossier statistic.
	 *
	 * @param system the system of this opencps dossier statistic
	 */
	public void setSystem(String system);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(OpencpsDossierStatistic opencpsDossierStatistic);

	@Override
	public int hashCode();

	@Override
	public CacheModel<OpencpsDossierStatistic> toCacheModel();

	@Override
	public OpencpsDossierStatistic toEscapedModel();

	@Override
	public OpencpsDossierStatistic toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}