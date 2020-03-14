package com.cleancoders.video;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        assertEquals(
                "Rental Record for Fred\n\t" +
                        "The Cell\t9.0\n" +
                        "You owed 9.0\nYou earned 2 frequent renter points\n",
                customer.statement());
        assertThat(customer.getTotal(), is(9.0));
        assertThat(customer.getFrequentRenterPoints(), is(2));
    }

    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Tiger Movie", Movie.NEW_RELEASE), 3));
        assertEquals(
                "Rental Record for Fred\n" +
                        "\tThe Cell\t9.0\n" +
                        "\tThe Tiger Movie\t9.0\n" +
                        "You owed 18.0\n" +
                        "You earned 4 frequent renter points\n",
                customer.statement());
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tiger Movie", Movie.CHILDRENS), 3));
        assertEquals(
                "Rental Record for Fred\n" +
                        "\tThe Tiger Movie\t1.5\n" +
                        "You owed 1.5\n" +
                        "You earned 1 frequent renter points\n",
                customer.statement());
    }

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));

        assertEquals(
                "Rental Record for Fred\n" +
                        "\tPlan 9 from Outer Space\t2.0\n" +
                        "\t8 1/2\t2.0\n" +
                        "\tEraserhead\t3.5\n" +
                        "You owed 7.5\n" +
                        "You earned 3 frequent renter points\n",
                customer.statement());
    }
}
