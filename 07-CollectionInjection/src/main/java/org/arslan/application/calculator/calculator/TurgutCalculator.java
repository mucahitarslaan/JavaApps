package org.arslan.application.calculator.calculator;

import org.arslan.application.calculator.calculator.ICalculator;
import org.arslan.application.calculator.operation.SampleOperator;
import org.arslan.application.calculator.parameter.BeyzaParameterInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TurgutCalculator implements ICalculator {
    private final SampleOperator sampleOperator;
    private final BeyzaParameterInfo beyzaParameterInfo;

    public TurgutCalculator(SampleOperator sampleOperator, BeyzaParameterInfo beyzaParameterInfo) {
        this.sampleOperator = sampleOperator;
        this.beyzaParameterInfo = beyzaParameterInfo;
    }

    @Override
    public void calculate()
    {
        System.out.println("TurgutCalculator");
        sampleOperator.calculateForAll(beyzaParameterInfo.a, beyzaParameterInfo.b,beyzaParameterInfo.op);
    }
}
