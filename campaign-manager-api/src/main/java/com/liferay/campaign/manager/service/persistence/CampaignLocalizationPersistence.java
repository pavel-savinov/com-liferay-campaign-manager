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

import com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException;
import com.liferay.campaign.manager.model.CampaignLocalization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the campaign localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.campaign.manager.service.persistence.impl.CampaignLocalizationPersistenceImpl
 * @see CampaignLocalizationUtil
 * @generated
 */
@ProviderType
public interface CampaignLocalizationPersistence extends BasePersistence<CampaignLocalization> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignLocalizationUtil} to access the campaign localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the campaign localizations where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @return the matching campaign localizations
	*/
	public java.util.List<CampaignLocalization> findByG_C(long groupId,
		long campaignId);

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
	public java.util.List<CampaignLocalization> findByG_C(long groupId,
		long campaignId, int start, int end);

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
	public java.util.List<CampaignLocalization> findByG_C(long groupId,
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignLocalization> orderByComparator);

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
	public java.util.List<CampaignLocalization> findByG_C(long groupId,
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignLocalization> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign localization
	* @throws NoSuchCampaignLocalizationException if a matching campaign localization could not be found
	*/
	public CampaignLocalization findByG_C_First(long groupId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignLocalization> orderByComparator)
		throws NoSuchCampaignLocalizationException;

	/**
	* Returns the first campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	*/
	public CampaignLocalization fetchByG_C_First(long groupId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignLocalization> orderByComparator);

	/**
	* Returns the last campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign localization
	* @throws NoSuchCampaignLocalizationException if a matching campaign localization could not be found
	*/
	public CampaignLocalization findByG_C_Last(long groupId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignLocalization> orderByComparator)
		throws NoSuchCampaignLocalizationException;

	/**
	* Returns the last campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	*/
	public CampaignLocalization fetchByG_C_Last(long groupId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignLocalization> orderByComparator);

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
	public CampaignLocalization[] findByG_C_PrevAndNext(
		long campaignLocalizationId, long groupId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignLocalization> orderByComparator)
		throws NoSuchCampaignLocalizationException;

	/**
	* Removes all the campaign localizations where groupId = &#63; and campaignId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	*/
	public void removeByG_C(long groupId, long campaignId);

	/**
	* Returns the number of campaign localizations where groupId = &#63; and campaignId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @return the number of matching campaign localizations
	*/
	public int countByG_C(long groupId, long campaignId);

	/**
	* Returns the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; or throws a {@link NoSuchCampaignLocalizationException} if it could not be found.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @return the matching campaign localization
	* @throws NoSuchCampaignLocalizationException if a matching campaign localization could not be found
	*/
	public CampaignLocalization findByG_C_L(long groupId, long campaignId,
		java.lang.String languageId) throws NoSuchCampaignLocalizationException;

	/**
	* Returns the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @return the matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	*/
	public CampaignLocalization fetchByG_C_L(long groupId, long campaignId,
		java.lang.String languageId);

	/**
	* Returns the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	*/
	public CampaignLocalization fetchByG_C_L(long groupId, long campaignId,
		java.lang.String languageId, boolean retrieveFromCache);

	/**
	* Removes the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @return the campaign localization that was removed
	*/
	public CampaignLocalization removeByG_C_L(long groupId, long campaignId,
		java.lang.String languageId) throws NoSuchCampaignLocalizationException;

	/**
	* Returns the number of campaign localizations where groupId = &#63; and campaignId = &#63; and languageId = &#63;.
	*
	* @param groupId the group ID
	* @param campaignId the campaign ID
	* @param languageId the language ID
	* @return the number of matching campaign localizations
	*/
	public int countByG_C_L(long groupId, long campaignId,
		java.lang.String languageId);

	/**
	* Caches the campaign localization in the entity cache if it is enabled.
	*
	* @param campaignLocalization the campaign localization
	*/
	public void cacheResult(CampaignLocalization campaignLocalization);

	/**
	* Caches the campaign localizations in the entity cache if it is enabled.
	*
	* @param campaignLocalizations the campaign localizations
	*/
	public void cacheResult(
		java.util.List<CampaignLocalization> campaignLocalizations);

	/**
	* Creates a new campaign localization with the primary key. Does not add the campaign localization to the database.
	*
	* @param campaignLocalizationId the primary key for the new campaign localization
	* @return the new campaign localization
	*/
	public CampaignLocalization create(long campaignLocalizationId);

	/**
	* Removes the campaign localization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignLocalizationId the primary key of the campaign localization
	* @return the campaign localization that was removed
	* @throws NoSuchCampaignLocalizationException if a campaign localization with the primary key could not be found
	*/
	public CampaignLocalization remove(long campaignLocalizationId)
		throws NoSuchCampaignLocalizationException;

	public CampaignLocalization updateImpl(
		CampaignLocalization campaignLocalization);

	/**
	* Returns the campaign localization with the primary key or throws a {@link NoSuchCampaignLocalizationException} if it could not be found.
	*
	* @param campaignLocalizationId the primary key of the campaign localization
	* @return the campaign localization
	* @throws NoSuchCampaignLocalizationException if a campaign localization with the primary key could not be found
	*/
	public CampaignLocalization findByPrimaryKey(long campaignLocalizationId)
		throws NoSuchCampaignLocalizationException;

	/**
	* Returns the campaign localization with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignLocalizationId the primary key of the campaign localization
	* @return the campaign localization, or <code>null</code> if a campaign localization with the primary key could not be found
	*/
	public CampaignLocalization fetchByPrimaryKey(long campaignLocalizationId);

	@Override
	public java.util.Map<java.io.Serializable, CampaignLocalization> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the campaign localizations.
	*
	* @return the campaign localizations
	*/
	public java.util.List<CampaignLocalization> findAll();

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
	public java.util.List<CampaignLocalization> findAll(int start, int end);

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
	public java.util.List<CampaignLocalization> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignLocalization> orderByComparator);

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
	public java.util.List<CampaignLocalization> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignLocalization> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the campaign localizations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of campaign localizations.
	*
	* @return the number of campaign localizations
	*/
	public int countAll();
}