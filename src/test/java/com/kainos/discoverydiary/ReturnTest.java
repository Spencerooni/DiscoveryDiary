package com.kainos.discoverydiary;

import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.models.Status;
import com.kainos.discoverydiary.resources.MediaResource;
import org.junit.Assert;
import org.junit.Test;

public class ReturnTest {

    @Test
    public void shouldReturnBook() throws Exception{
        //Arrange
        Media media = new Media("Advances in Relationship Marketing", "Adrian Payne", "Advances in Relationship Marketing by Adrian Payne", Category.TECHNICAL, "1995", "bob", Status.AVAILABLE, "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        //Act
        mediaResource.Return(media.getId());

        //Assert
        Assert.assertEquals(Status.AVAILABLE, media.getStatus());
    }

    @Test
    public void shouldNotReturnBook() throws Exception{
        Media media = new Media("Advances in Relationship Marketing", "Adrian Payne", "Advances in Relationship Marketing by Adrian Payne", Category.TECHNICAL, "1995", null, Status.ON_LOAN, "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        //Act
        mediaResource.Return(media.getId());

        //Assert
        Assert.assertNotEquals(Status.ON_LOAN, media.getStatus());
    }
}
