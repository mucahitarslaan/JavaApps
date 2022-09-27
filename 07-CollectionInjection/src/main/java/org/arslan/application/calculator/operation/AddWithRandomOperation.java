package org.arslan.application.calculator.operation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AddWithRandomOperation implements IIntBinaryOperator {
    private final Random random;

    public AddWithRandomOperation(@Qualifier("randomCreate") Random random) {
        this.random = random;
    }

    @Override
    public boolean isValid(char op) {
        return op == '+';
    }

    @Override
    public int applyAsInt(int left, int right) {
        var val = random.nextInt(99);
        System.out.println("value: " + val);
        return left + right + val;
    }
}
