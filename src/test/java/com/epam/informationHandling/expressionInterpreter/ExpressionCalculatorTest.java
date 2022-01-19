package com.epam.informationHandling.expressionInterpreter;

import com.epam.informationHandling.expressionInterpreter.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {

    @Test
    public void testCalculateShouldAddValuesFromExpression() {
        //given.
        String expression = "[ 2 2 + ]";
        ExpressionCalculator calculator = new ExpressionCalculator(expression);
        Integer expected = 4;
        //when
        Integer actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShouldMinusValuesFromExpression() {
        //given.
        String expression = "[ 2 8 - ]";
        ExpressionCalculator calculator = new ExpressionCalculator(expression);
        Integer expected = 6;
        //when
        Integer actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShouldDivideValuesFromExpression() {
        //given.
        String expression = "[ 2 8 / ]";
        ExpressionCalculator calculator = new ExpressionCalculator(expression);
        Integer expected = 4;
        //when
        Integer actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShouldMultiplyValuesFromExpression() {
        //given.
        String expression = "[ 2 8 * ]";
        ExpressionCalculator calculator = new ExpressionCalculator(expression);
        Integer expected = 16;
        //when
        Integer actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }
}
