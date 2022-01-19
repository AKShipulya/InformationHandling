package com.epam.informationHandling.expressionInterpreter.mathTerminalExpression;

import com.epam.informationHandling.expressionInterpreter.AbstractMathExpression;
import com.epam.informationHandling.expressionInterpreter.Context;

public class TerminalExpressionDivide extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue((context.popValue() / context.popValue()));
    }
}
