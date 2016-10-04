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

package com.liferay.campaign.manager.web.internal.util.comparator;

import com.liferay.campaign.manager.model.Campaign;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Pavel Savinov
 */
public class CampaignStartDateComparator extends OrderByComparator<Campaign> {

	public static final String ORDER_BY_ASC = "Campaign.startDate ASC";

	public static final String ORDER_BY_DESC = "Campaign.startDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"startDate"};

	public CampaignStartDateComparator() {
		this(false);
	}

	public CampaignStartDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Campaign campaign1, Campaign campaign2) {
		int value = DateUtil.compareTo(
			campaign1.getStartDate(), campaign2.getStartDate());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}