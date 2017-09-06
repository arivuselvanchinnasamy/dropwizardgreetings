package com.arivu.dropwizard;

import com.arivu.dropwizard.resources.GreetingsResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GreetingsApplication extends Application<GreetingsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GreetingsApplication().run(args);
    }

    @Override
    public String getName() {
        return "Greetings";
    }

    @Override
    public void initialize(final Bootstrap<GreetingsConfiguration> bootstrap) {
   
    }

    @Override
    public void run(final GreetingsConfiguration configuration,
                    final Environment environment) {
    	 environment.jersey().register(new GreetingsResource());
    }

}
