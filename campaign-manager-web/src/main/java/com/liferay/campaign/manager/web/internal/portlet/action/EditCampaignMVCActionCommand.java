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
import com.liferay.campaign.manager.util.CampaignStatus;
import com.liferay.campaign.manager.web.internal.constants.CampaignManagerPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CampaignManagerPortletKeys.CAMPAIGN_MANAGER,
		"mvc.command.name=/campaign_manager/edit_campaign"
	},
	service = MVCActionCommand.class
)
public class EditCampaignMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long campaignId = ParamUtil.getLong(actionRequest, "campaignId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "nameMapAsXML");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(
				actionRequest, "descriptionMapAsXML");

		String timeZoneId = TimeZoneUtil.getDefault().getID();

		Date startDate = getDate(actionRequest, "startDate", timeZoneId);
		Date endDate = getDate(actionRequest, "endDate", timeZoneId);

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		CampaignStatus campaignStatus = CampaignStatus.DRAFT;

		Date now = new Date();

		if (now.before(startDate)) {
			campaignStatus = CampaignStatus.SCHEDULED;
		}
		else if (now.after(startDate) && now.before(endDate)) {
			campaignStatus = CampaignStatus.STARTED;
		}
		else if (now.after(endDate)) {
			campaignStatus = CampaignStatus.FINISHED;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Campaign.class.getName(), actionRequest);

			if (campaignId > 0) {
				_campaignLocalService.updateCampaign(
					themeDisplay.getUserId(), campaignId, nameMap,
					descriptionMap, startDate, endDate, campaignStatus,
					serviceContext);
			}
			else {
				_campaignLocalService.addCampaign(
					themeDisplay.getUserId(), nameMap, descriptionMap,
					startDate, endDate, campaignStatus, serviceContext);
			}

			sendRedirect(actionRequest, actionResponse, redirect);
		}
		catch (PortalException pe) {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			SessionErrors.add(actionRequest, pe.getClass(), pe);

			actionResponse.setRenderParameter(
				"mvcRenderCommandName", "/campaign_manager/edit_campaign");
		}
	}

	protected Date getDate(
		PortletRequest portletRequest, String paramPrefix, String timeZoneId) {

		int dateMonth = ParamUtil.getInteger(
			portletRequest, paramPrefix + "Month");
		int dateDay = ParamUtil.getInteger(portletRequest, paramPrefix + "Day");
		int dateYear = ParamUtil.getInteger(
			portletRequest, paramPrefix + "Year");
		int dateHour = ParamUtil.getInteger(
			portletRequest, paramPrefix + "Hour");
		int dateMinute = ParamUtil.getInteger(
			portletRequest, paramPrefix + "Minute");
		int dateAmPm = ParamUtil.getInteger(
			portletRequest, paramPrefix + "AmPm");

		if (dateAmPm == Calendar.PM) {
			dateHour += 12;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Calendar calendar = CalendarFactoryUtil.getCalendar(
			TimeZone.getTimeZone(timeZoneId), themeDisplay.getLocale());

		calendar.set(Calendar.MONTH, dateMonth);
		calendar.set(Calendar.DATE, dateDay);
		calendar.set(Calendar.YEAR, dateYear);
		calendar.set(Calendar.HOUR_OF_DAY, dateHour);
		calendar.set(Calendar.MINUTE, dateMinute);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	@Reference
	private CampaignLocalService _campaignLocalService;

}