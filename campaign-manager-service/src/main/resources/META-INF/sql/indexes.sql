create index IX_886A1073 on Campaign (groupId, campaignId);
create index IX_E2F44D6A on Campaign (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D125266C on Campaign (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_48E926E1 on CampaignLocalization (groupId, campaignId, languageId[$COLUMN_LENGTH:75$]);