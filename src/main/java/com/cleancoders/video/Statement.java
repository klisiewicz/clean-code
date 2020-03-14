package com.cleancoders.video;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    private String customerName;
    private List<Rental> rentals = new ArrayList<>();
    private int frequentRenterPoints;
    private double totalAmount;

    public Statement(String customerName) {
        this.customerName = customerName;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String generate() {
        clearTotals();
        String statementText = header();
        statementText += rentalLines();
        statementText += footer();
        return statementText;
    }

    private void clearTotals() {
        totalAmount = 0;
        frequentRenterPoints = 0;
    }

    private String header() {
        return String.format("Rental Record for %s%n", customerName);
    }

    private String rentalLines() {
        String rentalLines = "";
        for (Rental rental : rentals)
            rentalLines += rentalLine(rental);
        return rentalLines;
    }

    private String rentalLine(Rental rental) {
        double rentalAmount = rental.determineAmount();
        frequentRenterPoints += rental.determineFrequentRentalPoints();
        totalAmount += rentalAmount;
        return formatRentalLine(rental, rentalAmount);
    }

    private String formatRentalLine(Rental rental, double rentalAmount) {
        return "\t" + rental.getTitle() + "\t" + rentalAmount + "\n";
    }

    private String footer() {
        return "You owed " + totalAmount + "\n" +
                "You earned " + frequentRenterPoints + " frequent renter points\n";
    }

    public double getTotal() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}
