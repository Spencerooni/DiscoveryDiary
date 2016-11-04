package com.kainos.discoverydiary.views;

import com.kainos.discoverydiary.models.Media;
import io.dropwizard.views.View;

import java.util.List;

    public class Homepage extends View {

    private final List<Media> medias;

    private int bookCount;

    public Homepage(List<Media> medias) {
        super("/Views/Media/homepage.ftl");
        this.medias = medias;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public int getMediaCount() {
        return medias.size();
    }
}
