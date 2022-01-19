package com.epam.informationHandling.expressionInterpreter;

public class NonTerminalExpressionNumber extends AbstractMathExpression {
    private int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
