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

package com.liferay.campaign.manager.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.campaign.manager.model.CampaignLocalization;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CampaignLocalization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalization
 * @generated
 */
@ProviderType
public class CampaignLocalizationCacheModel implements CacheModel<CampaignLocalization>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignLocalizationCacheModel)) {
			return false;
		}

		CampaignLocalizationCacheModel campaignLocalizationCacheModel = (CampaignLocalizationCacheModel)obj;

		if (campaignLocalizationId == campaignLocalizationCacheModel.campaignLocalizationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, campaignLocalizationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{campaignLocalizationId=");
		sb.append(campaignLocalizationId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CampaignLocalization toEntityModel() {
		CampaignLocalizationImpl campaignLocalizationImpl = new CampaignLocalizationImpl();

		campaignLocalizationImpl.setCampaignLocalizationId(campaignLocalizationId);
		campaignLocalizationImpl.setCampaignId(campaignId);

		if (name == null) {
			campaignLocalizationImpl.setName(StringPool.BLANK);
		}
		else {
			campaignLocalizationImpl.setName(name);
		}

		if (description == null) {
			campaignLocalizationImpl.setDescription(StringPool.BLANK);
		}
		else {
			campaignLocalizationImpl.setDescription(description);
		}

		if (languageId == null) {
			campaignLocalizationImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			campaignLocalizationImpl.setLanguageId(languageId);
		}

		campaignLocalizationImpl.resetOriginalValues();

		return campaignLocalizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		campaignLocalizationId = objectInput.readLong();

		campaignId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		languageId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(campaignLocalizationId);

		objectOutput.writeLong(campaignId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (languageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageId);
		}
	}

	public long campaignLocalizationId;
	public long campaignId;
	public String name;
	public String description;
	public String languageId;
}