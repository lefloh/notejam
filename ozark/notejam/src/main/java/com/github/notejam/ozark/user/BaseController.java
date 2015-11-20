package com.github.notejam.ozark.user;

import com.github.notejam.ozark.Messages;
import com.google.common.collect.Iterables;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.binding.BindingResult;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.OK;

/**
 * @author Florian Hirsch
 */
public abstract class BaseController {

	@Inject
	protected Models models;

	@Inject
	protected Messages messages;

	@Inject
	protected BindingResult bindingResult;

	protected Response response(Response.Status status, String view) {
		return Response.status(status).entity(String.format("%s.jsp", view)).build();
	}

	protected  Response ok(String view) {
		return response(OK, view);
	}

	protected  Response badRequest(String view) {
		return response(BAD_REQUEST, view);
	}

	protected Response redirect(String view) {
		return Response.ok(String.format("redirect:/%s", view)).build();
	}

	protected boolean validationFailed() {
		if (bindingResult.isFailed()) {
			bindingResult.getAllViolations().forEach(v -> {
				String key = Iterables.getLast(v.getPropertyPath()).getName();
				messages.error(key, v.getMessage());
			});
		}
		return bindingResult.isFailed();
	}

}
