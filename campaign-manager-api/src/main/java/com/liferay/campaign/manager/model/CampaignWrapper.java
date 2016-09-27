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

package com.liferay.campaign.manager.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Campaign}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Campaign
 * @generated
 */
@ProviderType
public class CampaignWrapper implements Campaign, ModelWrapper<Campaign> {
	public CampaignWrapper(Campaign campaign) {
		_campaign = campaign;
	}

	@Override
	public Class<?> getModelClass() {
		return Campaign.class;
	}

	@Override
	public String getModelClassName() {
		return Campaign.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("campaignId", getCampaignId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Campaign toEscapedModel() {
		return new CampaignWrapper(_campaign.toEscapedModel());
	}

	@Override
	public Campaign toUnescapedModel() {
		return new CampaignWrapper(_campaign.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _campaign.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _campaign.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _campaign.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _campaign.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Campaign> toCacheModel() {
		return _campaign.toCacheModel();
	}

	@Override
	public int compareTo(Campaign campaign) {
		return _campaign.compareTo(campaign);
	}

	/**
	* Returns the status of this campaign.
	*
	* @return the status of this campaign
	*/
	@Override
	public int getStatus() {
		return _campaign.getStatus();
	}

	@Override
	public int hashCode() {
		return _campaign.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campaign.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignWrapper((Campaign)_campaign.clone());
	}

	@Override
	public java.lang.String getDescription() {
		return _campaign.getDescription();
	}

	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _campaign.getDescription(locale);
	}

	@Override
	public java.lang.String getDescriptionMapAsXML() {
		return _campaign.getDescriptionMapAsXML();
	}

	@Override
	public java.lang.String getName() {
		return _campaign.getName();
	}

	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _campaign.getName(locale);
	}

	@Override
	public java.lang.String getNameMapAsXML() {
		return _campaign.getNameMapAsXML();
	}

	@Override
	public java.lang.String getStatusLabel() {
		return _campaign.getStatusLabel();
	}

	/**
	* Returns the user name of this campaign.
	*
	* @return the user name of this campaign
	*/
	@Override
	public java.lang.String getUserName() {
		return _campaign.getUserName();
	}

	/**
	* Returns the user uuid of this campaign.
	*
	* @return the user uuid of this campaign
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _campaign.getUserUuid();
	}

	/**
	* Returns the uuid of this campaign.
	*
	* @return the uuid of this campaign
	*/
	@Override
	public java.lang.String getUuid() {
		return _campaign.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _campaign.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaign.toXmlString();
	}

	/**
	* Returns the create date of this campaign.
	*
	* @return the create date of this campaign
	*/
	@Override
	public Date getCreateDate() {
		return _campaign.getCreateDate();
	}

	/**
	* Returns the end date of this campaign.
	*
	* @return the end date of this campaign
	*/
	@Override
	public Date getEndDate() {
		return _campaign.getEndDate();
	}

	/**
	* Returns the modified date of this campaign.
	*
	* @return the modified date of this campaign
	*/
	@Override
	public Date getModifiedDate() {
		return _campaign.getModifiedDate();
	}

	/**
	* Returns the start date of this campaign.
	*
	* @return the start date of this campaign
	*/
	@Override
	public Date getStartDate() {
		return _campaign.getStartDate();
	}

	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _campaign.getDescriptionMap();
	}

	@Override
	public Map<java.util.Locale, java.lang.String> getNameMap() {
		return _campaign.getNameMap();
	}

	/**
	* Returns the campaign ID of this campaign.
	*
	* @return the campaign ID of this campaign
	*/
	@Override
	public long getCampaignId() {
		return _campaign.getCampaignId();
	}

	/**
	* Returns the company ID of this campaign.
	*
	* @return the company ID of this campaign
	*/
	@Override
	public long getCompanyId() {
		return _campaign.getCompanyId();
	}

	/**
	* Returns the group ID of this campaign.
	*
	* @return the group ID of this campaign
	*/
	@Override
	public long getGroupId() {
		return _campaign.getGroupId();
	}

	/**
	* Returns the primary key of this campaign.
	*
	* @return the primary key of this campaign
	*/
	@Override
	public long getPrimaryKey() {
		return _campaign.getPrimaryKey();
	}

	/**
	* Returns the user ID of this campaign.
	*
	* @return the user ID of this campaign
	*/
	@Override
	public long getUserId() {
		return _campaign.getUserId();
	}

	@Override
	public void persist() {
		_campaign.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaign.setCachedModel(cachedModel);
	}

	/**
	* Sets the campaign ID of this campaign.
	*
	* @param campaignId the campaign ID of this campaign
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_campaign.setCampaignId(campaignId);
	}

	/**
	* Sets the company ID of this campaign.
	*
	* @param companyId the company ID of this campaign
	*/
	@Override
	public void setCompanyId(long companyId) {
		_campaign.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this campaign.
	*
	* @param createDate the create date of this campaign
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_campaign.setCreateDate(createDate);
	}

	/**
	* Sets the end date of this campaign.
	*
	* @param endDate the end date of this campaign
	*/
	@Override
	public void setEndDate(Date endDate) {
		_campaign.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_campaign.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_campaign.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_campaign.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this campaign.
	*
	* @param groupId the group ID of this campaign
	*/
	@Override
	public void setGroupId(long groupId) {
		_campaign.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this campaign.
	*
	* @param modifiedDate the modified date of this campaign
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_campaign.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_campaign.setNew(n);
	}

	/**
	* Sets the primary key of this campaign.
	*
	* @param primaryKey the primary key of this campaign
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaign.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_campaign.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start date of this campaign.
	*
	* @param startDate the start date of this campaign
	*/
	@Override
	public void setStartDate(Date startDate) {
		_campaign.setStartDate(startDate);
	}

	/**
	* Sets the status of this campaign.
	*
	* @param status the status of this campaign
	*/
	@Override
	public void setStatus(int status) {
		_campaign.setStatus(status);
	}

	/**
	* Sets the user ID of this campaign.
	*
	* @param userId the user ID of this campaign
	*/
	@Override
	public void setUserId(long userId) {
		_campaign.setUserId(userId);
	}

	/**
	* Sets the user name of this campaign.
	*
	* @param userName the user name of this campaign
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_campaign.setUserName(userName);
	}

	/**
	* Sets the user uuid of this campaign.
	*
	* @param userUuid the user uuid of this campaign
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_campaign.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this campaign.
	*
	* @param uuid the uuid of this campaign
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_campaign.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignWrapper)) {
			return false;
		}

		CampaignWrapper campaignWrapper = (CampaignWrapper)obj;

		if (Objects.equals(_campaign, campaignWrapper._campaign)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _campaign.getStagedModelType();
	}

	@Override
	public Campaign getWrappedModel() {
		return _campaign;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _campaign.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _campaign.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_campaign.resetOriginalValues();
	}

	private final Campaign _campaign;
}