package org.arslan.application.calculator.runner;

import org.arslan.application.calculator.calculator.ICalculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCalculatorRunner implements ApplicationRunner {
    private final ICalculator calculator;

    public MyCalculatorRunner(@Qualifier("myCalculator") ICalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        calculator.calculate();
    }
}
