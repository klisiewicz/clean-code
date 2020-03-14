package com.cleancoders.video;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public double determineAmount() {
        return movie.determineAmount(daysRented);
    }

    public int determineFrequentRentalPoints() {
        return movie.determineFrequentRentalPoints(daysRented);
    }
}
