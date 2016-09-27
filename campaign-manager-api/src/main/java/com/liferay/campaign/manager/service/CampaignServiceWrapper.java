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

package com.liferay.campaign.manager.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CampaignService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignService
 * @generated
 */
@ProviderType
public class CampaignServiceWrapper implements CampaignService,
	ServiceWrapper<CampaignService> {
	public CampaignServiceWrapper(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	@Override
	public com.liferay.campaign.manager.model.Campaign addCampaign(
		long userId, long groupId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.campaign.manager.util.CampaignStatus status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.addCampaign(userId, groupId, nameMap,
			descriptionMap, startDate, endDate, status, serviceContext);
	}

	@Override
	public com.liferay.campaign.manager.model.Campaign deleteCampaign(
		long groupId, long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.deleteCampaign(groupId, campaignId);
	}

	@Override
	public com.liferay.campaign.manager.model.Campaign getCampaign(
		long groupId, long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.getCampaign(groupId, campaignId);
	}

	@Override
	public com.liferay.campaign.manager.model.Campaign updateCampaign(
		long userId, long groupId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.campaign.manager.util.CampaignStatus status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.updateCampaign(userId, groupId, campaignId,
			nameMap, descriptionMap, startDate, endDate, status, serviceContext);
	}

	@Override
	public com.liferay.campaign.manager.model.Campaign updateCampaignStatus(
		com.liferay.campaign.manager.model.Campaign campaign,
		com.liferay.campaign.manager.util.CampaignStatus newStatus)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignService.updateCampaignStatus(campaign, newStatus);
	}

	@Override
	public int getCampaignsCount(long groupId) {
		return _campaignService.getCampaignsCount(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _campaignService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.campaign.manager.model.Campaign> getCampaigns(
		long groupId, int start, int end) {
		return _campaignService.getCampaigns(groupId, start, end);
	}

	@Override
	public CampaignService getWrappedService() {
		return _campaignService;
	}

	@Override
	public void setWrappedService(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	private CampaignService _campaignService;
}