package com.cleancoders.video;

public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int code) {
        priceCode = code;
    }

    public String getTitle() {
        return title;
    }

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

    public int determineFrequentRentalPoints(int daysRented) {
        boolean bonusIsEarned = priceCode == NEW_RELEASE && daysRented > 1;
        if (bonusIsEarned)
            return 2;
        return 1;
    }
}
