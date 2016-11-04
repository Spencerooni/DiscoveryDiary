package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;
import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.models.Status;
import com.kainos.discoverydiary.views.Add;
import com.kainos.discoverydiary.views.Detail;
import com.kainos.discoverydiary.views.Homepage;
import io.dropwizard.views.View;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Path("media")
public class MediaResource {

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public Homepage Homepage() {
        List<Media> medias = new ArrayList<Media>(DataStore.medias.values());
        Collections.sort(medias);
        return new Homepage(medias);
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
    @Path("{id}/borrow")
    public Response Borrow(@PathParam("id") int id, @FormParam("nameOfBorrower") String nameOfBorrower) throws Exception {

        Media media = DataStore.medias.get(id);

        if (media.getStatus() == Status.AVAILABLE) {
            media.setNameOfBorrower(nameOfBorrower);
            media.setStatus(Status.ON_LOAN);
        }
        return Response.seeOther(new URI("/media/" + id)).entity(Detail(id)).build();
    }

    @POST
    @Timed
    @Path("{id}/return")
    public Response Return(@PathParam("id") int id, @FormParam("location") String location) throws Exception {

        Media media = DataStore.medias.get(id);

        if (media.getStatus() == Status.ON_LOAN) {
            media.setStatus(Status.AVAILABLE);
            media.setLocation(location);
        }
        return Response.seeOther(new URI("/media/" + id)).entity(Detail(id)).build();

    }

    @GET
    @Timed
    @Path("add")
    @Produces(MediaType.TEXT_HTML)
    public View Add() {
        return new Add();
    }
    @POST
    @Timed
    @Path("add")
    @Produces(MediaType.TEXT_HTML)
    public View Add(@FormParam("title") String title, @FormParam("author") String author, @FormParam("description") String description, @FormParam("category") String categoryString, @FormParam("publicationDate") String publicationDate, @FormParam("imageUrl") String imageUrl) {
        Category category = (categoryString.equals("Technical")) ? Category.TECHNICAL : Category.NON_TECHNICAL;
        imageUrl = (imageUrl.equals("")) ? "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx" : imageUrl;
        Media media = new Media(title, author, description, category, publicationDate, imageUrl);
        DataStore.medias.put(media.getId(), media);
        return new Add();
    }

    @Path("search")
    public Homepage Search(@QueryParam("searchText") String searchText, @QueryParam("searchOption") String searchOption){

        List<Media> medias = new ArrayList<Media>(DataStore.medias.values());

        if(searchOption.equals("Title")) {

            List<Media> searchList = medias.stream().filter(x -> x.getTitle().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
            return new Homepage(searchList, searchText, searchOption);

        } else {
            List<Media> searchList = medias.stream().filter(x -> x.getPublicationDate().equals(searchText)).collect(Collectors.toList());
            return new Homepage(searchList, searchText, searchOption);
        }
    }
}