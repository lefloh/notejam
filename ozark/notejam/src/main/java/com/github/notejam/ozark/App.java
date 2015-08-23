package com.github.notejam.ozark;

import com.google.common.collect.ImmutableMap;

import javax.mvc.security.Csrf;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Map;

/**
 * @author Florian Hirsch
 */
@ApplicationPath("/r")
public class App extends Application {

	@Override
	public Map<String, Object> getProperties() {
		return ImmutableMap.<String, Object>builder()
				.put("jersey.config.server.provider.packages", App.class.getPackage().getName())
				// TODO CSRF checks
				.put(Csrf.CSRF_PROTECTION, Csrf.CsrfOptions.EXPLICIT)
				.build();
	}

}
