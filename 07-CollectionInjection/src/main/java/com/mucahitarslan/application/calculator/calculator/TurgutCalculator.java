package com.mucahitarslan.application.calculator.calculator;

import com.mucahitarslan.application.calculator.operation.SampleOperator;
import com.mucahitarslan.application.calculator.parameter.BeyzaParameterInfo;
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
