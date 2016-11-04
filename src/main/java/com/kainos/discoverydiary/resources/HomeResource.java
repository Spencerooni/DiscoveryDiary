package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("")
public class HomeResource {

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public Response Homepage() throws Exception {
        return Response.seeOther(new URI("/media")).build();
    }
}
