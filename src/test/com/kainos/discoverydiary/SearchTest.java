package com.kainos.discoverydiary;

import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.resources.MediaResource;
import com.kainos.discoverydiary.views.Homepage;
import io.dropwizard.views.View;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by peterbo on 04/11/2016.
 */
public class SearchTest {

    @Test
    public void searchShouldReturnResult(){

        DiscoveryDiaryApplication.addDummyData();
        MediaResource mediaResource = new MediaResource();
        Homepage searchView = mediaResource.Search("Ben", "Title");
        Assert.assertEquals(searchView.getMedias().size(), 1);
    }
}
