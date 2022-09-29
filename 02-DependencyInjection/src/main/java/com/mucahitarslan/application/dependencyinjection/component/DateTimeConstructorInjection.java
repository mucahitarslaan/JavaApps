package com.mucahitarslan.application.dependencyinjection.component;

import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DateTimeConstructorInjection {

    private final DateTime m_dateTime;

    public DateTimeConstructorInjection(DateTime dateTime) {
        m_dateTime = dateTime;
    }

    @PostConstruct
    public void displayDateTime()
    {
        Console.writeLine("DateTimeConstructorInjection:%s",m_dateTime);
    }

}
