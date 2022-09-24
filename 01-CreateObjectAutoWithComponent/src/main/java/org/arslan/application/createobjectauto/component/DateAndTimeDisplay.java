package org.arslan.application.createobjectauto.component;

import org.csystem.util.Console;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateAndTimeDisplay {
    public DateAndTimeDisplay()
    {
        Console.writeLine("DateAndTimeDisplay.DateAndTimeDisplay()");
    }

    @PostConstruct
    public void displayTime()
    {
        var now = LocalTime.now();
        var nowText = DateTimeFormatter.ofPattern("hh:mm:ss").format(now);

        Console.writeLine("DateAndTimeDisplay.displayTime():%s",nowText);
    }

    @PostConstruct
    public void displayDate()
    {
        var today = LocalDate.now();
        var todayText = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(today);

        Console.writeLine("DateAndTimeDisplay.displayDate():%s",todayText);
    }
}
