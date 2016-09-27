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

import com.liferay.campaign.manager.model.Campaign;
import com.liferay.campaign.manager.service.base.CampaignServiceBaseImpl;
import com.liferay.campaign.manager.util.CampaignStatus;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the campaign remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.campaign.manager.service.CampaignService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignServiceBaseImpl
 * @see com.liferay.campaign.manager.service.CampaignServiceUtil
 */
@ProviderType
public class CampaignServiceImpl extends CampaignServiceBaseImpl {

	@Override
	public Campaign addCampaign(
			long userId, long groupId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			CampaignStatus status, ServiceContext serviceContext)
		throws PortalException {

		return campaignLocalService.addCampaign(
			userId, groupId, nameMap, descriptionMap, startDate, endDate,
			status, serviceContext);
	}

	@Override
	public Campaign deleteCampaign(long groupId, long campaignId)
		throws PortalException {

		return campaignLocalService.deleteCampaign(groupId, campaignId);
	}

	@Override
	public Campaign getCampaign(long groupId, long campaignId)
		throws PortalException {

		return campaignLocalService.getCampaign(groupId, campaignId);
	}

	@Override
	public List<Campaign> getCampaigns(long groupId, int start, int end) {
		return campaignLocalService.getCampaigns(groupId, start, end);
	}

	@Override
	public int getCampaignsCount(long groupId) {
		return campaignLocalService.getCampaignsCount(groupId);
	}

	@Override
	public Campaign updateCampaign(
			long userId, long groupId, long campaignId,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap,
			Date startDate, Date endDate, CampaignStatus status,
			ServiceContext serviceContext)
		throws PortalException {

		return campaignLocalService.updateCampaign(
			userId, groupId, campaignId, nameMap, descriptionMap, startDate,
			endDate, status, serviceContext);
	}

	@Override
	public Campaign updateCampaignStatus(
			Campaign campaign, CampaignStatus newStatus)
		throws PortalException {

		return campaignLocalService.updateCampaignStatus(campaign, newStatus);
	}

}