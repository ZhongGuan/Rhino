package study.jaxrs.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

public interface HelloWorldService {
	
    @GET
    @Produces("text/html")
	String getHtml();

}
