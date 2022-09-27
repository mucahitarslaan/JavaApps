package org.arslan.application.calculator.calculator;

import org.arslan.application.calculator.calculator.ICalculator;
import org.arslan.application.calculator.operation.SampleOperator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyCalculator implements ICalculator {
    private final SampleOperator sampleOperator;

    @Value("${mycalc.a:0}")
    private int m_a;

    @Value("${mycalc.b:1}")
    private int m_b;

    @Value("${mycalc.op:*}")
    private char m_op;


    public MyCalculator(SampleOperator sampleOperator) {
        this.sampleOperator = sampleOperator;
    }

    @Override
    public void calculate()
    {
        System.out.println("MyCalculator");
        sampleOperator.calculate(m_a,m_b,m_op);
    }

}
