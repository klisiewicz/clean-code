package com.cleancoders.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {
    @Test
    public void newlyCreatedStackShouldBeEmpty() {
        Stack stack = new Stack();
        assertThat(stack.isEmpty(), is(true));
        assertThat(stack.getSize(), is(0));
    }
}
