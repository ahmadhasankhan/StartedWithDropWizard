package com.learning.java;

import com.learning.java.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * Created by ahmadhassan on 21/05/15.
 */
public class LearningApplication extends Application<LearningConfiguration> {

    public static void main(String[] args) throws Exception {
        new LearningApplication().run(new String[]{"server"});
    }

    @Override
    public void initialize(Bootstrap<LearningConfiguration> bootstrap) {

    }

    @Override
    public void run(LearningConfiguration configuration, Environment environment) throws Exception {
        final HelloResource hello = new HelloResource();
        environment.jersey().register(hello);
    }
}
