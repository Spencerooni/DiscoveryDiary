package com.kainos.discoverydiary.views;

import com.kainos.discoverydiary.models.Media;
import io.dropwizard.views.View;

import java.util.List;

/**
 * Created by benl on 03/11/2016.
 */


    public class Homepage extends View {

    private final List<Media> medias;

    private int bookCount;

    public void setUserSearchText(String userSearchText) {
        this.userSearchText = userSearchText;
    }

    public String getUserSearchText() {
        return userSearchText;
    }

    private String userSearchText;

    public String getUserDropDown() {
        return userDropDown;
    }

    public void setUserDropDown(String userDropDown) {
        this.userDropDown = userDropDown;
    }

    private String userDropDown;

    public Homepage(List<Media> medias) {
        super("/Views/Media/homepage.ftl");
        this.medias = medias;

    }

    public Homepage(List<Media> medias, String userSearchText, String userDropDown) {
        super("/Views/Media/homepage.ftl");
        this.medias = medias;
        this.userSearchText = userSearchText;
        this.userDropDown = userDropDown;

    }

    public List<Media> getMedias() {
        return medias;
    }

    public int getMediaCount() {
        return medias.size();
    }




}
