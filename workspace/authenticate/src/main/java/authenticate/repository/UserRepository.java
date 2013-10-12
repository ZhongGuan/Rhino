package authenticate.repository;

import authenticate.repository.domain.User;

public interface UserRepository {
	
	User createEmptyEntity();
	
	User find(String userName);

}
