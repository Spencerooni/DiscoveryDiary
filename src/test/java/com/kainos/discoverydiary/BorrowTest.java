package com.kainos.discoverydiary;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.models.Status;
import com.kainos.discoverydiary.resources.MediaResource;
import org.junit.Assert;
import org.junit.Test;

public class BorrowTest {

    @Test
    public void shouldBorrowBook() throws Exception{
        //Arrange
        Media media = new Media("Advances in Relationship Marketing", "Adrian Payne", "Advances in Relationship Marketing by Adrian Payne", Category.TECHNICAL, "1995", "bob", Status.AVAILABLE, "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        //Act
        mediaResource.Borrow(media.getId(),"Borrower");

        //Assert
        Assert.assertEquals("Borrower", media.getNameOfBorrower());
        Assert.assertEquals(Status.ON_LOAN, media.getStatus());
    }

    @Test
    public void shouldNotBorrowBook() throws Exception{
        Media media = new Media("Advances in Relationship Marketing", "Adrian Payne", "Advances in Relationship Marketing by Adrian Payne", Category.TECHNICAL, "1995", null, Status.ON_LOAN, "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        //Act
        mediaResource.Borrow(media.getId(),"NewBorrower");

        //Assert
        Assert.assertNotEquals("NewBorrower", media.getNameOfBorrower());
    }

}
