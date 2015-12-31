package com.github.notejam.ozark.user;

import com.github.notejam.ozark.BaseController;

import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Controller for the forgot your password page.
 * @author Florian Hirsch
 */
@Path("forgot-password")
@Controller
public class ForgotPasswordController extends BaseController {

	@GET
	public Response get() {
		return ok("forgot-password");
	}

}
