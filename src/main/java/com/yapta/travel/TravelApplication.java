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

        import javax.ws.rs.GET;
        import javax.ws.rs.Path;
        import javax.ws.rs.PathParam;
        import javax.ws.rs.Produces;
        import javax.ws.rs.core.MediaType;

        @Path("/prices/{recordLocator}")
        @Produces(MediaType.TEXT_PLAIN)
        public class PnrResource {

            private final IPnrService pnrService;

            public PnrResource(IPnrService pnrService) {

                this.pnrService = pnrService;
            }

            @GET
            public String fetchPnr(@PathParam("recordLocator")String recordLocator) {
                try {
                    return pnrService.fetchPnr(recordLocator);
                } catch (PnrNotFoundException e) {
                    return "PNR NOT FOUND";
                }
            }

        }


        //create endpoint that can take in a record locator 
    }
}
