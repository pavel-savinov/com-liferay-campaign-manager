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
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Campaign campaign = (Campaign)row.getObject();
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
	<portlet:renderURL var="editCampaignURL">
		<portlet:param name="mvcRenderCommandName" value="/campaign_manager/edit_campaign" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		message="edit"
		url="<%= editCampaignURL %>"
	/>

	<portlet:renderURL var="copyCampaignURL">
		<portlet:param name="mvcRenderCommandName" value="/campaign_manager/copy_campaign" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		message="copy"
		url="<%= copyCampaignURL %>"
	/>

	<c:choose>
		<c:when test="<%= campaign.getStatus() == CampaignStatus.STARTED.ordinal() %>">
			<portlet:actionURL name="/campaign_manager/pause_campaign" var="pauseCampaignURL">
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				message="pause"
				url="<%= pauseCampaignURL %>"
			/>
		</c:when>
		<c:when test="<%= campaign.getStatus() == CampaignStatus.PAUSED.ordinal() %>">
			<portlet:actionURL name="/campaign_manager/resume_campaign" var="resumeCampaignURL">
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				message="resume"
				url="<%= resumeCampaignURL %>"
			/>
		</c:when>
	</c:choose>

	<portlet:actionURL name="/campaign_manager/delete_campaign" var="deleteCampaignURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteCampaignURL %>"
	/>
</liferay-ui:icon-menu>