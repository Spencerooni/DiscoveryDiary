package com.kainos.discoverydiary.models;

public class Media  implements Comparable<Media> {



    private int id;
    private String title;
    private String author;
    private String description;
    private Category category;
    private String publicationDate;
    private String imageUrl;
    private String nameOfBorrower;
    private Status status;

    private static int count = 0;


    public Media(String title, String author, String description, Category category, String publicationDate, String nameOfBorrower, Status status, String imageUrl) {
        this(title, author, description, category, publicationDate, imageUrl);
        this.nameOfBorrower = nameOfBorrower;
        this.status = status;
    }


    public Media(String title, String author, String description, Category category, String publicationDate, String imageUrl){

        count++;
        this.id = count;
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.publicationDate = publicationDate;
        this.imageUrl = imageUrl;

        this.status = Status.AVAILABLE;

    }

    public int getId() {
        return id;
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


    public String getImageUrl() {
        return imageUrl;
    }

    public static int getCount() {
        return count;
    }


    @Override
    public int compareTo(Media o) {
        return  this.title.compareTo(o.title);
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