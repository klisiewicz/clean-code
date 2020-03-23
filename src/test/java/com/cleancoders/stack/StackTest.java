package com.cleancoders.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {
    private Stack<String> stack;

    @Before
    public void setUp() {
        stack = Stack.make(2);
    }

    @Test
    public void newlyCreatedStackShouldBeEmpty() {
        assertThat(stack.isEmpty(), is(true));
        assertThat(stack.getSize(), is(0));
    }

    @Test
    public void afterOnePushStackSizeShouldBeOne() {
        stack.push("1");
        assertThat(stack.isEmpty(), is(false));
        assertThat(stack.getSize(), is(1));
    }

    @Test
    public void afterOnePushAndOnePopStackShouldBeEmpty() {
        stack.push("1");
        stack.pop();
        assertThat(stack.isEmpty(), is(true));
    }

    @Test(expected = Stack.OverflowException.class)
    public void whenPushedPassedLimitStackShouldOverflow() {
        stack.push("1");
        stack.push("2");
        stack.push("3");
    }

    @Test(expected = Stack.UnderflowException.class)
    public void whenEmptyIsPoppedStackShouldUnderflow() {
        stack.pop();
    }

    @Test
    public void whenOneIsPushedOneIsPopped() {
        stack.push("1");
        assertThat(stack.pop(), is("1"));
    }

    @Test
    public void whenOneAndTwoArePushedTwoAndOneArePopped() {
        stack.push("1");
        stack.push("2");
        assertThat(stack.pop(), is("2"));
        assertThat(stack.pop(), is("1"));
    }
}
