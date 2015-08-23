package com.github.notejam.ozark.user;

import javax.mvc.annotation.Controller;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Florian Hirsch
 */
@Path("signup")
@Controller
public class SignupController extends BaseController {

	@PersistenceContext(name = "notejam")
	private EntityManager em;

	@GET
	public Response get() {
		return ok("signup");
	}

	@POST
	@ValidateOnExecution(type = ExecutableType.NONE)
	public Response post(@BeanParam @Valid AccountSettingsForm account) {
		if (validationFailed()) {
			return badRequest("signup");
		}
		return ok("notes");
	}

}
