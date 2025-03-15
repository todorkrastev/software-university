package org.softuni.exam.entities;

public class Movie {
    private String id;

    private int durationInMinutes;

    private String title;

    private double rating;

    private double budget;

    public Movie(String id, int durationInMinutes, String title, double rating, double budget) {
        this.id = id;
        this.durationInMinutes = durationInMinutes;
        this.title = title;
        this.rating = rating;
        this.budget = budget;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
