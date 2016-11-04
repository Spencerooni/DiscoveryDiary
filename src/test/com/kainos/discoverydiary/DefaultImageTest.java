package com.kainos.discoverydiary;

import com.kainos.discoverydiary.models.Category;
import com.kainos.discoverydiary.models.Media;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by peterbo on 04/11/2016.
 */
public class DefaultImageTest {
    @Test
    public void test_default_image_url() {
        Media media1 = new Media("Ben", "Ben", "Funktion Golf", Category.NON_TECHNICAL, "2008");
        Assert.assertEquals(media1.getImageUrl(), "https://www.asme.org/getmedia/c2c8ea5a-b690-4ba7-92bb-34bd1432862b/book_guide_hero_books.aspx");
    }


}
