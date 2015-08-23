package com.github.notejam.ozark;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Florian Hirsch
 */
@RequestScoped
@Named("msg")
public class Messages {

	private List<Alert> alerts;

	private Map<String, Set<String>> errors;

	public void error(String key, String msg) {
		if (errors == null) {
			errors = new HashMap<>();
		}
		if (!errors.containsKey(key)) {
			errors.put(key, new HashSet<>());
		}
		errors.get(key).add(msg);
	}

	public void alert(Alert alert) {
		if (alerts == null) {
			alerts = new ArrayList<>();
		}
		alerts.add(alert);
	}

	public void alertSuccess(String msg) {
		alert(new Alert(Alert.Type.SUCCESS, msg));
	}

	public void allertError(String msg) {
		alert(new Alert(Alert.Type.ERROR, msg));
	}

	public List<Alert> getAlerts() {
		return alerts;
	}

	public Map<String, Set<String>> getErrors() {
		return errors;
	}
}
