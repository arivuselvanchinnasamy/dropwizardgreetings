package com.arivu.dropwizard.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greetings")
public class GreetingsResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getGreeting() {
		return "Hi!... Welcome to Greetings rest service developed using Dropwizard";
	}
	
	@Path("/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNamedGreetings(@PathParam(value = "name") String name) {
        return "Hi! Mr./Mrs. " + name + ". Welcome to Greetings rest service developed using Dropwizard";
    }
}
