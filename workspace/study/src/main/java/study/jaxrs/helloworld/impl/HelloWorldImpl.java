package study.jaxrs.helloworld.impl;

import javax.ws.rs.Path;

import study.jaxrs.helloworld.HelloWorldService;

@Path("/helloworld")
public class HelloWorldImpl implements HelloWorldService {

	@Override
	public String getHtml() {
		return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
	}

}
