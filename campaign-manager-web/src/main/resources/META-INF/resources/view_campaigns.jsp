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

<portlet:actionURL name="/campaign_manager/delete_campaign" var="deleteCampaignsURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= deleteCampaignsURL %>" cssClass="container-fluid-1280" method="post" name="fmCampaigns">
	<aui:input name="groupId" type="hidden" value="<%= scopeGroupId %>" />

	<liferay-ui:search-container
		searchContainer="<%= campaignManagerDisplayContext.getSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.campaign.manager.model.Campaign"
			keyProperty="campaignId"
			modelVar="campaign"
		>
			<liferay-ui:search-container-column-text
				name="name" value="<%= campaign.getName() %>"
			/>

			<liferay-ui:search-container-column-text
				name="description" value="<%= campaign.getDescription() %>"
			/>

			<liferay-ui:search-container-column-text name="status">
				<liferay-ui:message key="<%= campaign.getStatusLabel() %>" />
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="created">

				<%
				Date createDate = campaign.getCreateDate();

				String createDateDescription = LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - createDate.getTime(), true);
				%>

				<h6 class="text-default">
					<liferay-ui:message arguments="<%= new String[] {createDateDescription} %>" key="x-ago" />
				</h6>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="modified">

				<%
				Date modifiedDate = campaign.getModifiedDate();

				String modifiedDateDescription = LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - modifiedDate.getTime(), true);
				%>

				<h6 class="text-default">
					<liferay-ui:message arguments="<%= new String[] {modifiedDateDescription} %>" key="x-ago" />
				</h6>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-jsp
				path="/campaign_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator displayStyle="<%= campaignManagerDisplayContext.getDisplayStyle() %>" markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	$('#<portlet:namespace />deleteCampaigns').on(
		'click',
		function(event) {
			if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
				submitForm(document.<portlet:namespace />fmCampaigns);
			}
		}
	);
</aui:script>