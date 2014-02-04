package authenticate.service.impl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import authenticate.service.LoginService;

@Alternative
@Named("loginService")
@RequestScoped
public class LoginServiceMock implements LoginService {

	@Override
	public String login() {
		return "welcome";
	}

}
