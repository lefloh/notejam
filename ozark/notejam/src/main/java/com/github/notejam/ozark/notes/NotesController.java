package com.github.notejam.ozark.notes;

import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Florian Hirsch
 */
@Path("notes")
@Controller
public class NotesController {

	@GET
	public String get() {
		return "notes.jsp";
	}

}
