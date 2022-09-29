package com.mucahitarslan.application.randomgenerator.runner;

import org.csystem.util.scheduler.Scheduler;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.util.Random;

@Component
public class RandomPasswordGeneratorFirst implements ApplicationRunner {

    private BufferedWriter bufferedWriter;
    private Random random;
    private Scheduler scheduler;


    @Value("${count}")
    private int count;

    @Value("${timeout}")
    private long timeout;

    @Value("${initial}")
    private int initial;

    public void schedulerCallback()
    {
        try {
            if (count == initial)
                scheduler.cancel();
            ++initial;
            bufferedWriter.write(StringUtil.getRandomTextEN(random,10) + "\r\n");
            bufferedWriter.flush();

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public RandomPasswordGeneratorFirst(@Qualifier("bufferedWriter.first") BufferedWriter bufferedWriter, Random random, Scheduler scheduler) {
        this.bufferedWriter = bufferedWriter;
        this.random = random;
        this.scheduler = scheduler;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        scheduler.schedule(this::schedulerCallback);
    }
}
