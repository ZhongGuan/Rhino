package authenticate.service.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.Subject;

import authenticate.api.Authenticate;
import authenticate.model.UserBean;
import authenticate.service.LoginService;

@Named("loginService")
@RequestScoped
public class LoginServiceImpl implements LoginService {

	@Inject
	private UserBean userBean;
	
	@Inject
	private Authenticate authenticate;
	
	@Override
	public String login() {
		
		Subject subject = authenticate.authenticate(userBean.getUserName(), userBean.getPassword());
		
		return "welcome";
	}

}
