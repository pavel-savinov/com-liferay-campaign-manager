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

package com.liferay.campaign.manager.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.campaign.manager.exception.NoSuchCampaignException;
import com.liferay.campaign.manager.model.Campaign;
import com.liferay.campaign.manager.model.CampaignLocalization;
import com.liferay.campaign.manager.service.base.CampaignLocalServiceBaseImpl;
import com.liferay.campaign.manager.util.CampaignStatus;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * The implementation of the campaign local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.campaign.manager.service.CampaignLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalServiceBaseImpl
 * @see com.liferay.campaign.manager.service.CampaignLocalServiceUtil
 */
@ProviderType
public class CampaignLocalServiceImpl extends CampaignLocalServiceBaseImpl {

	@Override
	public Campaign addCampaign(
			long userId, long groupId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			CampaignStatus status, ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		long campaignId = counterLocalService.increment();

		Campaign campaign = campaignPersistence.create(campaignId);

		Date now = new Date();

		campaign.setUuid(serviceContext.getUuid());
		campaign.setGroupId(groupId);
		campaign.setCompanyId(user.getCompanyId());
		campaign.setCreateDate(serviceContext.getCreateDate(now));
		campaign.setModifiedDate(serviceContext.getModifiedDate(now));
		campaign.setUserId(user.getUserId());
		campaign.setUserName(user.getFullName());

		updateCampaignLocalization(campaign, nameMap, descriptionMap);

		campaign.setStartDate(startDate);
		campaign.setEndDate(endDate);
		campaign.setStatus(status.ordinal());

		campaignPersistence.update(campaign);

		return campaign;
	}

	@Override
	public Campaign deleteCampaign(long groupId, long campaignId)
		throws PortalException {

		return campaignPersistence.removeByG_C(groupId, campaignId);
	}

	@Override
	public Campaign getCampaign(long groupId, long campaignId)
		throws PortalException {

		return campaignPersistence.findByG_C(groupId, campaignId);
	}

	@Override
	public String getCampaignDescription(Campaign campaign, Locale locale) {
		CampaignLocalization campaignLocalization =
			campaignLocalizationPersistence.fetchByG_C_L(
				campaign.getGroupId(), campaign.getCampaignId(),
				LocaleUtil.toLanguageId(locale));

		if (campaignLocalization == null) {
			return StringPool.BLANK;
		}

		return campaignLocalization.getDescription();
	}

	@Override
	public String getCampaignName(Campaign campaign, Locale locale) {
		CampaignLocalization campaignLocalization =
			campaignLocalizationPersistence.fetchByG_C_L(
				campaign.getGroupId(), campaign.getCampaignId(),
				LocaleUtil.toLanguageId(locale));

		if (campaignLocalization == null) {
			return StringPool.BLANK;
		}

		return campaignLocalization.getName();
	}

	@Override
	public List<Campaign> getCampaigns(long groupId, int start, int end) {
		return campaignPersistence.findByGroupId(groupId, start, end);
	}

	@Override
	public int getCampaignsCount(long groupId) {
		return campaignPersistence.countByGroupId(groupId);
	}

	@Override
	public Map<Locale, String> getDescriptionMap(Campaign campaign) {
		List<CampaignLocalization> campaignLocalizations =
			campaignLocalizationPersistence.findByG_C(
				campaign.getGroupId(), campaign.getCampaignId());

		Map<Locale, String> descriptionMap = new HashMap<>();

		for (CampaignLocalization campaignLocalization
			: campaignLocalizations) {

			descriptionMap.put(
				LocaleUtil.fromLanguageId(campaignLocalization.getLanguageId()),
				campaignLocalization.getDescription());
		}

		return descriptionMap;
	}

	@Override
	public Map<Locale, String> getNameMap(Campaign campaign) {
		List<CampaignLocalization> campaignLocalizations =
			campaignLocalizationPersistence.findByG_C(
				campaign.getGroupId(), campaign.getCampaignId());

		Map<Locale, String> nameMap = new HashMap<>();

		for (CampaignLocalization campaignLocalization
				: campaignLocalizations) {

			nameMap.put(
				LocaleUtil.fromLanguageId(campaignLocalization.getLanguageId()),
				campaignLocalization.getName());
		}

		return nameMap;
	}

	@Override
	public Campaign updateCampaign(
			long userId, long groupId, long campaignId,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap,
			Date startDate, Date endDate, CampaignStatus status,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		Campaign campaign = campaignPersistence.fetchByG_C(groupId, campaignId);

		if (campaign == null) {
			throw new NoSuchCampaignException();
		}

		campaign.setModifiedDate(serviceContext.getModifiedDate(now));

		updateCampaignLocalization(campaign, nameMap, descriptionMap);

		campaign.setStartDate(startDate);
		campaign.setEndDate(endDate);
		campaign.setStatus(status.ordinal());

		campaignPersistence.update(campaign);

		return campaign;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Campaign updateCampaignStatus(
			Campaign campaign, CampaignStatus newStatus)
		throws PortalException {

		Date now = new Date();

		campaign.setStatus(newStatus.ordinal());
		campaign.setModifiedDate(now);

		campaignPersistence.update(campaign);

		return campaign;
	}

	protected void updateCampaignLocalization(
		Campaign campaign, Map<Locale, String> nameMap,
		Map<Locale, String> descriptionMap) {

		Set<Locale> localeSet = new HashSet<>();

		localeSet.addAll(nameMap.keySet());

		if (descriptionMap != null) {
			localeSet.addAll(descriptionMap.keySet());
		}

		for (Locale locale : localeSet) {
			String name = nameMap.get(locale);
			String description = descriptionMap.get(locale);

			String languageId = LocaleUtil.toLanguageId(locale);

			CampaignLocalization campaignLocalization =
				campaignLocalizationPersistence.fetchByG_C_L(
					campaign.getGroupId(), campaign.getCampaignId(),
					languageId);

			if (campaignLocalization == null) {
				long campaignLocalizationId = counterLocalService.increment();

				campaignLocalization = campaignLocalizationPersistence.create(
					campaignLocalizationId);

				campaignLocalization.setCompanyId(campaign.getCompanyId());
				campaignLocalization.setGroupId(campaign.getGroupId());
				campaignLocalization.setCampaignId(campaign.getCampaignId());
				campaignLocalization.setLanguageId(languageId);
			}

			campaignLocalization.setName(name);
			campaignLocalization.setDescription(description);

			campaignLocalizationPersistence.update(campaignLocalization);
		}
	}

}