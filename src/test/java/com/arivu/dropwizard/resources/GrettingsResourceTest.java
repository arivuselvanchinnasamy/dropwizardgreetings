package com.arivu.dropwizard.resources;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;

public class GrettingsResourceTest {

    @Rule
    public ResourceTestRule resource = ResourceTestRule.builder()
            .addResource(new GreetingsResource()).build();

    @Test
    public void testGetGreeting() {
        String expected = "Hi!... Welcome to Greetings rest service developed using Dropwizard";
        //Obtain client from @Rule.
        Client client = resource.client();
        //Get WebTarget from client using URI of root resource.
        WebTarget greetingTarget = client.target("http://localhost:8080/greetings");
        //To invoke response we use Invocation.Builder
        //and specify the media type of representation asked from resource.
        Invocation.Builder builder = greetingTarget.request(MediaType.TEXT_PLAIN);
        //Obtain response.
        Response response = builder.get();

        //Do assertions.
        assertEquals(Response.Status.OK, response.getStatusInfo());
        String actual = response.readEntity(String.class);
        assertEquals(expected, actual);

    }
    @Test
    public void testGetNamedGreeting() {
        String expected = "Hi! Mr./Mrs. Arivuselvan. Welcome to Greetings rest service developed using Dropwizard";
        //Obtain client from @Rule.
        Client client = resource.client();
        //Get WebTarget from client using URI of root resource.
        WebTarget greetingTarget = client.target("http://localhost:8080/greetings/Arivuselvan");
        //To invoke response we use Invocation.Builder
        //and specify the media type of representation asked from resource.
        Invocation.Builder builder = greetingTarget.request(MediaType.TEXT_PLAIN);
        //Obtain response.
        Response response = builder.get();

        //Do assertions.
        assertEquals(Response.Status.OK, response.getStatusInfo());
        String actual = response.readEntity(String.class);
        assertEquals(expected, actual);

    }
}
