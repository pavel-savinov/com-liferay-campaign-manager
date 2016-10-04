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

package com.liferay.campaign.manager.web.internal.display.context;

import com.liferay.campaign.manager.model.Campaign;
import com.liferay.campaign.manager.service.CampaignLocalServiceUtil;
import com.liferay.campaign.manager.util.CampaignStatus;
import com.liferay.campaign.manager.web.internal.constants.CampaignManagerPortletKeys;
import com.liferay.campaign.manager.web.internal.util.comparator.CampaignStartDateComparator;
import com.liferay.frontend.taglib.servlet.taglib.ManagementBarFilterItem;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public class CampaignManagerDisplayContext {

	public CampaignManagerDisplayContext(
		LiferayPortletRequest portletRequest,
		LiferayPortletResponse portletResponse) {

		_request = PortalUtil.getHttpServletRequest(portletRequest);

		_portletRequest = portletRequest;
		_portletResponse = portletResponse;
	}

	public long getCampaignId() {
		if (_campaignId != null) {
			return _campaignId;
		}

		_campaignId = ParamUtil.getLong(_request, "campaignId");

		return _campaignId;
	}

	public String getDisplayStyle() {
		if (_displayStyle != null) {
			return _displayStyle;
		}

		_displayStyle = getDisplayStyle(_request, getDisplayViews());

		return _displayStyle;
	}

	public String[] getDisplayViews() {
		if (_displayViews != null) {
			return _displayViews;
		}

		_displayViews = new String[] {"list"};

		return _displayViews;
	}

	public List<ManagementBarFilterItem> getManagementBarStatusFilterItems()
		throws PortalException, PortletException {

		List<ManagementBarFilterItem> managementBarFilterItems =
			new ArrayList<>();

		managementBarFilterItems.add(getManagementBarFilterItem(-1));

		for (CampaignStatus campaignStatus : CampaignStatus.values()) {
			managementBarFilterItems.add(
				getManagementBarFilterItem(campaignStatus.ordinal()));
		}

		return managementBarFilterItems;
	}

	public String getManagementBarStatusFilterValue() {
		if (getStatus() == -1) {
			return "any";
		}

		CampaignStatus campaignStatus = CampaignStatus.values()[getStatus()];

		return StringUtil.toLowerCase(campaignStatus.name());
	}

	public String getNavigation() {
		if (_navigation != null) {
			return _navigation;
		}

		_navigation = ParamUtil.getString(_request, "navigation", "all");

		return _navigation;
	}

	public String getOrderByCol() {
		if (Validator.isNotNull(_orderByCol)) {
			return _orderByCol;
		}

		_orderByCol = ParamUtil.getString(
			_request, "orderByCol", "modified-date");

		return _orderByCol;
	}

	public String getOrderByType() {
		if (Validator.isNotNull(_orderByType)) {
			return _orderByType;
		}

		_orderByType = ParamUtil.getString(_request, "orderByType", "asc");

		return _orderByType;
	}

	public PortletURL getPortletURL() throws PortalException {
		PortletURL portletURL = _portletResponse.createRenderURL();

		String navigation = ParamUtil.getString(_request, "navigation");

		if (Validator.isNotNull(navigation)) {
			portletURL.setParameter(
				"navigation", HtmlUtil.escapeJS(getNavigation()));
		}

		String status = ParamUtil.getString(_request, "status");

		if (Validator.isNotNull(status)) {
			portletURL.setParameter("status", String.valueOf(getStatus()));
		}

		String deltaEntry = ParamUtil.getString(_request, "deltaEntry");

		if (Validator.isNotNull(deltaEntry)) {
			portletURL.setParameter("deltaEntry", deltaEntry);
		}

		String displayStyle = ParamUtil.getString(_request, "displayStyle");

		if (Validator.isNotNull(displayStyle)) {
			portletURL.setParameter("displayStyle", getDisplayStyle());
		}

		String keywords = ParamUtil.getString(_request, "keywords");

		if (Validator.isNotNull(keywords)) {
			portletURL.setParameter("keywords", keywords);
		}

		return portletURL;
	}

	public String getRedirect() {
		if (_redirect == null) {
			_redirect = ParamUtil.getString(_request, "redirect");
		}

		return _redirect;
	}

	public SearchContainer getSearchContainer() throws Exception {
		if (_searchContainer != null) {
			return _searchContainer;
		}

		_searchContainer = new SearchContainer(
			_portletRequest, PortletURLUtil.clone(
				getPortletURL(), _portletResponse),
			null, LanguageUtil.get(_request, "no-campaigns-were-found"));

		_searchContainer.setId("campaigns");
		_searchContainer.setRowChecker(
			new EmptyOnClickRowChecker(_portletResponse));
		_searchContainer.setSearch(false);

		OrderByComparator<Campaign> orderByComparator =
			new CampaignStartDateComparator(isOrderByAsc());

		_searchContainer.setOrderByCol(getOrderByCol());
		_searchContainer.setOrderByComparator(orderByComparator);
		_searchContainer.setOrderByType(getOrderByType());

		_searchContainer.setTotal(CampaignLocalServiceUtil.getCampaignsCount());
		_searchContainer.setResults(
			CampaignLocalServiceUtil.getCampaigns(
				_searchContainer.getStart(), _searchContainer.getEnd()));

		_searchContainer.setEmptyResultsMessageCssClass(
			"taglib-empty-result-message-header-has-plus-btn");

		return _searchContainer;
	}

	public int getStatus() {
		if (_status != null) {
			return _status;
		}

		int defaultStatus = -1;

		_status = ParamUtil.getInteger(_request, "status", defaultStatus);

		return _status;
	}

	public int getTotal() throws Exception {
		SearchContainer searchContainer = getSearchContainer();

		return searchContainer.getTotal();
	}

	public boolean hasResults() throws Exception {
		if (getTotal() > 0) {
			return true;
		}

		return false;
	}

	public boolean isDisabledManagementBar() throws Exception {
		if (hasResults()) {
			return false;
		}

		if (!isNavigationHome() ||
			(getStatus() != WorkflowConstants.STATUS_ANY)) {

			return false;
		}

		return true;
	}

	public boolean isNavigationHome() {
		if (Objects.equals(getNavigation(), "all")) {
			return true;
		}

		return false;
	}

	public boolean isNavigationMine() {
		if (Objects.equals(getNavigation(), "mine")) {
			return true;
		}

		return false;
	}

	public boolean isNavigationRecent() {
		if (Objects.equals(getNavigation(), "recent")) {
			return true;
		}

		return false;
	}

	protected String getDisplayStyle(
		HttpServletRequest request, String[] displayViews) {

		PortalPreferences portalPreferences =
			PortletPreferencesFactoryUtil.getPortalPreferences(request);

		String displayStyle = ParamUtil.getString(request, "displayStyle");

		if (Validator.isNull(displayStyle)) {
			displayStyle = portalPreferences.getValue(
				CampaignManagerPortletKeys.CAMPAIGN_MANAGER, "display-style",
				"list");
		}
		else {
			if (ArrayUtil.contains(displayViews, displayStyle)) {
				portalPreferences.setValue(
					CampaignManagerPortletKeys.CAMPAIGN_MANAGER,
					"display-style", displayStyle);

				request.setAttribute(
					WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
			}
		}

		if (!ArrayUtil.contains(displayViews, displayStyle)) {
			displayStyle = displayViews[0];
		}

		return displayStyle;
	}

	protected ManagementBarFilterItem getManagementBarFilterItem(int status)
		throws PortalException, PortletException {

		boolean active = false;

		if (status == getStatus()) {
			active = true;
		}

		PortletURL portletURL = PortletURLUtil.clone(
			getPortletURL(), _portletResponse);

		portletURL.setParameter("status", String.valueOf(status));

		String label = "any";

		if (status != -1) {
			CampaignStatus campaignStatus = CampaignStatus.values()[status];

			label = StringUtil.toLowerCase(campaignStatus.name());
		}

		return new ManagementBarFilterItem(
			active, label, portletURL.toString());
	}

	protected boolean isOrderByAsc() {
		String orderByType = getOrderByType();

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		return orderByAsc;
	}

	private Long _campaignId;
	private String _displayStyle;
	private String[] _displayViews;
	private String _navigation;
	private String _orderByCol;
	private String _orderByType;
	private final LiferayPortletRequest _portletRequest;
	private final LiferayPortletResponse _portletResponse;
	private String _redirect;
	private final HttpServletRequest _request;
	private SearchContainer _searchContainer;
	private Integer _status;

}