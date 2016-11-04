package com.kainos.discoverydiary;

import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.models.Status;
import com.kainos.discoverydiary.resources.MediaResource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aoifeg on 04/11/2016.
 */
public class MediaStatusTest {
    @Test
    public void ifMediaAvailableShowStatus() {
        //Arrange
        Media media = new Media("Java For Dummies", "J K Bowling", "Training book on java", Category.TECHNICAL, "2001", "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        //Act
        mediaResource.Detail(media.getId());

        //Assert
        Assert.assertEquals(Status.AVAILABLE, media.getStatus());
    }

    @Test
    public void ifMediaInDisrepairShowStatus() {
        //Arrange
        Media media = new Media("The Big Book of Java", "Stephen Hawking", "Training book on Java", Category.TECHNICAL, "1980", null, Status.IN_DISREPAIR, "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        //Act
        mediaResource.Detail(media.getId());

        //Assert
        Assert.assertEquals(Status.IN_DISREPAIR, media.getStatus());
    }

    @Test
    public void ifMediaOnLoanShowStatusAndLoaneeDetails() {
        //Arrange
        Media media = new Media("The ins and outs of Ruby on Rails", "Mail Serrif", "Training book on Ruby", Category.TECHNICAL, "1980", "Sean", Status.ON_LOAN, "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        //Act
        mediaResource.Detail(media.getId());

        //Assert
        Assert.assertEquals(Status.ON_LOAN, media.getStatus());
    }
}
