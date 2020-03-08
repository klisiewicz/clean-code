package com.cleancoders.primes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class PrimePrinterTest {
    private PrintStream out;

    @Before
    public void setup() throws Exception {
        out = System.out;
        System.setOut(new PrintStream(new FileOutputStream("src/test/resources/lead")));
    }

    @Test
    public void makeSureOutputMatchesGold() throws Exception {
        PrimePrinter.main(new String[0]);
        BufferedReader lead = new BufferedReader(new FileReader("src/test/resources/lead"));
        BufferedReader gold = new BufferedReader(new FileReader("src/test/resources/gold"));
        String line;
        while ((line = gold.readLine()) != null)
            assertThat(line, is(lead.readLine()));
        assertThat(lead.readLine(), is(nullValue()));
    }

    @After
    public void tearDown() {
        System.setOut(out);
        new File("src/test/resources/lead").delete();
    }
}
