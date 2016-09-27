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
 * Provides a wrapper for {@link CampaignLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalService
 * @generated
 */
@ProviderType
public class CampaignLocalServiceWrapper implements CampaignLocalService,
	ServiceWrapper<CampaignLocalService> {
	public CampaignLocalServiceWrapper(
		CampaignLocalService campaignLocalService) {
		_campaignLocalService = campaignLocalService;
	}

	/**
	* Adds the campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was added
	*/
	@Override
	public com.liferay.campaign.manager.model.Campaign addCampaign(
		com.liferay.campaign.manager.model.Campaign campaign) {
		return _campaignLocalService.addCampaign(campaign);
	}

	@Override
	public com.liferay.campaign.manager.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.campaign.manager.util.CampaignStatus status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.addCampaign(userId, nameMap,
			descriptionMap, startDate, endDate, status, serviceContext);
	}

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	@Override
	public com.liferay.campaign.manager.model.Campaign createCampaign(
		long campaignId) {
		return _campaignLocalService.createCampaign(campaignId);
	}

	/**
	* Deletes the campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was removed
	*/
	@Override
	public com.liferay.campaign.manager.model.Campaign deleteCampaign(
		com.liferay.campaign.manager.model.Campaign campaign) {
		return _campaignLocalService.deleteCampaign(campaign);
	}

	/**
	* Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	@Override
	public com.liferay.campaign.manager.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.deleteCampaign(campaignId);
	}

	@Override
	public com.liferay.campaign.manager.model.Campaign fetchCampaign(
		long campaignId) {
		return _campaignLocalService.fetchCampaign(campaignId);
	}

	/**
	* Returns the campaign with the primary key.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	@Override
	public com.liferay.campaign.manager.model.Campaign getCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaign(campaignId);
	}

	/**
	* Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was updated
	*/
	@Override
	public com.liferay.campaign.manager.model.Campaign updateCampaign(
		com.liferay.campaign.manager.model.Campaign campaign) {
		return _campaignLocalService.updateCampaign(campaign);
	}

	@Override
	public com.liferay.campaign.manager.model.Campaign updateCampaign(
		long userId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.campaign.manager.util.CampaignStatus status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.updateCampaign(userId, campaignId,
			nameMap, descriptionMap, startDate, endDate, status, serviceContext);
	}

	@Override
	public com.liferay.campaign.manager.model.Campaign updateCampaignStatus(
		long campaignId,
		com.liferay.campaign.manager.util.CampaignStatus newStatus)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.updateCampaignStatus(campaignId, newStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _campaignLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _campaignLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _campaignLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	*/
	@Override
	public int getCampaignsCount() {
		return _campaignLocalService.getCampaignsCount();
	}

	@Override
	public java.lang.String getCampaignDescription(long campaignId,
		java.util.Locale locale) {
		return _campaignLocalService.getCampaignDescription(campaignId, locale);
	}

	@Override
	public java.lang.String getCampaignName(long campaignId,
		java.util.Locale locale) {
		return _campaignLocalService.getCampaignName(campaignId, locale);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _campaignLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _campaignLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _campaignLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _campaignLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<com.liferay.campaign.manager.model.Campaign> getCampaigns(
		int start, int end) {
		return _campaignLocalService.getCampaigns(start, end);
	}

	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap(
		long campaignId) {
		return _campaignLocalService.getDescriptionMap(campaignId);
	}

	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap(
		long campaignId) {
		return _campaignLocalService.getNameMap(campaignId);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _campaignLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _campaignLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public CampaignLocalService getWrappedService() {
		return _campaignLocalService;
	}

	@Override
	public void setWrappedService(CampaignLocalService campaignLocalService) {
		_campaignLocalService = campaignLocalService;
	}

	private CampaignLocalService _campaignLocalService;
}