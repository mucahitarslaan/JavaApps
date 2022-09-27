package org.arslan.application.calculator.operation;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SampleOperator {
    private final Collection<IIntBinaryOperator> operations;

    public SampleOperator(Collection<IIntBinaryOperator> operations) {
        this.operations = operations;
        System.out.printf("Size:%d%n", operations.size());
        System.out.printf(operations.getClass().getName());
    }

    public void throwException(char op)
    {
        throw new UnsupportedOperationException("Unsupported Exception : " + op);
    }
    public void calculate(int a, int b, char op)
    {
        operations.stream()
                .filter(iIntBinaryOperator -> iIntBinaryOperator.isValid(op))
                .findFirst()
                .ifPresentOrElse(iIntBinaryOperator -> System.out.printf("%d %c %d = %d\r\n", a,op,b, iIntBinaryOperator.applyAsInt(a,b)),
                        () -> throwException(op));
    }

    public void calculateForAll(int a, int b, char op)
    {
        operations.stream()
                .filter(iIntBinaryOperator -> iIntBinaryOperator.isValid(op))
                .forEach(iIntBinaryOperator -> System.out.printf("%d %c %d = %d\r\n", a, op ,b , iIntBinaryOperator.applyAsInt(a,b)));
    }
}
