package com.ddlscript.repository.embedded.usergroups.members;

import com.ddlscript.repository.embedded.RowData;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class UserGroupMemberRowData implements RowData {
	@JsonSetter("TIMESTAMP_CREATED")
	private Timestamp timestampCreated;

	@JsonSetter("USERGROUP_ID")
	private int userGroupId;

	@JsonSetter("USER_ID")
	private int userId;

	@JsonSetter("USER_ID_CREATED")
	private int userIdCreated;

}
