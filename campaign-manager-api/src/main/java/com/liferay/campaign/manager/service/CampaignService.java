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

import com.liferay.campaign.manager.model.Campaign;
import com.liferay.campaign.manager.util.CampaignStatus;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Provides the remote service interface for Campaign. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignServiceUtil
 * @see com.liferay.campaign.manager.service.base.CampaignServiceBaseImpl
 * @see com.liferay.campaign.manager.service.impl.CampaignServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=cm", "json.web.service.context.path=Campaign"}, service = CampaignService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CampaignService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignServiceUtil} to access the campaign remote service. Add custom service methods to {@link com.liferay.campaign.manager.service.impl.CampaignServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Campaign addCampaign(long userId, long groupId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, Date startDate,
		Date endDate, CampaignStatus status, ServiceContext serviceContext)
		throws PortalException;

	public Campaign deleteCampaign(long groupId, long campaignId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Campaign getCampaign(long groupId, long campaignId)
		throws PortalException;

	public Campaign updateCampaign(long userId, long groupId, long campaignId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, Date startDate,
		Date endDate, CampaignStatus status, ServiceContext serviceContext)
		throws PortalException;

	public Campaign updateCampaignStatus(Campaign campaign,
		CampaignStatus newStatus) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCampaignsCount(long groupId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getCampaigns(long groupId, int start, int end);
}