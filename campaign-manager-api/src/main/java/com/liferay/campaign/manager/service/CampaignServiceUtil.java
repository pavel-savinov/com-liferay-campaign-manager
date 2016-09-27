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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Campaign. This utility wraps
 * {@link com.liferay.campaign.manager.service.impl.CampaignServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignService
 * @see com.liferay.campaign.manager.service.base.CampaignServiceBaseImpl
 * @see com.liferay.campaign.manager.service.impl.CampaignServiceImpl
 * @generated
 */
@ProviderType
public class CampaignServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.campaign.manager.service.impl.CampaignServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.campaign.manager.model.Campaign addCampaign(
		long userId, long groupId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.campaign.manager.util.CampaignStatus status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCampaign(userId, groupId, nameMap, descriptionMap,
			startDate, endDate, status, serviceContext);
	}

	public static com.liferay.campaign.manager.model.Campaign deleteCampaign(
		long groupId, long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCampaign(groupId, campaignId);
	}

	public static com.liferay.campaign.manager.model.Campaign getCampaign(
		long groupId, long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaign(groupId, campaignId);
	}

	public static com.liferay.campaign.manager.model.Campaign updateCampaign(
		long userId, long groupId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.campaign.manager.util.CampaignStatus status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateCampaign(userId, groupId, campaignId, nameMap,
			descriptionMap, startDate, endDate, status, serviceContext);
	}

	public static com.liferay.campaign.manager.model.Campaign updateCampaignStatus(
		com.liferay.campaign.manager.model.Campaign campaign,
		com.liferay.campaign.manager.util.CampaignStatus newStatus)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updateCampaignStatus(campaign, newStatus);
	}

	public static int getCampaignsCount(long groupId) {
		return getService().getCampaignsCount(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.campaign.manager.model.Campaign> getCampaigns(
		long groupId, int start, int end) {
		return getService().getCampaigns(groupId, start, end);
	}

	public static CampaignService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CampaignService, CampaignService> _serviceTracker =
		ServiceTrackerFactory.open(CampaignService.class);
}