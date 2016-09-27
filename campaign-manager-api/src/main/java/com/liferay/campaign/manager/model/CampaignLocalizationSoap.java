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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CampaignLocalizationSoap implements Serializable {
	public static CampaignLocalizationSoap toSoapModel(
		CampaignLocalization model) {
		CampaignLocalizationSoap soapModel = new CampaignLocalizationSoap();

		soapModel.setCampaignLocalizationId(model.getCampaignLocalizationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setLanguageId(model.getLanguageId());

		return soapModel;
	}

	public static CampaignLocalizationSoap[] toSoapModels(
		CampaignLocalization[] models) {
		CampaignLocalizationSoap[] soapModels = new CampaignLocalizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignLocalizationSoap[][] toSoapModels(
		CampaignLocalization[][] models) {
		CampaignLocalizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignLocalizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignLocalizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignLocalizationSoap[] toSoapModels(
		List<CampaignLocalization> models) {
		List<CampaignLocalizationSoap> soapModels = new ArrayList<CampaignLocalizationSoap>(models.size());

		for (CampaignLocalization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignLocalizationSoap[soapModels.size()]);
	}

	public CampaignLocalizationSoap() {
	}

	public long getPrimaryKey() {
		return _campaignLocalizationId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignLocalizationId(pk);
	}

	public long getCampaignLocalizationId() {
		return _campaignLocalizationId;
	}

	public void setCampaignLocalizationId(long campaignLocalizationId) {
		_campaignLocalizationId = campaignLocalizationId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	private long _campaignLocalizationId;
	private long _companyId;
	private long _groupId;
	private long _campaignId;
	private String _name;
	private String _description;
	private String _languageId;
}