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

import com.liferay.campaign.manager.service.CampaignLocalService;
import com.liferay.campaign.manager.util.CampaignStatus;
import com.liferay.campaign.manager.web.internal.constants.CampaignManagerPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
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
		"mvc.command.name=/campaign_manager/resume_campaign"
	},
	service = MVCActionCommand.class
)
public class ResumeCampaignMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long campaignId = ParamUtil.getLong(actionRequest, "campaignId");

		_campaignLocalService.updateCampaignStatus(
			campaignId, CampaignStatus.STARTED);

		sendRedirect(actionRequest, actionResponse);
	}

	@Reference
	private CampaignLocalService _campaignLocalService;

}