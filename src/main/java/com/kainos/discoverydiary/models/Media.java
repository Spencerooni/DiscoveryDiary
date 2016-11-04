package com.kainos.discoverydiary.models;

import org.joda.time.DateTime;
import java.util.ArrayList;

public class Media {

    private int id;
    private String title;
    private String author;
    private String description;
    private Category category;
    private String publicationDate;
    private String nameOfBorrower;
    private Status status;

    private static int count = 0;

    public Media(String title, String author, String description, Category category, String publicationDate, String nameOfBorrower, Status status) {
        this(title, author, description, category, publicationDate);
        this.nameOfBorrower = nameOfBorrower;
        this.status = status;
    }


    public Media(String title, String author, String description, Category category, String publicationDate){

        count++;
        this.id = count;
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.publicationDate = publicationDate;
        this.status = Status.AVAILABLE;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getNameOfBorrower() {
        return nameOfBorrower;
    }

    public Status getStatus() {
        return status;
    }

    public void setNameOfBorrower(String nameOfBorrower) {
        this.nameOfBorrower = nameOfBorrower;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
