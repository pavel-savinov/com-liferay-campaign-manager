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

package com.liferay.campaign.manager.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.campaign.manager.model.CampaignLocalization;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the campaign localization service. This utility wraps {@link com.liferay.campaign.manager.service.persistence.impl.CampaignLocalizationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalizationPersistence
 * @see com.liferay.campaign.manager.service.persistence.impl.CampaignLocalizationPersistenceImpl
 * @generated
 */
@ProviderType
public class CampaignLocalizationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CampaignLocalization campaignLocalization) {
		getPersistence().clearCache(campaignLocalization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CampaignLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CampaignLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CampaignLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CampaignLocalization> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CampaignLocalization update(
		CampaignLocalization campaignLocalization) {
		return getPersistence().update(campaignLocalization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CampaignLocalization update(
		CampaignLocalization campaignLocalization, ServiceContext serviceContext) {
		return getPersistence().update(campaignLocalization, serviceContext);
	}

	/**
	* Returns all the campaign localizations where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @return the matching campaign localizations
	*/
	public static List<CampaignLocalization> findByG_C(long groupId,
		long campaignId) {
		return getPersistence().findByG_C(groupId, campaignId);
	}

	/**
	* Returns a range of all the campaign localizations where groupId = &#63; and campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignLocalizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign localizations
	* @param end the upper bound of the range of campaign localizations (not inclusive)
	* @return the range of matching campaign localizations
	*/
	public static List<CampaignLocalization> findByG_C(long groupId,
		long campaignId, int start, int end) {
		return getPersistence().findByG_C(groupId, campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the campaign localizations where groupId = &#63; and campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignLocalizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign localizations
	* @param end the upper bound of the range of campaign localizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign localizations
	*/
	public static List<CampaignLocalization> findByG_C(long groupId,
		long campaignId, int start, int end,
		OrderByComparator<CampaignLocalization> orderByComparator) {
		return getPersistence()
				   .findByG_C(groupId, campaignId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaign localizations where groupId = &#63; and campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignLocalizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign localizations
	* @param end the upper bound of the range of campaign localizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching campaign localizations
	*/
	public static List<CampaignLocalization> findByG_C(long groupId,
		long campaignId, int start, int end,
		OrderByComparator<CampaignLocalization> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_C(groupId, campaignId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign localization
	* @throws NoSuchCampaignLocalizationException if a matching campaign localization could not be found
	*/
	public static CampaignLocalization findByG_C_First(long groupId,
		long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator)
		throws com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException {
		return getPersistence()
				   .findByG_C_First(groupId, campaignId, orderByComparator);
	}

	/**
	* Returns the first campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	*/
	public static CampaignLocalization fetchByG_C_First(long groupId,
		long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator) {
		return getPersistence()
				   .fetchByG_C_First(groupId, campaignId, orderByComparator);
	}

	/**
	* Returns the last campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign localization
	* @throws NoSuchCampaignLocalizationException if a matching campaign localization could not be found
	*/
	public static CampaignLocalization findByG_C_Last(long groupId,
		long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator)
		throws com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException {
		return getPersistence()
				   .findByG_C_Last(groupId, campaignId, orderByComparator);
	}

	/**
	* Returns the last campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	*/
	public static CampaignLocalization fetchByG_C_Last(long groupId,
		long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator) {
		return getPersistence()
				   .fetchByG_C_Last(groupId, campaignId, orderByComparator);
	}

	/**
	* Returns the campaign localizations before and after the current campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	*
	* @param campaignLocalizationId the primary key of the current campaign localization
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign localization
	* @throws NoSuchCampaignLocalizationException if a campaign localization with the primary key could not be found
	*/
	public static CampaignLocalization[] findByG_C_PrevAndNext(
		long campaignLocalizationId, long groupId, long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator)
		throws com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException {
		return getPersistence()
				   .findByG_C_PrevAndNext(campaignLocalizationId, groupId,
			campaignId, orderByComparator);
	}

	/**
	* Removes all the campaign localizations where groupId = &#63; and campaignId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	*/
	public static void removeByG_C(long groupId, long campaignId) {
		getPersistence().removeByG_C(groupId, campaignId);
	}

	/**
	* Returns the number of campaign localizations where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @return the number of matching campaign localizations
	*/
	public static int countByG_C(long groupId, long campaignId) {
		return getPersistence().countByG_C(groupId, campaignId);
	}

	/**
	* Returns the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; or throws a {@link NoSuchCampaignLocalizationException} if it could not be found.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @return the matching campaign localization
	* @throws NoSuchCampaignLocalizationException if a matching campaign localization could not be found
	*/
	public static CampaignLocalization findByG_C_L(long groupId,
		long campaignId, java.lang.String languageId)
		throws com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException {
		return getPersistence().findByG_C_L(groupId, campaignId, languageId);
	}

	/**
	* Returns the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @return the matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	*/
	public static CampaignLocalization fetchByG_C_L(long groupId,
		long campaignId, java.lang.String languageId) {
		return getPersistence().fetchByG_C_L(groupId, campaignId, languageId);
	}

	/**
	* Returns the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	*/
	public static CampaignLocalization fetchByG_C_L(long groupId,
		long campaignId, java.lang.String languageId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByG_C_L(groupId, campaignId, languageId,
			retrieveFromCache);
	}

	/**
	* Removes the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @return the campaign localization that was removed
	*/
	public static CampaignLocalization removeByG_C_L(long groupId,
		long campaignId, java.lang.String languageId)
		throws com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException {
		return getPersistence().removeByG_C_L(groupId, campaignId, languageId);
	}

	/**
	* Returns the number of campaign localizations where groupId = &#63; and campaignId = &#63; and languageId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @return the number of matching campaign localizations
	*/
	public static int countByG_C_L(long groupId, long campaignId,
		java.lang.String languageId) {
		return getPersistence().countByG_C_L(groupId, campaignId, languageId);
	}

	/**
	* Caches the campaign localization in the entity cache if it is enabled.
	*
	* @param campaignLocalization the campaign localization
	*/
	public static void cacheResult(CampaignLocalization campaignLocalization) {
		getPersistence().cacheResult(campaignLocalization);
	}

	/**
	* Caches the campaign localizations in the entity cache if it is enabled.
	*
	* @param campaignLocalizations the campaign localizations
	*/
	public static void cacheResult(
		List<CampaignLocalization> campaignLocalizations) {
		getPersistence().cacheResult(campaignLocalizations);
	}

	/**
	* Creates a new campaign localization with the primary key. Does not add the campaign localization to the database.
	*
	* @param campaignLocalizationId the primary key for the new campaign localization
	* @return the new campaign localization
	*/
	public static CampaignLocalization create(long campaignLocalizationId) {
		return getPersistence().create(campaignLocalizationId);
	}

	/**
	* Removes the campaign localization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignLocalizationId the primary key of the campaign localization
	* @return the campaign localization that was removed
	* @throws NoSuchCampaignLocalizationException if a campaign localization with the primary key could not be found
	*/
	public static CampaignLocalization remove(long campaignLocalizationId)
		throws com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException {
		return getPersistence().remove(campaignLocalizationId);
	}

	public static CampaignLocalization updateImpl(
		CampaignLocalization campaignLocalization) {
		return getPersistence().updateImpl(campaignLocalization);
	}

	/**
	* Returns the campaign localization with the primary key or throws a {@link NoSuchCampaignLocalizationException} if it could not be found.
	*
	* @param campaignLocalizationId the primary key of the campaign localization
	* @return the campaign localization
	* @throws NoSuchCampaignLocalizationException if a campaign localization with the primary key could not be found
	*/
	public static CampaignLocalization findByPrimaryKey(
		long campaignLocalizationId)
		throws com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException {
		return getPersistence().findByPrimaryKey(campaignLocalizationId);
	}

	/**
	* Returns the campaign localization with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignLocalizationId the primary key of the campaign localization
	* @return the campaign localization, or <code>null</code> if a campaign localization with the primary key could not be found
	*/
	public static CampaignLocalization fetchByPrimaryKey(
		long campaignLocalizationId) {
		return getPersistence().fetchByPrimaryKey(campaignLocalizationId);
	}

	public static java.util.Map<java.io.Serializable, CampaignLocalization> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the campaign localizations.
	*
	* @return the campaign localizations
	*/
	public static List<CampaignLocalization> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campaign localizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignLocalizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign localizations
	* @param end the upper bound of the range of campaign localizations (not inclusive)
	* @return the range of campaign localizations
	*/
	public static List<CampaignLocalization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campaign localizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignLocalizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign localizations
	* @param end the upper bound of the range of campaign localizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign localizations
	*/
	public static List<CampaignLocalization> findAll(int start, int end,
		OrderByComparator<CampaignLocalization> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaign localizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignLocalizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign localizations
	* @param end the upper bound of the range of campaign localizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of campaign localizations
	*/
	public static List<CampaignLocalization> findAll(int start, int end,
		OrderByComparator<CampaignLocalization> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the campaign localizations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of campaign localizations.
	*
	* @return the number of campaign localizations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CampaignLocalizationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CampaignLocalizationPersistence, CampaignLocalizationPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CampaignLocalizationPersistence.class);
}