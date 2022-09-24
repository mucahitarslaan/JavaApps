package org.arslan.applicationrunner.configuration;

import org.arslan.applicationrunner.component.ThirdOperation;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdOperationApplicationRunnerConfig1
{
    private final ThirdOperation thirdOperation;

    public ThirdOperationApplicationRunnerConfig1(ThirdOperation thirdOperation) {
        this.thirdOperation = thirdOperation;
    }

    @Bean
    public ApplicationRunner runThirdOperation()
    {
        return args -> thirdOperation.doOperation();
    }

}
