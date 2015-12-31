package com.github.notejam.ozark.user;

import com.github.notejam.ozark.BaseController;

import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Controller for the Signup Page.
 * @author Florian Hirsch
 */
@Path("signup")
@Controller
public class SignupController extends BaseController {

	@Inject
	private UserRepository userRepository;

	@GET
	public Response get() {
		return ok("signup");
	}

	@POST
	@ValidateOnExecution(type = ExecutableType.NONE)
	public Response post(@BeanParam @Valid AccountSettingsForm account) {
		if (validationFailed()) {
			models.put("account", account); // display the invalid the input data
			return badRequest("signup");
		}
		userRepository.saveUser(account);
		return redirect("notes");
	}

}
