create index IX_CDD6EBFE on Campaign (uuid_[$COLUMN_LENGTH:75$]);

create index IX_DE601435 on CampaignLocalization (campaignId, languageId[$COLUMN_LENGTH:75$]);
create index IX_C90FB736 on CampaignLocalization (languageId[$COLUMN_LENGTH:75$]);