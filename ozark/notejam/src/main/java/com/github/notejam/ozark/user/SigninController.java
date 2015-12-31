package com.github.notejam.ozark.user;

import com.github.notejam.ozark.BaseController;

import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Controller for the Sigin Page. The login module ensures that this page
 * will be displayed for unauthenticated users. See also notejam/src/main/webapp/WEB-INF/web.xml.
 * @author Florian Hirsch
 */
@Path("/")
@Controller
public class SigninController extends BaseController {

	@GET
	@Path("signin")
	public Response get() {
		return ok("signin");
	}

	/**
	 * Will be called if the singin process failed and the user is not redirected to the notes page.
	 */
	@POST
	@Path("signin-failed")
	public Response signinFailed() {
		messages.alertError("Wrong password or email");
		return unauthorized("signin");
	}

}
