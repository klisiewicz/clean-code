package com.cleancoders.video;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double determineAmount(int daysRented) {
        return (daysRented > 2) ? 2 + (daysRented - 2) * 1.5 : 2;
    }

    @Override
    public int determineFrequentRentalPoints(int daysRented) {
        return 1;
    }
}
