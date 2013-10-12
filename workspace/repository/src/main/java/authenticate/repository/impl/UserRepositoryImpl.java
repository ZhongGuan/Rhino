package authenticate.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import authenticate.entity.UserEntity;
import authenticate.repository.UserRepository;
import authenticate.repository.domain.User;

public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
    private EntityManager em;

	/**
	 * PK ¼ìË÷
	 */
	@Override
	public User find(String userName) {
		 UserEntity user = em.find(UserEntity.class, userName);
		 return user;
	}

	@Override
	public User createEmptyEntity() {
		return new UserEntity();
	}

}
