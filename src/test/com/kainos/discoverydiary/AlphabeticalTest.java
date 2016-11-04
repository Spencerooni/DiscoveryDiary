package com.kainos.discoverydiary;

import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.models.Status;
import com.kainos.discoverydiary.resources.MediaResource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eamonc on 04/11/2016.
 */
public class AlphabeticalTest {

    @Test
    public void ifAlphabetical() {
        //Arrange
        Media media = new Media("Advances in Relationship Marketing", "Adrian Payne", "Advances in Relationship Marketing by Adrian Payne", Category.TECHNICAL, "1995", "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);
        MediaResource mediaResource = new MediaResource();

        Media media2 = new Media("Windows Server 2003 Network Infrastructure", "Craig Zacker", "Study guide for MCSE Exam 70-293", Category.TECHNICAL, "2004", "https://images-na.ssl-images-amazon.com/images/I/51Zu4ldN6PL._SX408_BO1,204,203,200_.jpg");
        DataStore.medias.put(media2.getId(), media2);
        MediaResource mediaResource2 = new MediaResource();

        Media media3 = new Media("Oat So Simple", "Quaker", "9 sachets of porridge", Category.NON_TECHNICAL, "2016", "https://www.quaker.co.uk/images/default-source/products/quaker-traditional-oats/quaker-oats-1kg.png?sfvrsn=8");
        DataStore.medias.put(media3.getId(), media3);
        MediaResource mediaResource3 = new MediaResource();

        //Act
        mediaResource.Detail(media.getId());
        mediaResource2.Detail(media.getId());
        mediaResource3.Detail(media.getId());

        //Assert
        Assert.assertEquals(Status.AVAILABLE, media.getStatus());
    }
}
