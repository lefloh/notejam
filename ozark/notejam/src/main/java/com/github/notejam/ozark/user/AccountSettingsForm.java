package com.github.notejam.ozark.user;

import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.util.Objects;

/**
 * @author Florian Hirsch
 * // TODO check password == confirm
 */
public class AccountSettingsForm {

	@NotNull(message = "Please enter your email.")
	@Pattern(regexp = "\\S+@\\S+\\.\\S+", message = "Please enter a valid email.")
	@FormParam("email")
	private String email;

	@NotNull(message = "Please enter your password")
	@Size(min = 6, message = "Please enter at least 6 Characters")
	@FormParam("password")
	private String password;

	@NotNull(message = "Please confirm your password")
	@Size(min = 6, message = "Please enter at least 6 Characters")
	@FormParam("confirmPassword")
	private String confirmPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AccountSettingsForm account = (AccountSettingsForm) o;
		return Objects.equals(email, account.email) &&
				Objects.equals(password, account.password) &&
				Objects.equals(confirmPassword, account.confirmPassword);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, confirmPassword);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("email", email).toString();
	}

}
