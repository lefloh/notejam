package com.github.notejam.ozark;

/**
 * @author Florian Hirsch
 */
public class Alert {

	public enum Type {
		SUCCESS, ERROR
	}

	private final Type type;

	private final String msg;

	public Alert(Type type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	public String getType() {
		return type.name().toLowerCase();
	}

	public String getMsg() {
		return msg;
	}
}
