package com.mucahitarslan.application.calculator.operation;

import java.util.function.IntBinaryOperator;

public interface IIntBinaryOperator extends IntBinaryOperator {
    boolean isValid(char op);
}
