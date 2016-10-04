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

<portlet:actionURL name="/campaign_manager/edit_campaign" var="addCampaignURL" />

<aui:form action="<%= addCampaignURL %>" cssClass="container-fluid-1280">
	<aui:input name="redirect" type="hidden" value="<%= campaignManagerDisplayContext.getRedirect() %>" />
	<aui:input name="groupId" type="hidden" value="<%= scopeGroupId %>" />
	<aui:input name="campaignId" type="hidden" value="<%= campaignManagerDisplayContext.getCampaign() != null ? String.valueOf(campaignManagerDisplayContext.getCampaign().getCampaignId()) : String.valueOf(campaignManagerDisplayContext.getCampaignId()) %>" />

	<aui:model-context bean="<%= campaignManagerDisplayContext.getCampaign() %>" model="<%= Campaign.class %>" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input label="name" localized="<%= true %>" name="nameMapAsXML" type="text" />

			<aui:input label="description" localized="<%= true %>" name="descriptionMapAsXML" type="text" />
		</aui:fieldset>

		<aui:fieldset collapsed="<%= false %>" collapsible="<%= true %>" cssClass="dates-panel" label="dates">
			<liferay-ui:error exception="<%= InvalidDateRangeException.class %>" message="please-enter-valid-date-range" />

			<aui:input name="startDate" />

			<aui:input name="endDate" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />

		<aui:button cssClass="btn-lg" href="<%= campaignManagerDisplayContext.getRedirect() %>" type="cancel" />
	</aui:button-row>
</aui:form>