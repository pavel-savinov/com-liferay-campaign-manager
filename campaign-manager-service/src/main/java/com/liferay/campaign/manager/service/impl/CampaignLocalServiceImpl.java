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

import com.liferay.campaign.manager.exception.InvalidDateRangeException;
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
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			CampaignStatus status, ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		long campaignId = counterLocalService.increment();

		Campaign campaign = campaignPersistence.create(campaignId);

		Date now = new Date();

		validateDates(startDate, endDate);

		campaign.setUuid(serviceContext.getUuid());
		campaign.setCreateDate(serviceContext.getCreateDate(now));
		campaign.setModifiedDate(serviceContext.getModifiedDate(now));
		campaign.setUserId(user.getUserId());
		campaign.setUserName(user.getFullName());
		campaign.setStartDate(startDate);
		campaign.setEndDate(endDate);
		campaign.setStatus(status.ordinal());

		// Campaign Localization

		updateCampaignLocalization(campaignId, nameMap, descriptionMap);

		campaignPersistence.update(campaign);

		return campaign;
	}

	@Override
	public String getCampaignDescription(long campaignId, Locale locale) {
		CampaignLocalization campaignLocalization =
			campaignLocalizationPersistence.fetchByC_L(
				campaignId, LocaleUtil.toLanguageId(locale));

		if (campaignLocalization == null) {
			return StringPool.BLANK;
		}

		return campaignLocalization.getDescription();
	}

	@Override
	public String getCampaignName(long campaignId, Locale locale) {
		CampaignLocalization campaignLocalization =
			campaignLocalizationPersistence.fetchByC_L(
				campaignId, LocaleUtil.toLanguageId(locale));

		if (campaignLocalization == null) {
			return StringPool.BLANK;
		}

		return campaignLocalization.getName();
	}

	@Override
	public Map<Locale, String> getDescriptionMap(long campaignId) {
		List<CampaignLocalization> campaignLocalizations =
			campaignLocalizationPersistence.findByCampaignId(campaignId);

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
	public Map<Locale, String> getNameMap(long campaignId) {
		List<CampaignLocalization> campaignLocalizations =
			campaignLocalizationPersistence.findByCampaignId(campaignId);

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
			long userId, long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			CampaignStatus status, ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validateDates(startDate, endDate);

		Campaign campaign = campaignPersistence.findByPrimaryKey(campaignId);

		campaign.setModifiedDate(serviceContext.getModifiedDate(now));
		campaign.setStartDate(startDate);
		campaign.setEndDate(endDate);
		campaign.setStatus(status.ordinal());

		updateCampaignLocalization(campaignId, nameMap, descriptionMap);

		campaignPersistence.update(campaign);

		return campaign;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Campaign updateCampaignStatus(
			long campaignId, CampaignStatus newStatus)
		throws PortalException {

		Campaign campaign = campaignPersistence.fetchByPrimaryKey(campaignId);

		Date now = new Date();

		campaign.setStatus(newStatus.ordinal());
		campaign.setModifiedDate(now);

		campaignPersistence.update(campaign);

		return campaign;
	}

	protected void updateCampaignLocalization(
		long campaignId, Map<Locale, String> nameMap,
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
				campaignLocalizationPersistence.fetchByC_L(
					campaignId, languageId);

			if (campaignLocalization == null) {
				long campaignLocalizationId = counterLocalService.increment();

				campaignLocalization = campaignLocalizationPersistence.create(
					campaignLocalizationId);

				campaignLocalization.setCampaignId(campaignId);
				campaignLocalization.setLanguageId(languageId);
			}

			campaignLocalization.setName(name);
			campaignLocalization.setDescription(description);

			campaignLocalizationPersistence.update(campaignLocalization);
		}
	}

	protected void validateDates(Date startDate, Date endDate)
		throws InvalidDateRangeException {

		if (startDate.after(endDate)) {
			throw new InvalidDateRangeException();
		}
	}

}