package com.cleancoders.video;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StatementTest {
    private Statement statement;

    @Before
    public void setUp() {
        statement = new Statement("Fred");
    }

    @Test
    public void testSingleNewReleaseStatementTotals() {
        statement.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        statement.generate();
        assertThat(statement.getTotal(), is(9.0));
        assertThat(statement.getFrequentRenterPoints(), is(2));
    }

    @Test
    public void testDualNewReleaseStatementTotals() {
        statement.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        statement.addRental(new Rental(new Movie("The Tiger Movie", Movie.NEW_RELEASE), 3));
        statement.generate();
        assertThat(statement.getTotal(), is(18.0));
        assertThat(statement.getFrequentRenterPoints(), is(4));
    }

    @Test
    public void testSingleChildrensStatementTotals() {
        statement.addRental(new Rental(new Movie("The Tiger Movie", Movie.CHILDRENS), 3));
        statement.generate();
        assertThat(statement.getTotal(), is(1.5));
        assertThat(statement.getFrequentRenterPoints(), is(1));
    }

    @Test
    public void testMultipleRegularStatementTotals() {
        statement.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        statement.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        statement.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));
        statement.generate();
        assertThat(statement.getTotal(), is(7.5));
        assertThat(statement.getFrequentRenterPoints(), is(3));
    }

    @Test
    public void testMultipleRegularStatementFormat() {
        statement.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        statement.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        statement.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));

        assertEquals(
                "Rental Record for Fred\n" +
                        "\tPlan 9 from Outer Space\t2.0\n" +
                        "\t8 1/2\t2.0\n" +
                        "\tEraserhead\t3.5\n" +
                        "You owed 7.5\n" +
                        "You earned 3 frequent renter points\n",
                statement.generate());
    }
}
