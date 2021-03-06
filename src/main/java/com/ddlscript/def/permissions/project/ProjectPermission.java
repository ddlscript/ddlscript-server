package com.ddlscript.def.permissions.project;

import com.ddlscript.sdk.Model;
import lombok.Getter;

/**
 * System based permissions.
 */
public enum ProjectPermission implements Model {

	/**
	 * Grants the user the ability to create and modify scripts within a project.
	 */
	MODIFY_SCRIPTS(1),

	/**
	 * Grants the user the ability to delete any unmerged scripts from the project.
	 */
	DELETE_ANY_UNMERGED_SCRIPTS(2),

	/**
	 * Grants the user the ability to approve merge requests.
	 */
	APPROVE_MERGE_REQUESTS(3),

	/**
	 * Grants the user the ability to merge approved requests into the mainline.
	 */
	MERGE_APPROVED_MERGE_REQUESTS(4),

	/**
	 * Grants the user the ability to manage the project's settings.
	 */
	MANAGE_PROJECT_SETTINGS(5),

	/**
	 * Grants the user the ability to manage webhooks.
	 */
	MANAGE_WEBHOOKS(6),

	/**
	 * Grants the user the ability to merge scripts into the mainline without needing a merge request.
	 */
	DIRECTLY_MERGE_SCRIPTS(7);

	public static ProjectPermission ofIdentifier(final int withValue) {
		for (ProjectPermission permission : ProjectPermission.values()) {
			if (permission.getDatabaseValue() == withValue) {
				return permission;
			}
		}

		throw new IllegalArgumentException("Value " + withValue + " is not valid.");
	}
	/**
	 * Database value that represents this setting.
	 */
	@Getter
	private final int databaseValue;

	/**
	 * Default constructor.
	 *
	 * @param withDatabaseValue
	 * 		database value.
	 */
	ProjectPermission(final int withDatabaseValue) {
		this.databaseValue = withDatabaseValue;
	}
}
