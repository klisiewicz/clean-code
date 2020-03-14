package com.cleancoders.video;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title, Movie.REGULAR);
    }

    @Override
    public double determineAmount(int daysRented) {
        double rentalAmount = 0;
        // determines the amount for each line
        switch (priceCode) {
            case REGULAR:
                rentalAmount += 2;
                if (daysRented > 2)
                    rentalAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case CHILDRENS:
                rentalAmount += 1.5;
                if (daysRented > 3)
                    rentalAmount += (daysRented - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }

    @Override
    public int determineFrequentRentalPoints(int daysRented) {
        boolean bonusIsEarned = priceCode == NEW_RELEASE && daysRented > 1;
        return (bonusIsEarned) ? 2 : 1;
    }
}
