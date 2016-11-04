package com.kainos.discoverydiary;

import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.resources.MediaResource;
import com.kainos.discoverydiary.views.Homepage;
import io.dropwizard.views.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by peterbo on 04/11/2016.
 */
public class SearchTest {

    @Before
    public void setup() {

        DataStore.medias.clear();
        DiscoveryDiaryApplication.addDummyData();

    }

    @Test
    public void searchShouldReturnResultForCorrectTitle() {

        MediaResource mediaResource = new MediaResource();
        Homepage searchView = mediaResource.Search("Ben", "Title");
        Assert.assertEquals(searchView.getMedias().size(), 1);
    }

    @Test
    public void searchShouldReturnNothingForIncorrectYear() {

        MediaResource mediaResource = new MediaResource();
        Homepage searchView = mediaResource.Search("98134298", "Year");
        Assert.assertEquals(searchView.getMedias().size(), 0);
    }

    @Test
    public void searchShouldReturnResultForCorrectYear() {

        MediaResource mediaResource = new MediaResource();
        Homepage searchView = mediaResource.Search("1995", "Year");
        Assert.assertEquals(searchView.getMedias().size(), 1);
    }

    @Test
    public void searchShouldReturnNothingForIncorrectTitle() {

        MediaResource mediaResource = new MediaResource();
        Homepage searchView = mediaResource.Search("hiofwehiowhefIHAWIOF", "Title");
        Assert.assertEquals(searchView.getMedias().size(), 0);
    }

    @Test
    public void searchShouldReturn6ResultsForNullSearch() {

        MediaResource mediaResource = new MediaResource();
        Homepage searchView = mediaResource.Search("", "Title");
        Assert.assertEquals(searchView.getMedias().size(), 6);
    }
}
