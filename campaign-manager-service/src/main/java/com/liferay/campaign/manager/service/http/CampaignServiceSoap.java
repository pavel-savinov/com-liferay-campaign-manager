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

package com.liferay.campaign.manager.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.campaign.manager.service.CampaignServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

/**
 * Provides the SOAP utility for the
 * {@link CampaignServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.campaign.manager.model.CampaignSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.campaign.manager.model.Campaign}, that is translated to a
 * {@link com.liferay.campaign.manager.model.CampaignSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignServiceHttp
 * @see com.liferay.campaign.manager.model.CampaignSoap
 * @see CampaignServiceUtil
 * @generated
 */
@ProviderType
public class CampaignServiceSoap {
	public static com.liferay.campaign.manager.model.CampaignSoap addCampaign(
		long userId, long groupId, java.lang.String[] nameMapLanguageIds,
		java.lang.String[] nameMapValues,
		java.lang.String[] descriptionMapLanguageIds,
		java.lang.String[] descriptionMapValues, java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.campaign.manager.util.CampaignStatus status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(nameMapLanguageIds,
					nameMapValues);
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(descriptionMapLanguageIds,
					descriptionMapValues);

			com.liferay.campaign.manager.model.Campaign returnValue = CampaignServiceUtil.addCampaign(userId,
					groupId, nameMap, descriptionMap, startDate, endDate,
					status, serviceContext);

			return com.liferay.campaign.manager.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.campaign.manager.model.CampaignSoap deleteCampaign(
		long groupId, long campaignId) throws RemoteException {
		try {
			com.liferay.campaign.manager.model.Campaign returnValue = CampaignServiceUtil.deleteCampaign(groupId,
					campaignId);

			return com.liferay.campaign.manager.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.campaign.manager.model.CampaignSoap getCampaign(
		long groupId, long campaignId) throws RemoteException {
		try {
			com.liferay.campaign.manager.model.Campaign returnValue = CampaignServiceUtil.getCampaign(groupId,
					campaignId);

			return com.liferay.campaign.manager.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.campaign.manager.model.CampaignSoap[] getCampaigns(
		long groupId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.campaign.manager.model.Campaign> returnValue =
				CampaignServiceUtil.getCampaigns(groupId, start, end);

			return com.liferay.campaign.manager.model.CampaignSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getCampaignsCount(long groupId) throws RemoteException {
		try {
			int returnValue = CampaignServiceUtil.getCampaignsCount(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.campaign.manager.model.CampaignSoap updateCampaign(
		long userId, long groupId, long campaignId,
		java.lang.String[] nameMapLanguageIds,
		java.lang.String[] nameMapValues,
		java.lang.String[] descriptionMapLanguageIds,
		java.lang.String[] descriptionMapValues, java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.campaign.manager.util.CampaignStatus status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(nameMapLanguageIds,
					nameMapValues);
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(descriptionMapLanguageIds,
					descriptionMapValues);

			com.liferay.campaign.manager.model.Campaign returnValue = CampaignServiceUtil.updateCampaign(userId,
					groupId, campaignId, nameMap, descriptionMap, startDate,
					endDate, status, serviceContext);

			return com.liferay.campaign.manager.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.campaign.manager.model.CampaignSoap updateCampaignStatus(
		com.liferay.campaign.manager.model.CampaignSoap campaign,
		com.liferay.campaign.manager.util.CampaignStatus newStatus)
		throws RemoteException {
		try {
			com.liferay.campaign.manager.model.Campaign returnValue = CampaignServiceUtil.updateCampaignStatus(com.liferay.campaign.manager.model.impl.CampaignModelImpl.toModel(
						campaign), newStatus);

			return com.liferay.campaign.manager.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CampaignServiceSoap.class);
}