package com.ddlscript.app.schema.projects.scripts;

import com.ddlscript.app.routes.AuthenticationContext;
import com.ddlscript.app.schema.common.AuditedSchema;
import com.ddlscript.def.projects.scripts.ScriptModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

import java.time.Instant;
import java.util.Optional;

/**
 * Summarized schema for scripts.
 */
public class ScriptSummarizedSchema implements AuditedSchema {

	@JsonIgnore
	@Getter
	private final ScriptModel model;

	@JsonIgnore
	@Getter(AccessLevel.PROTECTED)
	private final AuthenticationContext authenticationContext;


	public ScriptSummarizedSchema(
			@NonNull final AuthenticationContext withAuthenticationContext, @NonNull final ScriptModel withModel
	) {
		this.model = withModel;
		this.authenticationContext = withAuthenticationContext;
	}

	@JsonProperty("id")
	public int getId() {
		return this.model.getIdentifier()
				.getRawValue();
	}

	@JsonProperty("title")
	public String getTitle() {
		return this.model.getTitle();
	}

	@JsonProperty("timestamp_updated")
	public String getTimestampUpdated() {
		return Optional.of(this.model)
				.map(ScriptModel::getTimestampUpdated)
				.map(Instant::toString)
				.orElse(null);
	}
}
