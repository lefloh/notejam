package com.github.notejam.ozark.user;

import com.google.common.base.MoreObjects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Florian Hirsch
 */
@Entity(name = "NOTEJAM_USER") // USER is a reserved word
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "EMAIL", unique = true)
	@NotNull
	@Pattern(regexp = "\\S+@\\S+\\.\\S+")
	private String email;

	@Column(name = "PASSWORD")
	@Size(min = 6)
	@NotNull
	private String password;


	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL")
	private Set<UserGroup> groups;

	public User() {
		// for JPA
	}

	public User(String email, String password, Set<UserGroup> groups) {
		this.email = email;
		this.password = password;
		this.groups = groups;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<UserGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<UserGroup> roles) {
		this.groups = roles;
	}

	public boolean isInRole(Role role) {
		if (groups == null || groups.isEmpty()) {
			return false;
		}
		return groups.stream().anyMatch(g -> g.getRole() == role);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		String formattedRoles = groups == null ? null : String.format("[%s]", groups.stream().map(r -> r.getRole().name()).collect(Collectors.joining(",")));
		return MoreObjects.toStringHelper(this).add("email", email).add("roles", formattedRoles).toString();
	}

}
