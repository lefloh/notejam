package com.github.notejam.ozark.user;

import javax.mvc.annotation.Controller;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Florian Hirsch
 */
@Path("signin")
@Controller
public class SigninController {

	@PersistenceContext(name = "notejam")
	private EntityManager em;

	@GET
	public String get() {
		return "signin.jsp";
	}

}
