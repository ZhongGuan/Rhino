package authenticate.repository.domain;

import java.io.Serializable;

public interface User extends Serializable {
	
	public String getUserName();

	public void setUserName(String userName);

	public String getPassword();

	public void setPassword(String password);

}
