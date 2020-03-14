package com.cleancoders.video;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double determineAmount(int daysRented) {
        return (daysRented > 3) ? (daysRented - 3) * 1.5 : 1.5;
    }

    @Override
    public int determineFrequentRentalPoints(int daysRented) {
        return 1;
    }
}
