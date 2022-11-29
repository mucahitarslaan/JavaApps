/*
package com.mucahitarslan.application.rest.todo.runner;

import com.mucahitarslan.application.rest.todo.data.repository.ITodoRepository;
import org.csystem.util.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceContext;
import java.util.stream.Stream;

@Component
public class ApplicationInfoReportRunner implements ApplicationRunner {
    private final ApplicationContext applicationContext;

    public ApplicationInfoReportRunner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Console.writeLine("---------------");
        Console.writeLine("-----Todos-----");
        ITodoRepository todoResository = applicationContext.getBean(ITodoRepository.class);

        todoResository.findAll().forEach(t -> Console.writeLine(t.getTitle()));

        Console.writeLine("-----Application Info-----");
        Console.writeLine("Application Name :%s", applicationContext.getApplicationName());
        Console.writeLine("Application ID :%s", applicationContext.getId());

        Console.writeLine("-----Bean/Component Info-----");
        Console.writeLine("Bean definition count :%d", applicationContext.getBeanDefinitionCount());

        Console.writeLine("-----Beans-----");
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(Console::writeLine);
        Console.writeLine("----------------");

    }
}*/
