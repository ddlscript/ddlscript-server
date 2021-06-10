package com.ddlscript.routes;

import com.ddlscript.def.models.sessions.SessionModel;
import com.ddlscript.factories.ControllerFactory;
import com.ddlscript.sdk.AbstractRoute;
import spark.Request;
import spark.Response;

public abstract class AbstractAuthenticatedRoute<INPUT, OUTPUT> extends AbstractRoute<INPUT, OUTPUT> {

	public abstract OUTPUT handle(final SessionModel withSession, final INPUT withBody, final Request request, final Response response) throws Exception;

	@Override
	public OUTPUT handle(final INPUT withBody, final Request request, final Response response) throws Exception {
		final var sessionId = request.cookie("sesid");
		if (sessionId == null || sessionId.isBlank()) {
			return null;
		}

		var sessionModel = ControllerFactory.INSTANCE.getSessionController()
				.describe(builder -> builder.setToken(sessionId))
				.orElseThrow();

		return this.handle(sessionModel, withBody, request, response);
	}
}