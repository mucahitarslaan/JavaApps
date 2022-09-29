package com.mucahitarslan.application.createobjectauto.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateAndTimeDisplay {
    public DateAndTimeDisplay()
    {
        System.out.println("DateAndTimeDisplay.DateAndTimeDisplay()");
    }

    @PostConstruct
    public void displayTime()
    {
        var now = LocalTime.now();
        var nowText = DateTimeFormatter.ofPattern("hh:mm:ss").format(now);

        System.out.printf("DateAndTimeDisplay.displayTime():%s",nowText);
    }

    @PostConstruct
    public void displayDate()
    {
        var today = LocalDate.now();
        var todayText = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(today);

        System.out.printf("DateAndTimeDisplay.displayDate():%s",todayText);
    }
}
