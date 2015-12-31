package com.github.notejam.ozark.user;

import com.google.common.base.Charsets;
import com.google.common.collect.Sets;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DB operations for user entities.
 * @author Florian Hirsch
 */
@Stateless
public class UserRepository {

	private static final Logger LOG = LoggerFactory.getLogger(UserRepository.class);

	@PersistenceContext(name = "notejam")
	private EntityManager em;

	public void saveUser(AccountSettingsForm account) {
		String password = Hashing.sha256().hashString(account.getPassword(), Charsets.UTF_8).toString();
		User user = new User(account.getEmail(), password, Sets.newHashSet(new UserGroup(Role.USER)));
		em.persist(user);
		LOG.info("Persisted user {}", user);
	}

}
