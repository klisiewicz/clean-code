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
        boolean bonusIsEarned = getMovie().getPriceCode() == Movie.NEW_RELEASE && daysRented > 1;
        if (bonusIsEarned)
            return 2;
        return 1;
    }
}
