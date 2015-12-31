package com.github.notejam.ozark;

import com.google.common.collect.Iterables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.binding.BindingResult;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.OK;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

/**
 * A base controller with some helper methods and commonly used beans injected.
 * @author Florian Hirsch
 */
public abstract class BaseController {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	protected Models models;

	@Inject
	protected Messages messages;

	@Inject
	protected BindingResult bindingResult;

	protected Response response(Response.Status status, String view) {
		return Response.status(status).entity(String.format("%s.jsp", view)).build();
	}

	/**
	 * @return 200 OK
	 */
	protected  Response ok(String view) {
		return response(OK, view);
	}

	/**
	 * @return 400 Bad Request
	 */
	protected  Response badRequest(String view) {
		return response(BAD_REQUEST, view);
	}

	/**
	 * @return 401 Unauthorized
	 */
	protected  Response unauthorized(String view) {
		return response(UNAUTHORIZED, view);
	}

	/**
	 * Redirect to given view.
	 */
	protected Response redirect(String view) {
		return Response.ok(String.format("redirect:/%s", view)).build();
	}

	/**
	 * Checks if validation failed and mapps the validation errors to the messages bean.
	 * @return true if validation failed
	 */
	protected boolean validationFailed() {
		if (bindingResult.isFailed()) {
			bindingResult.getAllViolations().forEach(v -> {
				String key = Iterables.getLast(v.getPropertyPath()).getName();
				if (key == null) {
					messages.alertError(v.getMessage());
				} else {
					messages.error(key, v.getMessage());
				}
			});
		}
		return bindingResult.isFailed();
	}

}
