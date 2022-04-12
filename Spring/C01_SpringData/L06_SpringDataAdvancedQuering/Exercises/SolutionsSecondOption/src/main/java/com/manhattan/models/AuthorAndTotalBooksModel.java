package com.manhattan.models;

public class AuthorAndTotalBooksModel {
    private String fullName;
    private long bookCount;

    public AuthorAndTotalBooksModel(String fullName, long bookCount) {
        this.fullName = fullName;
        this.bookCount = bookCount;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", fullName, bookCount);
    }
}
