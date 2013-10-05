package study.jaxrs.helloworld;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import study.jaxrs.helloworld.model.Customer;
import study.jaxrs.helloworld.model.PhoneNumber;

@ApplicationScoped
@Path("/helloworld")
public class HelloWorld {

    @GET
    @Path("getHtml")
    @Produces(MediaType.TEXT_HTML)
	public String getHtml() {
		System.out.println(this);
		return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
	}
    
    @GET
    @Path("getCustomerXml")
    @Produces(MediaType.APPLICATION_XML)
	public Customer getCustomerXml() {
    	Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Zhong Guan");
         
        PhoneNumber pn = new PhoneNumber();
        pn.setType("work");
        pn.setValue("5551111");
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(pn);
        customer.setPhoneNumbers(phoneNumbers);
        
        return customer;
	}
    
    @GET
    @Path("getCustomerJson")
    @Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerJson() {
    	Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Zhong Guan");
         
        PhoneNumber pn = new PhoneNumber();
        pn.setType("work");
        pn.setValue("5551111");
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(pn);
        customer.setPhoneNumbers(phoneNumbers);
        
        return customer;
	}
}
