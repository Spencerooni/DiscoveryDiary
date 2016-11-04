package com.kainos.discoverydiary;

import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import com.kainos.discoverydiary.models.Status;
import com.kainos.discoverydiary.resources.MediaResource;
import com.kainos.discoverydiary.views.Homepage;
import org.junit.Assert;
import org.junit.Test;

public class AlphabeticalTest {

    @Test
    public void getAllMediaReturnsMediaInAlphabeticalOrder() {
        //Arrange
        MediaResource mediaResource = new MediaResource();

        Media media = new Media("Advances in Relationship Marketing", "Adrian Payne", "Advances in Relationship Marketing by Adrian Payne", Category.TECHNICAL, "1995", "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);

        Media media2 = new Media("Windows Server 2003 Network Infrastructure", "Craig Zacker", "Study guide for MCSE Exam 70-293", Category.TECHNICAL, "2004", "https://images-na.ssl-images-amazon.com/images/I/51Zu4ldN6PL._SX408_BO1,204,203,200_.jpg");
        DataStore.medias.put(media2.getId(), media2);

        Media media3 = new Media("Oat So Simple", "Quaker", "9 sachets of porridge", Category.NON_TECHNICAL, "2016", "https://www.quaker.co.uk/images/default-source/products/quaker-traditional-oats/quaker-oats-1kg.png?sfvrsn=8");
        DataStore.medias.put(media3.getId(), media3);

        //Act
        Homepage result = mediaResource.Homepage();

        System.out.println(result.getMedias().get(0));
        //Assert
        Assert.assertEquals((result.getMedias().get(0).getTitle()), "Advances in Relationship Marketing");
        Assert.assertEquals((result.getMedias().get(1).getTitle()), "Oat So Simple");
        Assert.assertEquals((result.getMedias().get(2).getTitle()), "Windows Server 2003 Network Infrastructure");
    }

    @Test
    public void getAllMediaReturnsMediaInAlphabeticalOrderShowFails() {
        //Arrange
        MediaResource mediaResource = new MediaResource();

        Media media = new Media("Advances in Relationship Marketing", "Adrian Payne", "Advances in Relationship Marketing by Adrian Payne", Category.TECHNICAL, "1995", "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
        DataStore.medias.put(media.getId(), media);

        Media media2 = new Media("Windows Server 2003 Network Infrastructure", "Craig Zacker", "Study guide for MCSE Exam 70-293", Category.TECHNICAL, "2004", "https://images-na.ssl-images-amazon.com/images/I/51Zu4ldN6PL._SX408_BO1,204,203,200_.jpg");
        DataStore.medias.put(media2.getId(), media2);

        Media media3 = new Media("Oat So Simple", "Quaker", "9 sachets of porridge", Category.NON_TECHNICAL, "2016", "https://www.quaker.co.uk/images/default-source/products/quaker-traditional-oats/quaker-oats-1kg.png?sfvrsn=8");
        DataStore.medias.put(media3.getId(), media3);

        //Act
        Homepage result = mediaResource.Homepage();

        System.out.println(result.getMedias().get(0));
        //Assert
        Assert.assertNotEquals((result.getMedias().get(2).getTitle()), "Advances in Relationship Marketing");
        Assert.assertNotEquals((result.getMedias().get(0).getTitle()), "Oat So Simple");
        Assert.assertNotEquals((result.getMedias().get(1).getTitle()), "Windows Server 2003 Network Infrastructure");
    }
}
