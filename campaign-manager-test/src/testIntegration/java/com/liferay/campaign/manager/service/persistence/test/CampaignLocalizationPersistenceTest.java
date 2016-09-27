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

package com.liferay.campaign.manager.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.campaign.manager.exception.NoSuchCampaignLocalizationException;
import com.liferay.campaign.manager.model.CampaignLocalization;
import com.liferay.campaign.manager.service.persistence.CampaignLocalizationPersistence;
import com.liferay.campaign.manager.service.persistence.CampaignLocalizationUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CampaignLocalizationPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = CampaignLocalizationUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CampaignLocalization> iterator = _campaignLocalizations.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CampaignLocalization campaignLocalization = _persistence.create(pk);

		Assert.assertNotNull(campaignLocalization);

		Assert.assertEquals(campaignLocalization.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CampaignLocalization newCampaignLocalization = addCampaignLocalization();

		_persistence.remove(newCampaignLocalization);

		CampaignLocalization existingCampaignLocalization = _persistence.fetchByPrimaryKey(newCampaignLocalization.getPrimaryKey());

		Assert.assertNull(existingCampaignLocalization);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCampaignLocalization();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CampaignLocalization newCampaignLocalization = _persistence.create(pk);

		newCampaignLocalization.setCompanyId(RandomTestUtil.nextLong());

		newCampaignLocalization.setGroupId(RandomTestUtil.nextLong());

		newCampaignLocalization.setCampaignId(RandomTestUtil.nextLong());

		newCampaignLocalization.setName(RandomTestUtil.randomString());

		newCampaignLocalization.setDescription(RandomTestUtil.randomString());

		newCampaignLocalization.setLanguageId(RandomTestUtil.randomString());

		_campaignLocalizations.add(_persistence.update(newCampaignLocalization));

		CampaignLocalization existingCampaignLocalization = _persistence.findByPrimaryKey(newCampaignLocalization.getPrimaryKey());

		Assert.assertEquals(existingCampaignLocalization.getCampaignLocalizationId(),
			newCampaignLocalization.getCampaignLocalizationId());
		Assert.assertEquals(existingCampaignLocalization.getCompanyId(),
			newCampaignLocalization.getCompanyId());
		Assert.assertEquals(existingCampaignLocalization.getGroupId(),
			newCampaignLocalization.getGroupId());
		Assert.assertEquals(existingCampaignLocalization.getCampaignId(),
			newCampaignLocalization.getCampaignId());
		Assert.assertEquals(existingCampaignLocalization.getName(),
			newCampaignLocalization.getName());
		Assert.assertEquals(existingCampaignLocalization.getDescription(),
			newCampaignLocalization.getDescription());
		Assert.assertEquals(existingCampaignLocalization.getLanguageId(),
			newCampaignLocalization.getLanguageId());
	}

	@Test
	public void testCountByG_C() throws Exception {
		_persistence.countByG_C(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByG_C(0L, 0L);
	}

	@Test
	public void testCountByG_C_L() throws Exception {
		_persistence.countByG_C_L(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByG_C_L(0L, 0L, StringPool.NULL);

		_persistence.countByG_C_L(0L, 0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CampaignLocalization newCampaignLocalization = addCampaignLocalization();

		CampaignLocalization existingCampaignLocalization = _persistence.findByPrimaryKey(newCampaignLocalization.getPrimaryKey());

		Assert.assertEquals(existingCampaignLocalization,
			newCampaignLocalization);
	}

	@Test(expected = NoSuchCampaignLocalizationException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<CampaignLocalization> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CampaignLocalization",
			"campaignLocalizationId", true, "companyId", true, "groupId", true,
			"campaignId", true, "name", true, "description", true,
			"languageId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CampaignLocalization newCampaignLocalization = addCampaignLocalization();

		CampaignLocalization existingCampaignLocalization = _persistence.fetchByPrimaryKey(newCampaignLocalization.getPrimaryKey());

		Assert.assertEquals(existingCampaignLocalization,
			newCampaignLocalization);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CampaignLocalization missingCampaignLocalization = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCampaignLocalization);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		CampaignLocalization newCampaignLocalization1 = addCampaignLocalization();
		CampaignLocalization newCampaignLocalization2 = addCampaignLocalization();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCampaignLocalization1.getPrimaryKey());
		primaryKeys.add(newCampaignLocalization2.getPrimaryKey());

		Map<Serializable, CampaignLocalization> campaignLocalizations = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, campaignLocalizations.size());
		Assert.assertEquals(newCampaignLocalization1,
			campaignLocalizations.get(newCampaignLocalization1.getPrimaryKey()));
		Assert.assertEquals(newCampaignLocalization2,
			campaignLocalizations.get(newCampaignLocalization2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CampaignLocalization> campaignLocalizations = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(campaignLocalizations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		CampaignLocalization newCampaignLocalization = addCampaignLocalization();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCampaignLocalization.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CampaignLocalization> campaignLocalizations = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, campaignLocalizations.size());
		Assert.assertEquals(newCampaignLocalization,
			campaignLocalizations.get(newCampaignLocalization.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CampaignLocalization> campaignLocalizations = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(campaignLocalizations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		CampaignLocalization newCampaignLocalization = addCampaignLocalization();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCampaignLocalization.getPrimaryKey());

		Map<Serializable, CampaignLocalization> campaignLocalizations = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, campaignLocalizations.size());
		Assert.assertEquals(newCampaignLocalization,
			campaignLocalizations.get(newCampaignLocalization.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		CampaignLocalization newCampaignLocalization = addCampaignLocalization();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CampaignLocalization.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("campaignLocalizationId",
				newCampaignLocalization.getCampaignLocalizationId()));

		List<CampaignLocalization> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CampaignLocalization existingCampaignLocalization = result.get(0);

		Assert.assertEquals(existingCampaignLocalization,
			newCampaignLocalization);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CampaignLocalization.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("campaignLocalizationId",
				RandomTestUtil.nextLong()));

		List<CampaignLocalization> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		CampaignLocalization newCampaignLocalization = addCampaignLocalization();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CampaignLocalization.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"campaignLocalizationId"));

		Object newCampaignLocalizationId = newCampaignLocalization.getCampaignLocalizationId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("campaignLocalizationId",
				new Object[] { newCampaignLocalizationId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCampaignLocalizationId = result.get(0);

		Assert.assertEquals(existingCampaignLocalizationId,
			newCampaignLocalizationId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CampaignLocalization.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"campaignLocalizationId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("campaignLocalizationId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CampaignLocalization newCampaignLocalization = addCampaignLocalization();

		_persistence.clearCache();

		CampaignLocalization existingCampaignLocalization = _persistence.findByPrimaryKey(newCampaignLocalization.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(
				existingCampaignLocalization.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingCampaignLocalization,
				"getOriginalGroupId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(
				existingCampaignLocalization.getCampaignId()),
			ReflectionTestUtil.<Long>invoke(existingCampaignLocalization,
				"getOriginalCampaignId", new Class<?>[0]));
		Assert.assertTrue(Objects.equals(
				existingCampaignLocalization.getLanguageId(),
				ReflectionTestUtil.invoke(existingCampaignLocalization,
					"getOriginalLanguageId", new Class<?>[0])));
	}

	protected CampaignLocalization addCampaignLocalization()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		CampaignLocalization campaignLocalization = _persistence.create(pk);

		campaignLocalization.setCompanyId(RandomTestUtil.nextLong());

		campaignLocalization.setGroupId(RandomTestUtil.nextLong());

		campaignLocalization.setCampaignId(RandomTestUtil.nextLong());

		campaignLocalization.setName(RandomTestUtil.randomString());

		campaignLocalization.setDescription(RandomTestUtil.randomString());

		campaignLocalization.setLanguageId(RandomTestUtil.randomString());

		_campaignLocalizations.add(_persistence.update(campaignLocalization));

		return campaignLocalization;
	}

	private List<CampaignLocalization> _campaignLocalizations = new ArrayList<CampaignLocalization>();
	private CampaignLocalizationPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}