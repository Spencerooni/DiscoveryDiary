package com.kainos.discoverydiary.models;

public enum Category {

    TECHNICAL("Technical"),
    NON_TECHNICAL("Non Technical");

    private final String name;

    private Category(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}

