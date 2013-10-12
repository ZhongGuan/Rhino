package authenticate.api;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import authenticate.api.principal.SysAdminPrincipal;
import authenticate.repository.UserRepository;
import authenticate.repository.domain.User;

import common.helper.CdiHelper;

public class SimpleLoginModule implements LoginModule {

	private Subject subject;
	private CallbackHandler callbackHandler;
	private String name;
	private String password;

	@Inject
	private UserRepository userRepository;
	
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {

		this.subject = subject;
		this.callbackHandler = callbackHandler;

	}

	@Override
	public boolean login() throws LoginException {

		NameCallback nameCallback = new NameCallback("Username");
		PasswordCallback passwordCallback = new PasswordCallback("Password",
				false);
		Callback[] callbacks = new Callback[] { nameCallback, passwordCallback };

		try {
			callbackHandler.handle(callbacks);
		} catch (IOException | UnsupportedCallbackException e) {
			e.printStackTrace();
			LoginException ex = new LoginException("Exception");
			ex.initCause(e);
			throw ex;
		}
		
		name = nameCallback.getName();
		password = String.valueOf(passwordCallback.getPassword());
		
		if (userRepository == null) {
			try {
				userRepository = CdiHelper.getBeanInstance(UserRepository.class, RequestScoped.class);
			} catch (NamingException e) {
				return false;
			}
		}
		User user = userRepository.find(name);
		// TODO Password encript
		if (user != null && password.equals(user.getPassword())) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		
		if ("guanzh".equals(name)) {
			Principal p = new SysAdminPrincipal(name);
			subject.getPrincipals().add(p);
			password = null;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean abort() throws LoginException {
		name = null;
		password = null;
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		name = null;
		password = null;
		return true;
	}

}
