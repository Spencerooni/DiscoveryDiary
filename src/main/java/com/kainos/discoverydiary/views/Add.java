package com.kainos.discoverydiary.views;
import com.kainos.discoverydiary.models.Media;
import io.dropwizard.views.View;
public class Add extends View {
    public Add(){
        super("/Views/Media/add.ftl");
    }
}