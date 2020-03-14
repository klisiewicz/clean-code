package com.cleancoders.video;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StatementTest {
    private Statement statement;
    private Movie newReleaseMovie1;
    private Movie newReleaseMovie2;
    private Movie childrenMovie;
    private Movie regularMovie1;
    private Movie regularMovie2;
    private Movie regularMovie3;

    @Before
    public void setUp() {
        statement = new Statement("Customer");
        newReleaseMovie1 = new NewReleaseMovie("New Release 1");
        newReleaseMovie2 = new NewReleaseMovie("New Release 2");
        childrenMovie = new ChildrenMovie("Children");
        regularMovie1 = new RegularMovie("Regular 1");
        regularMovie2 = new RegularMovie("Regular 2");
        regularMovie3 = new RegularMovie("Regular 3");
    }

    @Test
    public void testSingleNewReleaseStatementTotals() {
        statement.addRental(new Rental(newReleaseMovie1, 3));
        statement.generate();
        assertThat(statement.getTotal(), is(9.0));
        assertThat(statement.getFrequentRenterPoints(), is(2));
    }

    @Test
    public void testDualNewReleaseStatementTotals() {
        statement.addRental(new Rental(newReleaseMovie1, 3));
        statement.addRental(new Rental(newReleaseMovie2, 3));
        statement.generate();
        assertThat(statement.getTotal(), is(18.0));
        assertThat(statement.getFrequentRenterPoints(), is(4));
    }

    @Test
    public void testSingleChildrensStatementTotals() {
        statement.addRental(new Rental(childrenMovie, 3));
        statement.generate();
        assertThat(statement.getTotal(), is(1.5));
        assertThat(statement.getFrequentRenterPoints(), is(1));
    }

    @Test
    public void testMultipleRegularStatementTotals() {
        statement.addRental(new Rental(regularMovie1, 1));
        statement.addRental(new Rental(regularMovie2, 2));
        statement.addRental(new Rental(regularMovie3, 3));
        statement.generate();
        assertThat(statement.getTotal(), is(7.5));
        assertThat(statement.getFrequentRenterPoints(), is(3));
    }

    @Test
    public void testMultipleRegularStatementFormat() {
        statement.addRental(new Rental(regularMovie1, 1));
        statement.addRental(new Rental(regularMovie2, 2));
        statement.addRental(new Rental(regularMovie3, 3));
        assertEquals(
                "Rental Record for Customer\n" +
                        "\tRegular 1\t2.0\n" +
                        "\tRegular 2\t2.0\n" +
                        "\tRegular 3\t3.5\n" +
                        "You owed 7.5\n" +
                        "You earned 3 frequent renter points\n",
                statement.generate()
        );
    }
}
