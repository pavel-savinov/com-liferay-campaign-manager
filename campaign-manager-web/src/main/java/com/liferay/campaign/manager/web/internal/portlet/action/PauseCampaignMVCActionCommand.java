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

package com.liferay.campaign.manager.web.internal.portlet.action;

import com.liferay.campaign.manager.model.Campaign;
import com.liferay.campaign.manager.service.CampaignService;
import com.liferay.campaign.manager.util.CampaignStatus;
import com.liferay.campaign.manager.web.internal.constants.CampaignManagerPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CampaignManagerPortletKeys.CAMPAIGN_MANAGER,
		"mvc.command.name=/campaign_manager/pause_campaign"
	},
	service = MVCActionCommand.class
)
public class PauseCampaignMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long groupId = ParamUtil.getLong(actionRequest, "groupId");
			long campaignId = ParamUtil.getLong(actionRequest, "campaignId");

			Campaign campaign = _campaignService.getCampaign(
				groupId, campaignId);

			_campaignService.updateCampaignStatus(
				campaign, CampaignStatus.PAUSED);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			_log.error("Unable to delete campaign", e);

			SessionErrors.add(actionRequest, e.getClass(), e);

			actionResponse.setRenderParameter("mvcPath", "/error.jsp");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PauseCampaignMVCActionCommand.class);

	@Reference
	private CampaignService _campaignService;

}