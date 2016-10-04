<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String searchContainerId = ParamUtil.getString(request, "searchContainerId");
%>

<liferay-frontend:management-bar
	disabled="<%= campaignManagerDisplayContext.isDisabledManagementBar() %>"
	includeCheckBox="<%= true %>"
	searchContainerId="<%= searchContainerId %>"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews="<%= campaignManagerDisplayContext.getDisplayViews() %>"
			portletURL="<%= campaignManagerDisplayContext.getPortletURL() %>"
			selectedDisplayStyle="<%= campaignManagerDisplayContext.getDisplayStyle() %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation>
			<portlet:renderURL var="viewArticlesHomeURL" />

			<liferay-frontend:management-bar-filter-item active="<%= campaignManagerDisplayContext.isNavigationHome() %>" label="all" url="<%= viewArticlesHomeURL.toString() %>" />

			<portlet:renderURL var="viewRecentArticlesURL">
				<portlet:param name="navigation" value="recent" />
			</portlet:renderURL>

			<liferay-frontend:management-bar-filter-item active="<%= campaignManagerDisplayContext.isNavigationRecent() %>" label="recent" url="<%= viewRecentArticlesURL.toString() %>" />

			<portlet:renderURL var="viewMyArticlesURL">
				<portlet:param name="navigation" value="mine" />
			</portlet:renderURL>

			<liferay-frontend:management-bar-filter-item active="<%= campaignManagerDisplayContext.isNavigationMine() %>" label="mine" url="<%= viewMyArticlesURL.toString() %>" />
		</liferay-frontend:management-bar-navigation>

		<liferay-frontend:management-bar-filter
			label="status"
			managementBarFilterItems="<%= campaignManagerDisplayContext.getManagementBarStatusFilterItems() %>"
			value="<%= campaignManagerDisplayContext.getManagementBarStatusFilterValue() %>"
		/>
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteCampaigns" label="delete" />
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>