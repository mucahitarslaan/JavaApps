package com.mucahitarslan.application.rest.todo.runner;

import org.csystem.util.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInfoReportRunner implements ApplicationRunner {
    private final ApplicationContext applicationContext;

    public ApplicationInfoReportRunner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
     Console.writeLine("Bean definition count:%d",applicationContext.getBeanDefinitionCount());
    }
}
