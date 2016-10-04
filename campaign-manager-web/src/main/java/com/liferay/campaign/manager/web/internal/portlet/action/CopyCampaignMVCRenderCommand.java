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
import com.liferay.campaign.manager.service.CampaignLocalService;
import com.liferay.campaign.manager.web.internal.constants.CampaignManagerPortletKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CampaignManagerPortletKeys.CAMPAIGN_MANAGER,
		"mvc.command.name=/campaign_manager/copy_campaign"
	},
	service = MVCRenderCommand.class
)
public class CopyCampaignMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		long campaignId = ParamUtil.getLong(renderRequest, "campaignId");

		Campaign campaign = _campaignLocalService.fetchCampaign(campaignId);

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		Map<Locale, String> nameMap = campaign.getNameMap();

		for (Locale locale : nameMap.keySet()) {
			StringBundler name = new StringBundler();

			name.append(nameMap.get(locale));
			name.append(StringPool.SPACE);
			name.append(StringPool.OPEN_PARENTHESIS);
			name.append(LanguageUtil.get(request, "automatic-copy"));
			name.append(StringPool.CLOSE_PARENTHESIS);

			nameMap.put(locale, name.toString());
		}

		campaign.setCampaignId(0);

		renderRequest.setAttribute("campaign", campaign);

		return "/edit_campaign.jsp";
	}

	@Reference
	private CampaignLocalService _campaignLocalService;

}