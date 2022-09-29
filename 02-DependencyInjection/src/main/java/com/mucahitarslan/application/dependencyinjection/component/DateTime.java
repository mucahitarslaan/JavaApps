package com.mucahitarslan.application.dependencyinjection.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

@Component
public class DateTime {
    private final Temporal m_date;
    private final Temporal m_time;



    public DateTime(@Qualifier("todayTemporal") Temporal m_date,
                    @Qualifier("nowTemporal") Temporal m_time) {

        this.m_date= m_date;
        this.m_time=m_time;
    }

    public String toDateString()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(m_date);
    }

    public String toTimeString()
    {
        return DateTimeFormatter.ofPattern("hh:mm:ss").format(m_time);
    }

    @Override
    public String toString() {
        return toDateString() + " " + toTimeString();
    }
}
