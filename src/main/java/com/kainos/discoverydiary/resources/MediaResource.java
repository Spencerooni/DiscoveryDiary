package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;
import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.models.Status;
import com.kainos.discoverydiary.views.Detail;
import io.dropwizard.views.View;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("media")
public class MediaResource {

    public MediaResource() {
        //Dummy Data

    }

    @GET
    @Timed
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public View Detail(@PathParam("id") int id) {
        return new Detail(DataStore.medias.get(id));
    }

    @POST
    @Timed
    @Path("{id}")
    public View Borrow(@PathParam("id") int id, @FormParam("nameOfBorrower") String nameOfBorrower) {

        Media media = DataStore.medias.get(id);

        if (media.getStatus() == Status.AVAILABLE) {
            media.setNameOfBorrower(nameOfBorrower);
            media.setStatus(Status.ON_LOAN);
        }

        return Detail(id);
    }

    @POST
    @Timed
    @Path("{id}/return")
    public View Return(@PathParam("id") int id) {

        Media media = DataStore.medias.get(id);

        if (media.getStatus() == Status.ON_LOAN) {
            media.setStatus(Status.AVAILABLE);
        }

        return Detail(id);
    }
}
