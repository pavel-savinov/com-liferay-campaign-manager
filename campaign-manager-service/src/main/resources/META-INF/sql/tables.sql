create table Campaign (
	uuid_ VARCHAR(75) null,
	campaignId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	startDate DATE null,
	endDate DATE null,
	status INTEGER
);

create table CampaignLocalization (
	campaignLocalizationId LONG not null primary key,
	campaignId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	languageId VARCHAR(75) null
);