package com.mucahitarslan.application.dependencyinjection.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Component
public class AgeInfoDisplay {
    private final Temporal m_temporal;
    private final Temporal m_today;

    private final Temporal m_now;

    public AgeInfoDisplay(@Qualifier("getBirthDateTemporal") Temporal temporal,
                          @Qualifier("todayTemporal") Temporal today,
                          @Qualifier("nowTemporal") Temporal now) {
        m_temporal = temporal;
        m_today = today;
        m_now= now;
    }

    @PostConstruct
    public void displayBirthDate() throws InterruptedException
    {

        Console.writeLine(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(m_now));

        var age = ChronoUnit.DAYS.between(m_temporal, m_today) / 365.;

        Console.writeLine("Age:%f", age);

        Thread.sleep(2000);

    }
}
