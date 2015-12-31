package com.github.notejam.ozark.user;

import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Objects;

/**
 * Glassfish ships with role based authentication out of the box.
 * Although notejam does not need different roles by now we are using
 * the JDBC Realm as you would typically not implement authentication on your own.
 * The configuration can be found in following files:
 * - docker/domain.xml
 * - notejam/src/main/webapp/WEB-INF/glassfhish-web.xml
 * - notejam/src/main/webapp/WEB-INF/web.xml
 * See also: http://blog.eisele.net/2013/01/jdbc-realm-glassfish312-primefaces342.html
 * @author Florian Hirsch
 */
@Entity(name = "NOTEJAM_GROUP")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"EMAIL", "ROLE"}))
public class UserGroup {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;

	public UserGroup() {
		// for JPA
	}

	public UserGroup(Role role) {
		// id and email will be added by JPA if a User with this kind of Role is persisted.
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserGroup userGroup = (UserGroup) o;
		return Objects.equals(id, userGroup.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("email", email).add("role", role).toString();
	}
}
