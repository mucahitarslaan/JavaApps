package org.arslan.application.dependencyinjection.configuration;

import org.csystem.util.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

@Configuration
public class DateTimeConfig {

    @Bean //@Qualifer olarak Bean ismini belirttiğimiz durumlarda belirtilen isim, belirtilmediği durumlarda method ismi ile çağrılır.
    public Temporal getBirthDateTemporal()
    {
        Console.writeLine("DateTimeConfig.getBirthDateTemporal()");
        return LocalDate.of(1995,01,03);
    }

    @Bean("todayTemporal")
    @Scope("prototype")
    public Temporal todayTemporal()
    {
        Console.writeLine("DateTimeConfig.todayTemporal()");
        return LocalDate.now();
    }

    @Bean("nowTemporal")
    @Scope("prototype")
    public Temporal createNowTemporal()
    {
        Console.writeLine("DateTimeConfig.createNowTemporal()");
        return LocalDateTime.now();
    }

}
