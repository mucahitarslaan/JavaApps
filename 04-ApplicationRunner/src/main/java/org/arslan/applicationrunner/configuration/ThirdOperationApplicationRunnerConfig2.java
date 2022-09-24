package org.arslan.applicationrunner.configuration;

import org.arslan.applicationrunner.component.ThirdOperation;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdOperationApplicationRunnerConfig2
{
    private final ThirdOperation thirdOperation;

    public ThirdOperationApplicationRunnerConfig2(ThirdOperation thirdOperation) {
        this.thirdOperation = thirdOperation;
    }

    @Bean("config2") // method isimleri olduğunda uyguluma ayağa kalkmaz, bu neden ya Bean'e isim veririz ya da method ismini değiştirmemiz gerekir
    public ApplicationRunner runThirdOperation()
    {
        return args -> thirdOperation.doOperation();
    }

}
