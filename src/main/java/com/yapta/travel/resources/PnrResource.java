package com.yapta.travel.resources;

import com.yapta.travel.client.IPnrService;
import com.yapta.travel.client.PnrNotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pnrs/{recordLocator}")
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
