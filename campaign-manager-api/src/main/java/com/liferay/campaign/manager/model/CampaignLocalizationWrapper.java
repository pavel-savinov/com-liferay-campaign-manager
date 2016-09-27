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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CampaignLocalization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalization
 * @generated
 */
@ProviderType
public class CampaignLocalizationWrapper implements CampaignLocalization,
	ModelWrapper<CampaignLocalization> {
	public CampaignLocalizationWrapper(
		CampaignLocalization campaignLocalization) {
		_campaignLocalization = campaignLocalization;
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignLocalization.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignLocalization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignLocalizationId", getCampaignLocalizationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("languageId", getLanguageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignLocalizationId = (Long)attributes.get(
				"campaignLocalizationId");

		if (campaignLocalizationId != null) {
			setCampaignLocalizationId(campaignLocalizationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}
	}

	@Override
	public CampaignLocalization toEscapedModel() {
		return new CampaignLocalizationWrapper(_campaignLocalization.toEscapedModel());
	}

	@Override
	public CampaignLocalization toUnescapedModel() {
		return new CampaignLocalizationWrapper(_campaignLocalization.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _campaignLocalization.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _campaignLocalization.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _campaignLocalization.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _campaignLocalization.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CampaignLocalization> toCacheModel() {
		return _campaignLocalization.toCacheModel();
	}

	@Override
	public int compareTo(CampaignLocalization campaignLocalization) {
		return _campaignLocalization.compareTo(campaignLocalization);
	}

	@Override
	public int hashCode() {
		return _campaignLocalization.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campaignLocalization.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignLocalizationWrapper((CampaignLocalization)_campaignLocalization.clone());
	}

	/**
	* Returns the description of this campaign localization.
	*
	* @return the description of this campaign localization
	*/
	@Override
	public java.lang.String getDescription() {
		return _campaignLocalization.getDescription();
	}

	/**
	* Returns the language ID of this campaign localization.
	*
	* @return the language ID of this campaign localization
	*/
	@Override
	public java.lang.String getLanguageId() {
		return _campaignLocalization.getLanguageId();
	}

	/**
	* Returns the name of this campaign localization.
	*
	* @return the name of this campaign localization
	*/
	@Override
	public java.lang.String getName() {
		return _campaignLocalization.getName();
	}

	@Override
	public java.lang.String toString() {
		return _campaignLocalization.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaignLocalization.toXmlString();
	}

	/**
	* Returns the campaign ID of this campaign localization.
	*
	* @return the campaign ID of this campaign localization
	*/
	@Override
	public long getCampaignId() {
		return _campaignLocalization.getCampaignId();
	}

	/**
	* Returns the campaign localization ID of this campaign localization.
	*
	* @return the campaign localization ID of this campaign localization
	*/
	@Override
	public long getCampaignLocalizationId() {
		return _campaignLocalization.getCampaignLocalizationId();
	}

	/**
	* Returns the company ID of this campaign localization.
	*
	* @return the company ID of this campaign localization
	*/
	@Override
	public long getCompanyId() {
		return _campaignLocalization.getCompanyId();
	}

	/**
	* Returns the group ID of this campaign localization.
	*
	* @return the group ID of this campaign localization
	*/
	@Override
	public long getGroupId() {
		return _campaignLocalization.getGroupId();
	}

	/**
	* Returns the primary key of this campaign localization.
	*
	* @return the primary key of this campaign localization
	*/
	@Override
	public long getPrimaryKey() {
		return _campaignLocalization.getPrimaryKey();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaignLocalization.setCachedModel(cachedModel);
	}

	/**
	* Sets the campaign ID of this campaign localization.
	*
	* @param campaignId the campaign ID of this campaign localization
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_campaignLocalization.setCampaignId(campaignId);
	}

	/**
	* Sets the campaign localization ID of this campaign localization.
	*
	* @param campaignLocalizationId the campaign localization ID of this campaign localization
	*/
	@Override
	public void setCampaignLocalizationId(long campaignLocalizationId) {
		_campaignLocalization.setCampaignLocalizationId(campaignLocalizationId);
	}

	/**
	* Sets the company ID of this campaign localization.
	*
	* @param companyId the company ID of this campaign localization
	*/
	@Override
	public void setCompanyId(long companyId) {
		_campaignLocalization.setCompanyId(companyId);
	}

	/**
	* Sets the description of this campaign localization.
	*
	* @param description the description of this campaign localization
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_campaignLocalization.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_campaignLocalization.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_campaignLocalization.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_campaignLocalization.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this campaign localization.
	*
	* @param groupId the group ID of this campaign localization
	*/
	@Override
	public void setGroupId(long groupId) {
		_campaignLocalization.setGroupId(groupId);
	}

	/**
	* Sets the language ID of this campaign localization.
	*
	* @param languageId the language ID of this campaign localization
	*/
	@Override
	public void setLanguageId(java.lang.String languageId) {
		_campaignLocalization.setLanguageId(languageId);
	}

	/**
	* Sets the name of this campaign localization.
	*
	* @param name the name of this campaign localization
	*/
	@Override
	public void setName(java.lang.String name) {
		_campaignLocalization.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_campaignLocalization.setNew(n);
	}

	/**
	* Sets the primary key of this campaign localization.
	*
	* @param primaryKey the primary key of this campaign localization
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaignLocalization.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_campaignLocalization.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignLocalizationWrapper)) {
			return false;
		}

		CampaignLocalizationWrapper campaignLocalizationWrapper = (CampaignLocalizationWrapper)obj;

		if (Objects.equals(_campaignLocalization,
					campaignLocalizationWrapper._campaignLocalization)) {
			return true;
		}

		return false;
	}

	@Override
	public CampaignLocalization getWrappedModel() {
		return _campaignLocalization;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _campaignLocalization.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _campaignLocalization.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_campaignLocalization.resetOriginalValues();
	}

	private final CampaignLocalization _campaignLocalization;
}