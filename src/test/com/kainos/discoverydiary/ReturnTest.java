package com.kainos.discoverydiary;

import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.models.Status;
import com.kainos.discoverydiary.resources.MediaResource;
import org.junit.Assert;
import org.junit.Test;

public class ReturnTest {

    @Test
    public void shouldReturnBook() {
        Media media = new Media("Java For Dummies", "J K Bowling", "Training book on java", Category.TECHNICAL, "2001", "Borrower", Status.ON_LOAN);
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        //Act
        mediaResource.Return(media.getId());

        //Assert
        Assert.assertEquals(Status.AVAILABLE, media.getStatus());
    }

    @Test
    public void shouldNotReturnBook() {
        //Arrange
        Media media = new Media("Java For Dummies", "J K Bowling", "Training book on java", Category.TECHNICAL, "2001", "Borrower", Status.IN_DISREPAIR);
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        //Act
        mediaResource.Return(media.getId());

        //Assert
        Assert.assertNotEquals(Status.AVAILABLE, media.getStatus());
    }
}
