package com.github.notejam.ozark;

import javax.inject.Named;
import javax.mvc.annotation.RedirectScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A @RedirectScoped CDI bean holding messages like validation errors.
 * @author Florian Hirsch
 */
@Named("msg")
@RedirectScoped
public class Messages implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Alert> alerts;

	private Map<String, Set<String>> errors;

	/**
	 * Adds an error associated with a field.
	 */
	public void error(String key, String msg) {
		if (errors == null) {
			errors = new HashMap<>();
		}
		if (!errors.containsKey(key)) {
			errors.put(key, new HashSet<>());
		}
		errors.get(key).add(msg);
	}

	/**
	 * Adds an Alert (a global message for the user).
	 */
	public void alert(Alert alert) {
		if (alerts == null) {
			alerts = new ArrayList<>();
		}
		alerts.add(alert);
	}

	/**
	 * Adds a 'green' Alert.
	 */
	public void alertSuccess(String msg) {
		alert(new Alert(Alert.Type.SUCCESS, msg));
	}

	/**
	 * Adds a 'red' Alert.
	 */
	public void alertError(String msg) {
		alert(new Alert(Alert.Type.ERROR, msg));
	}

	public List<Alert> getAlerts() {
		return alerts;
	}

	public Map<String, Set<String>> getErrors() {
		return errors;
	}

}
