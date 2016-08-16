package com.yapta.travel;

import com.yapta.travel.client.IPnrService;
import com.yapta.travel.client.PnrService;
import com.yapta.travel.health.PnrHealthCheck;
import com.yapta.travel.resources.PnrResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TravelApplication extends Application<TravelConfiguration> {

    public static void main(String[] args) throws Exception {
        new TravelApplication().run(args);
    }

    @Override
    public String getName() {
        return "travel-application";
    }

    @Override
    public void initialize(Bootstrap<TravelConfiguration> bootstrap) {

    }

    @Override
    public void run(TravelConfiguration travelConfiguration, Environment environment) throws Exception {
        final IPnrService pnrService = new PnrService();
        final PnrResource pnrResource = new PnrResource(pnrService);
        environment.jersey().register(pnrResource);

        final PnrHealthCheck healthCheck = new PnrHealthCheck(pnrService);
        environment.healthChecks().register("pnr", healthCheck);

        //TODO: add pricing endpoint
    }
}
