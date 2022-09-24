package org.arslan.application.dependencyinjection.component;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

@Component
public class BirthDateInfoDisplay {
    private final Temporal m_localDate;
    private final Temporal m_now;
    private final Temporal m_today;

    public BirthDateInfoDisplay(@Qualifier("getBirthDateTemporal") Temporal localDate,
                                @Qualifier("todayTemporal") Temporal today,
                                @Qualifier("nowTemporal") Temporal now) {
        m_localDate = localDate;
        m_now = now;
        m_today = today;
    }

    @PostConstruct
    public void displayBirthDate()
    {
        Console.writeLine(DateTimeFormatter.ofPattern("dd.MM.yyyy").format(m_localDate));
    }

    @PostConstruct
    public void displayToday()
    {
        Console.writeLine(DateTimeFormatter.ofPattern("dd.MM.yyyy").format(m_today));
    }

    @PostConstruct
    public void displayTime()
    {
        Console.writeLine(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(m_now));
    }
}
