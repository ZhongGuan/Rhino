package study.jaxrs.helloworld;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@ApplicationScoped
@Path("/helloworld")
public class HelloWorld {

    @GET
    @Produces("text/html")
	public String getHtml() {
		System.out.println(this);
		return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
	}

}
