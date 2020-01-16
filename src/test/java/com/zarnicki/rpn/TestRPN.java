package com.zarnicki.rpn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kacper on 2016-06-05.
 */
public class TestRPN {

    private RPN rpn;

    @Before
    public void setUp() {
        rpn = new RPN();
    }

    @Test
    public void addTestPositive() {
        assertEquals("4", rpn.calculateRPN(" 2 2 +"));
    }

    @Test
    public void minusTestPositive() {
        assertEquals("5", rpn.calculateRPN(" 10 15 - "));
    }

    @Test
    public void multiplyTestPositive() {
        assertEquals("20",rpn.calculateRPN(" 4 5 * "));
    }

    @Test
    public void divideTestPositive(){
        assertEquals("10", rpn.calculateRPN(" 20 2 /"));
    }

    @Test
    public void divideTest0() {
        assertEquals("Divide by 0",rpn.calculateRPN( " 10 0 / " ));
    }

    @Test
    public void badArgsTest() {assertEquals("Bad Args",rpn.calculateRPN( " 10 20 + a " ));}

    @Test
    public void toManyArgsTest() {assertEquals("Too many args",rpn.calculateRPN( " 10 20 + 12" ));}

    @Test
    public void notEnoughArgsTest() {assertEquals("Bad Args",rpn.calculateRPN( " 10 + 20 30 +" ));}
}