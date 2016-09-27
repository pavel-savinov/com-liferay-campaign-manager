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
 * Provides the local service utility for Campaign. This utility wraps
 * {@link com.liferay.campaign.manager.service.impl.CampaignLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalService
 * @see com.liferay.campaign.manager.service.base.CampaignLocalServiceBaseImpl
 * @see com.liferay.campaign.manager.service.impl.CampaignLocalServiceImpl
 * @generated
 */
@ProviderType
public class CampaignLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.campaign.manager.service.impl.CampaignLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was added
	*/
	public static com.liferay.campaign.manager.model.Campaign addCampaign(
		com.liferay.campaign.manager.model.Campaign campaign) {
		return getService().addCampaign(campaign);
	}

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

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	public static com.liferay.campaign.manager.model.Campaign createCampaign(
		long campaignId) {
		return getService().createCampaign(campaignId);
	}

	/**
	* Deletes the campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was removed
	*/
	public static com.liferay.campaign.manager.model.Campaign deleteCampaign(
		com.liferay.campaign.manager.model.Campaign campaign) {
		return getService().deleteCampaign(campaign);
	}

	/**
	* Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	public static com.liferay.campaign.manager.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCampaign(campaignId);
	}

	public static com.liferay.campaign.manager.model.Campaign deleteCampaign(
		long groupId, long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCampaign(groupId, campaignId);
	}

	public static com.liferay.campaign.manager.model.Campaign fetchCampaign(
		long campaignId) {
		return getService().fetchCampaign(campaignId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static com.liferay.campaign.manager.model.Campaign fetchCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchCampaignByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the campaign with the primary key.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	public static com.liferay.campaign.manager.model.Campaign getCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaign(campaignId);
	}

	public static com.liferay.campaign.manager.model.Campaign getCampaign(
		long groupId, long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaign(groupId, campaignId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign
	* @throws PortalException if a matching campaign could not be found
	*/
	public static com.liferay.campaign.manager.model.Campaign getCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaignByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was updated
	*/
	public static com.liferay.campaign.manager.model.Campaign updateCampaign(
		com.liferay.campaign.manager.model.Campaign campaign) {
		return getService().updateCampaign(campaign);
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

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	*/
	public static int getCampaignsCount() {
		return getService().getCampaignsCount();
	}

	public static int getCampaignsCount(long groupId) {
		return getService().getCampaignsCount(groupId);
	}

	public static java.lang.String getCampaignDescription(
		com.liferay.campaign.manager.model.Campaign campaign,
		java.util.Locale locale) {
		return getService().getCampaignDescription(campaign, locale);
	}

	public static java.lang.String getCampaignName(
		com.liferay.campaign.manager.model.Campaign campaign,
		java.util.Locale locale) {
		return getService().getCampaignName(campaign, locale);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.campaign.manager.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.campaign.manager.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.campaign.manager.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of campaigns
	*/
	public static java.util.List<com.liferay.campaign.manager.model.Campaign> getCampaigns(
		int start, int end) {
		return getService().getCampaigns(start, end);
	}

	public static java.util.List<com.liferay.campaign.manager.model.Campaign> getCampaigns(
		long groupId, int start, int end) {
		return getService().getCampaigns(groupId, start, end);
	}

	/**
	* Returns all the campaigns matching the UUID and company.
	*
	* @param uuid the UUID of the campaigns
	* @param companyId the primary key of the company
	* @return the matching campaigns, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.campaign.manager.model.Campaign> getCampaignsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getCampaignsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of campaigns matching the UUID and company.
	*
	* @param uuid the UUID of the campaigns
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching campaigns, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.campaign.manager.model.Campaign> getCampaignsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.campaign.manager.model.Campaign> orderByComparator) {
		return getService()
				   .getCampaignsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	public static java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap(
		com.liferay.campaign.manager.model.Campaign campaign) {
		return getService().getDescriptionMap(campaign);
	}

	public static java.util.Map<java.util.Locale, java.lang.String> getNameMap(
		com.liferay.campaign.manager.model.Campaign campaign) {
		return getService().getNameMap(campaign);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CampaignLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CampaignLocalService, CampaignLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CampaignLocalService.class);
}