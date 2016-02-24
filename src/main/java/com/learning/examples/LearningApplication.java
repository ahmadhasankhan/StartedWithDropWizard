package com.learning.examples;

import com.learning.examples.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;


/**
 * Created by ahmadhassan on 21/05/15.
 */
public class LearningApplication extends Application<LearningConfiguration> {

    public static void main(String[] args) throws Exception {
        new LearningApplication().run(new String[]{"server"});
    }

    @Override
    public void initialize(Bootstrap<LearningConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(LearningConfiguration configuration, Environment environment) throws Exception {
        final HelloResource hello = new HelloResource();
        environment.jersey().register(hello);
    }
}
