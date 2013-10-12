package authenticate.api.impl;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import authenticate.api.Authenticate;
import authenticate.api.SimpleCallbackHandler;

public class AuthenticateImpl implements Authenticate {
	
	@Override
	public Subject authenticate(String userName, String password) {
		
		SimpleCallbackHandler callbackHandler = new SimpleCallbackHandler(userName, password);
		LoginContext ctx = null;
		try {
			ctx = new LoginContext("Simple", callbackHandler);
			ctx.login();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Subject subject = ctx.getSubject();
		
		return subject;
	}

}
