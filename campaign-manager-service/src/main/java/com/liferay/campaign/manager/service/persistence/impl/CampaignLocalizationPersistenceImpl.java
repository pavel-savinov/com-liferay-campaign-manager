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

package com.liferay.campaign.manager.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException;
import com.liferay.campaign.manager.model.CampaignLocalization;
import com.liferay.campaign.manager.model.impl.CampaignLocalizationImpl;
import com.liferay.campaign.manager.model.impl.CampaignLocalizationModelImpl;
import com.liferay.campaign.manager.service.persistence.CampaignLocalizationPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the campaign localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalizationPersistence
 * @see com.liferay.campaign.manager.service.persistence.CampaignLocalizationUtil
 * @generated
 */
@ProviderType
public class CampaignLocalizationPersistenceImpl extends BasePersistenceImpl<CampaignLocalization>
	implements CampaignLocalizationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignLocalizationUtil} to access the campaign localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignLocalizationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationModelImpl.FINDER_CACHE_ENABLED,
			CampaignLocalizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationModelImpl.FINDER_CACHE_ENABLED,
			CampaignLocalizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C = new FinderPath(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationModelImpl.FINDER_CACHE_ENABLED,
			CampaignLocalizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C = new FinderPath(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationModelImpl.FINDER_CACHE_ENABLED,
			CampaignLocalizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			CampaignLocalizationModelImpl.GROUPID_COLUMN_BITMASK |
			CampaignLocalizationModelImpl.CAMPAIGNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the campaign localizations where groupId = &#63; and campaignId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param campaignId the campaign ID
	 * @return the matching campaign localizations
	 */
	@Override
	public List<CampaignLocalization> findByG_C(long groupId, long campaignId) {
		return findByG_C(groupId, campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CampaignLocalization> findByG_C(long groupId, long campaignId,
		int start, int end) {
		return findByG_C(groupId, campaignId, start, end, null);
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
	@Override
	public List<CampaignLocalization> findByG_C(long groupId, long campaignId,
		int start, int end,
		OrderByComparator<CampaignLocalization> orderByComparator) {
		return findByG_C(groupId, campaignId, start, end, orderByComparator,
			true);
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
	@Override
	public List<CampaignLocalization> findByG_C(long groupId, long campaignId,
		int start, int end,
		OrderByComparator<CampaignLocalization> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C;
			finderArgs = new Object[] { groupId, campaignId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C;
			finderArgs = new Object[] {
					groupId, campaignId,
					
					start, end, orderByComparator
				};
		}

		List<CampaignLocalization> list = null;

		if (retrieveFromCache) {
			list = (List<CampaignLocalization>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CampaignLocalization campaignLocalization : list) {
					if ((groupId != campaignLocalization.getGroupId()) ||
							(campaignId != campaignLocalization.getCampaignId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CAMPAIGNLOCALIZATION_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignLocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<CampaignLocalization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CampaignLocalization>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CampaignLocalization findByG_C_First(long groupId, long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator)
		throws NoSuchCampaignLocalizationException {
		CampaignLocalization campaignLocalization = fetchByG_C_First(groupId,
				campaignId, orderByComparator);

		if (campaignLocalization != null) {
			return campaignLocalization;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignLocalizationException(msg.toString());
	}

	/**
	 * Returns the first campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	 */
	@Override
	public CampaignLocalization fetchByG_C_First(long groupId, long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator) {
		List<CampaignLocalization> list = findByG_C(groupId, campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CampaignLocalization findByG_C_Last(long groupId, long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator)
		throws NoSuchCampaignLocalizationException {
		CampaignLocalization campaignLocalization = fetchByG_C_Last(groupId,
				campaignId, orderByComparator);

		if (campaignLocalization != null) {
			return campaignLocalization;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignLocalizationException(msg.toString());
	}

	/**
	 * Returns the last campaign localization in the ordered set where groupId = &#63; and campaignId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	 */
	@Override
	public CampaignLocalization fetchByG_C_Last(long groupId, long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator) {
		int count = countByG_C(groupId, campaignId);

		if (count == 0) {
			return null;
		}

		List<CampaignLocalization> list = findByG_C(groupId, campaignId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CampaignLocalization[] findByG_C_PrevAndNext(
		long campaignLocalizationId, long groupId, long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator)
		throws NoSuchCampaignLocalizationException {
		CampaignLocalization campaignLocalization = findByPrimaryKey(campaignLocalizationId);

		Session session = null;

		try {
			session = openSession();

			CampaignLocalization[] array = new CampaignLocalizationImpl[3];

			array[0] = getByG_C_PrevAndNext(session, campaignLocalization,
					groupId, campaignId, orderByComparator, true);

			array[1] = campaignLocalization;

			array[2] = getByG_C_PrevAndNext(session, campaignLocalization,
					groupId, campaignId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignLocalization getByG_C_PrevAndNext(Session session,
		CampaignLocalization campaignLocalization, long groupId,
		long campaignId,
		OrderByComparator<CampaignLocalization> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CAMPAIGNLOCALIZATION_WHERE);

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CAMPAIGNID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CampaignLocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignLocalization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignLocalization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign localizations where groupId = &#63; and campaignId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param campaignId the campaign ID
	 */
	@Override
	public void removeByG_C(long groupId, long campaignId) {
		for (CampaignLocalization campaignLocalization : findByG_C(groupId,
				campaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(campaignLocalization);
		}
	}

	/**
	 * Returns the number of campaign localizations where groupId = &#63; and campaignId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param campaignId the campaign ID
	 * @return the number of matching campaign localizations
	 */
	@Override
	public int countByG_C(long groupId, long campaignId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C;

		Object[] finderArgs = new Object[] { groupId, campaignId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CAMPAIGNLOCALIZATION_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_CAMPAIGNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(campaignId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "campaignLocalization.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_CAMPAIGNID_2 = "campaignLocalization.campaignId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_C_L = new FinderPath(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationModelImpl.FINDER_CACHE_ENABLED,
			CampaignLocalizationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			CampaignLocalizationModelImpl.GROUPID_COLUMN_BITMASK |
			CampaignLocalizationModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignLocalizationModelImpl.LANGUAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_L = new FinderPath(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; or throws a {@link NoSuchCampaignLocalizationException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param campaignId the campaign ID
	 * @param languageId the language ID
	 * @return the matching campaign localization
	 * @throws NoSuchCampaignLocalizationException if a matching campaign localization could not be found
	 */
	@Override
	public CampaignLocalization findByG_C_L(long groupId, long campaignId,
		String languageId) throws NoSuchCampaignLocalizationException {
		CampaignLocalization campaignLocalization = fetchByG_C_L(groupId,
				campaignId, languageId);

		if (campaignLocalization == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", campaignId=");
			msg.append(campaignId);

			msg.append(", languageId=");
			msg.append(languageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCampaignLocalizationException(msg.toString());
		}

		return campaignLocalization;
	}

	/**
	 * Returns the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param campaignId the campaign ID
	 * @param languageId the language ID
	 * @return the matching campaign localization, or <code>null</code> if a matching campaign localization could not be found
	 */
	@Override
	public CampaignLocalization fetchByG_C_L(long groupId, long campaignId,
		String languageId) {
		return fetchByG_C_L(groupId, campaignId, languageId, true);
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
	@Override
	public CampaignLocalization fetchByG_C_L(long groupId, long campaignId,
		String languageId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { groupId, campaignId, languageId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_G_C_L,
					finderArgs, this);
		}

		if (result instanceof CampaignLocalization) {
			CampaignLocalization campaignLocalization = (CampaignLocalization)result;

			if ((groupId != campaignLocalization.getGroupId()) ||
					(campaignId != campaignLocalization.getCampaignId()) ||
					!Objects.equals(languageId,
						campaignLocalization.getLanguageId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CAMPAIGNLOCALIZATION_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_CAMPAIGNID_2);

			boolean bindLanguageId = false;

			if (languageId == null) {
				query.append(_FINDER_COLUMN_G_C_L_LANGUAGEID_1);
			}
			else if (languageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_C_L_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				query.append(_FINDER_COLUMN_G_C_L_LANGUAGEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(campaignId);

				if (bindLanguageId) {
					qPos.add(languageId);
				}

				List<CampaignLocalization> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_G_C_L,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CampaignLocalizationPersistenceImpl.fetchByG_C_L(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CampaignLocalization campaignLocalization = list.get(0);

					result = campaignLocalization;

					cacheResult(campaignLocalization);

					if ((campaignLocalization.getGroupId() != groupId) ||
							(campaignLocalization.getCampaignId() != campaignId) ||
							(campaignLocalization.getLanguageId() == null) ||
							!campaignLocalization.getLanguageId()
													 .equals(languageId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_G_C_L,
							finderArgs, campaignLocalization);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_G_C_L, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CampaignLocalization)result;
		}
	}

	/**
	 * Removes the campaign localization where groupId = &#63; and campaignId = &#63; and languageId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param campaignId the campaign ID
	 * @param languageId the language ID
	 * @return the campaign localization that was removed
	 */
	@Override
	public CampaignLocalization removeByG_C_L(long groupId, long campaignId,
		String languageId) throws NoSuchCampaignLocalizationException {
		CampaignLocalization campaignLocalization = findByG_C_L(groupId,
				campaignId, languageId);

		return remove(campaignLocalization);
	}

	/**
	 * Returns the number of campaign localizations where groupId = &#63; and campaignId = &#63; and languageId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param campaignId the campaign ID
	 * @param languageId the language ID
	 * @return the number of matching campaign localizations
	 */
	@Override
	public int countByG_C_L(long groupId, long campaignId, String languageId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C_L;

		Object[] finderArgs = new Object[] { groupId, campaignId, languageId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CAMPAIGNLOCALIZATION_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_CAMPAIGNID_2);

			boolean bindLanguageId = false;

			if (languageId == null) {
				query.append(_FINDER_COLUMN_G_C_L_LANGUAGEID_1);
			}
			else if (languageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_C_L_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				query.append(_FINDER_COLUMN_G_C_L_LANGUAGEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(campaignId);

				if (bindLanguageId) {
					qPos.add(languageId);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_C_L_GROUPID_2 = "campaignLocalization.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_L_CAMPAIGNID_2 = "campaignLocalization.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_L_LANGUAGEID_1 = "campaignLocalization.languageId IS NULL";
	private static final String _FINDER_COLUMN_G_C_L_LANGUAGEID_2 = "campaignLocalization.languageId = ?";
	private static final String _FINDER_COLUMN_G_C_L_LANGUAGEID_3 = "(campaignLocalization.languageId IS NULL OR campaignLocalization.languageId = '')";

	public CampaignLocalizationPersistenceImpl() {
		setModelClass(CampaignLocalization.class);
	}

	/**
	 * Caches the campaign localization in the entity cache if it is enabled.
	 *
	 * @param campaignLocalization the campaign localization
	 */
	@Override
	public void cacheResult(CampaignLocalization campaignLocalization) {
		entityCache.putResult(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationImpl.class,
			campaignLocalization.getPrimaryKey(), campaignLocalization);

		finderCache.putResult(FINDER_PATH_FETCH_BY_G_C_L,
			new Object[] {
				campaignLocalization.getGroupId(),
				campaignLocalization.getCampaignId(),
				campaignLocalization.getLanguageId()
			}, campaignLocalization);

		campaignLocalization.resetOriginalValues();
	}

	/**
	 * Caches the campaign localizations in the entity cache if it is enabled.
	 *
	 * @param campaignLocalizations the campaign localizations
	 */
	@Override
	public void cacheResult(List<CampaignLocalization> campaignLocalizations) {
		for (CampaignLocalization campaignLocalization : campaignLocalizations) {
			if (entityCache.getResult(
						CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
						CampaignLocalizationImpl.class,
						campaignLocalization.getPrimaryKey()) == null) {
				cacheResult(campaignLocalization);
			}
			else {
				campaignLocalization.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campaign localizations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CampaignLocalizationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campaign localization.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignLocalization campaignLocalization) {
		entityCache.removeResult(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationImpl.class, campaignLocalization.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CampaignLocalizationModelImpl)campaignLocalization);
	}

	@Override
	public void clearCache(List<CampaignLocalization> campaignLocalizations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CampaignLocalization campaignLocalization : campaignLocalizations) {
			entityCache.removeResult(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
				CampaignLocalizationImpl.class,
				campaignLocalization.getPrimaryKey());

			clearUniqueFindersCache((CampaignLocalizationModelImpl)campaignLocalization);
		}
	}

	protected void cacheUniqueFindersCache(
		CampaignLocalizationModelImpl campaignLocalizationModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					campaignLocalizationModelImpl.getGroupId(),
					campaignLocalizationModelImpl.getCampaignId(),
					campaignLocalizationModelImpl.getLanguageId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_G_C_L, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_G_C_L, args,
				campaignLocalizationModelImpl);
		}
		else {
			if ((campaignLocalizationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_C_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignLocalizationModelImpl.getGroupId(),
						campaignLocalizationModelImpl.getCampaignId(),
						campaignLocalizationModelImpl.getLanguageId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_G_C_L, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_G_C_L, args,
					campaignLocalizationModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CampaignLocalizationModelImpl campaignLocalizationModelImpl) {
		Object[] args = new Object[] {
				campaignLocalizationModelImpl.getGroupId(),
				campaignLocalizationModelImpl.getCampaignId(),
				campaignLocalizationModelImpl.getLanguageId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_G_C_L, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_G_C_L, args);

		if ((campaignLocalizationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_C_L.getColumnBitmask()) != 0) {
			args = new Object[] {
					campaignLocalizationModelImpl.getOriginalGroupId(),
					campaignLocalizationModelImpl.getOriginalCampaignId(),
					campaignLocalizationModelImpl.getOriginalLanguageId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_C_L, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_G_C_L, args);
		}
	}

	/**
	 * Creates a new campaign localization with the primary key. Does not add the campaign localization to the database.
	 *
	 * @param campaignLocalizationId the primary key for the new campaign localization
	 * @return the new campaign localization
	 */
	@Override
	public CampaignLocalization create(long campaignLocalizationId) {
		CampaignLocalization campaignLocalization = new CampaignLocalizationImpl();

		campaignLocalization.setNew(true);
		campaignLocalization.setPrimaryKey(campaignLocalizationId);

		campaignLocalization.setCompanyId(companyProvider.getCompanyId());

		return campaignLocalization;
	}

	/**
	 * Removes the campaign localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignLocalizationId the primary key of the campaign localization
	 * @return the campaign localization that was removed
	 * @throws NoSuchCampaignLocalizationException if a campaign localization with the primary key could not be found
	 */
	@Override
	public CampaignLocalization remove(long campaignLocalizationId)
		throws NoSuchCampaignLocalizationException {
		return remove((Serializable)campaignLocalizationId);
	}

	/**
	 * Removes the campaign localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign localization
	 * @return the campaign localization that was removed
	 * @throws NoSuchCampaignLocalizationException if a campaign localization with the primary key could not be found
	 */
	@Override
	public CampaignLocalization remove(Serializable primaryKey)
		throws NoSuchCampaignLocalizationException {
		Session session = null;

		try {
			session = openSession();

			CampaignLocalization campaignLocalization = (CampaignLocalization)session.get(CampaignLocalizationImpl.class,
					primaryKey);

			if (campaignLocalization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignLocalizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campaignLocalization);
		}
		catch (NoSuchCampaignLocalizationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CampaignLocalization removeImpl(
		CampaignLocalization campaignLocalization) {
		campaignLocalization = toUnwrappedModel(campaignLocalization);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campaignLocalization)) {
				campaignLocalization = (CampaignLocalization)session.get(CampaignLocalizationImpl.class,
						campaignLocalization.getPrimaryKeyObj());
			}

			if (campaignLocalization != null) {
				session.delete(campaignLocalization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (campaignLocalization != null) {
			clearCache(campaignLocalization);
		}

		return campaignLocalization;
	}

	@Override
	public CampaignLocalization updateImpl(
		CampaignLocalization campaignLocalization) {
		campaignLocalization = toUnwrappedModel(campaignLocalization);

		boolean isNew = campaignLocalization.isNew();

		CampaignLocalizationModelImpl campaignLocalizationModelImpl = (CampaignLocalizationModelImpl)campaignLocalization;

		Session session = null;

		try {
			session = openSession();

			if (campaignLocalization.isNew()) {
				session.save(campaignLocalization);

				campaignLocalization.setNew(false);
			}
			else {
				campaignLocalization = (CampaignLocalization)session.merge(campaignLocalization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CampaignLocalizationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((campaignLocalizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignLocalizationModelImpl.getOriginalGroupId(),
						campaignLocalizationModelImpl.getOriginalCampaignId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);

				args = new Object[] {
						campaignLocalizationModelImpl.getGroupId(),
						campaignLocalizationModelImpl.getCampaignId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);
			}
		}

		entityCache.putResult(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLocalizationImpl.class,
			campaignLocalization.getPrimaryKey(), campaignLocalization, false);

		clearUniqueFindersCache(campaignLocalizationModelImpl);
		cacheUniqueFindersCache(campaignLocalizationModelImpl, isNew);

		campaignLocalization.resetOriginalValues();

		return campaignLocalization;
	}

	protected CampaignLocalization toUnwrappedModel(
		CampaignLocalization campaignLocalization) {
		if (campaignLocalization instanceof CampaignLocalizationImpl) {
			return campaignLocalization;
		}

		CampaignLocalizationImpl campaignLocalizationImpl = new CampaignLocalizationImpl();

		campaignLocalizationImpl.setNew(campaignLocalization.isNew());
		campaignLocalizationImpl.setPrimaryKey(campaignLocalization.getPrimaryKey());

		campaignLocalizationImpl.setCampaignLocalizationId(campaignLocalization.getCampaignLocalizationId());
		campaignLocalizationImpl.setCompanyId(campaignLocalization.getCompanyId());
		campaignLocalizationImpl.setGroupId(campaignLocalization.getGroupId());
		campaignLocalizationImpl.setCampaignId(campaignLocalization.getCampaignId());
		campaignLocalizationImpl.setName(campaignLocalization.getName());
		campaignLocalizationImpl.setDescription(campaignLocalization.getDescription());
		campaignLocalizationImpl.setLanguageId(campaignLocalization.getLanguageId());

		return campaignLocalizationImpl;
	}

	/**
	 * Returns the campaign localization with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign localization
	 * @return the campaign localization
	 * @throws NoSuchCampaignLocalizationException if a campaign localization with the primary key could not be found
	 */
	@Override
	public CampaignLocalization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignLocalizationException {
		CampaignLocalization campaignLocalization = fetchByPrimaryKey(primaryKey);

		if (campaignLocalization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignLocalizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return campaignLocalization;
	}

	/**
	 * Returns the campaign localization with the primary key or throws a {@link NoSuchCampaignLocalizationException} if it could not be found.
	 *
	 * @param campaignLocalizationId the primary key of the campaign localization
	 * @return the campaign localization
	 * @throws NoSuchCampaignLocalizationException if a campaign localization with the primary key could not be found
	 */
	@Override
	public CampaignLocalization findByPrimaryKey(long campaignLocalizationId)
		throws NoSuchCampaignLocalizationException {
		return findByPrimaryKey((Serializable)campaignLocalizationId);
	}

	/**
	 * Returns the campaign localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign localization
	 * @return the campaign localization, or <code>null</code> if a campaign localization with the primary key could not be found
	 */
	@Override
	public CampaignLocalization fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
				CampaignLocalizationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CampaignLocalization campaignLocalization = (CampaignLocalization)serializable;

		if (campaignLocalization == null) {
			Session session = null;

			try {
				session = openSession();

				campaignLocalization = (CampaignLocalization)session.get(CampaignLocalizationImpl.class,
						primaryKey);

				if (campaignLocalization != null) {
					cacheResult(campaignLocalization);
				}
				else {
					entityCache.putResult(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
						CampaignLocalizationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
					CampaignLocalizationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return campaignLocalization;
	}

	/**
	 * Returns the campaign localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignLocalizationId the primary key of the campaign localization
	 * @return the campaign localization, or <code>null</code> if a campaign localization with the primary key could not be found
	 */
	@Override
	public CampaignLocalization fetchByPrimaryKey(long campaignLocalizationId) {
		return fetchByPrimaryKey((Serializable)campaignLocalizationId);
	}

	@Override
	public Map<Serializable, CampaignLocalization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CampaignLocalization> map = new HashMap<Serializable, CampaignLocalization>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CampaignLocalization campaignLocalization = fetchByPrimaryKey(primaryKey);

			if (campaignLocalization != null) {
				map.put(primaryKey, campaignLocalization);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
					CampaignLocalizationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CampaignLocalization)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CAMPAIGNLOCALIZATION_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (CampaignLocalization campaignLocalization : (List<CampaignLocalization>)q.list()) {
				map.put(campaignLocalization.getPrimaryKeyObj(),
					campaignLocalization);

				cacheResult(campaignLocalization);

				uncachedPrimaryKeys.remove(campaignLocalization.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CampaignLocalizationModelImpl.ENTITY_CACHE_ENABLED,
					CampaignLocalizationImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the campaign localizations.
	 *
	 * @return the campaign localizations
	 */
	@Override
	public List<CampaignLocalization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CampaignLocalization> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CampaignLocalization> findAll(int start, int end,
		OrderByComparator<CampaignLocalization> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CampaignLocalization> findAll(int start, int end,
		OrderByComparator<CampaignLocalization> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CampaignLocalization> list = null;

		if (retrieveFromCache) {
			list = (List<CampaignLocalization>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CAMPAIGNLOCALIZATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNLOCALIZATION;

				if (pagination) {
					sql = sql.concat(CampaignLocalizationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CampaignLocalization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CampaignLocalization>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the campaign localizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CampaignLocalization campaignLocalization : findAll()) {
			remove(campaignLocalization);
		}
	}

	/**
	 * Returns the number of campaign localizations.
	 *
	 * @return the number of campaign localizations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGNLOCALIZATION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CampaignLocalizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the campaign localization persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CampaignLocalizationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CAMPAIGNLOCALIZATION = "SELECT campaignLocalization FROM CampaignLocalization campaignLocalization";
	private static final String _SQL_SELECT_CAMPAIGNLOCALIZATION_WHERE_PKS_IN = "SELECT campaignLocalization FROM CampaignLocalization campaignLocalization WHERE campaignLocalizationId IN (";
	private static final String _SQL_SELECT_CAMPAIGNLOCALIZATION_WHERE = "SELECT campaignLocalization FROM CampaignLocalization campaignLocalization WHERE ";
	private static final String _SQL_COUNT_CAMPAIGNLOCALIZATION = "SELECT COUNT(campaignLocalization) FROM CampaignLocalization campaignLocalization";
	private static final String _SQL_COUNT_CAMPAIGNLOCALIZATION_WHERE = "SELECT COUNT(campaignLocalization) FROM CampaignLocalization campaignLocalization WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignLocalization.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CampaignLocalization exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CampaignLocalization exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CampaignLocalizationPersistenceImpl.class);
}