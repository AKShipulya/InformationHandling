package com.epam.informationhandling.interpreter.terminal;

import com.epam.informationhandling.interpreter.AbstractMathExpression;
import com.epam.informationhandling.interpreter.Context;

public class TerminalExpressionMultiply extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() * context.popValue());
    }
}
