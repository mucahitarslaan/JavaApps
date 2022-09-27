package org.arslan.application.calculator.runner;

import org.arslan.application.calculator.calculator.ICalculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TurgutCalculatorRunner implements ApplicationRunner {
    private final ICalculator calculator;

    public TurgutCalculatorRunner(@Qualifier("turgutCalculator") ICalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        calculator.calculate();
    }
}
