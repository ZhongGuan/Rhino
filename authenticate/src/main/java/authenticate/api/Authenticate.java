package authenticate.api;

import javax.security.auth.Subject;

public interface Authenticate {
	
	Subject authenticate(String userName, String password);
	
}
