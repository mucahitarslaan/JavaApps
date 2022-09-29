package com.mucahitarslan.application.dependencyinjection.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DateTimeFieldInjection {

    @Autowired // Önerilmez
    private  DateTime m_dateTime;

    @PostConstruct
    public void displayDateTime()
    {
        Console.writeLine("DateTimeFieldInjection:%s",m_dateTime);
    }

}
