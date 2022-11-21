package com.mucahitarslan.application.randomgenerator.schedule;

import org.csystem.util.Console;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

@Component
public class RandomPasswordGeneratorSecond {

    private final BufferedWriter bufferedWriter;
    private final Random random;

    public RandomPasswordGeneratorSecond(@Qualifier("bufferedWriter.second") BufferedWriter bufferedWriter, Random random) {
        this.bufferedWriter = bufferedWriter;
        this.random = random;
    }

    private void scheduledCallback()
    {
        try {
            bufferedWriter.write(StringUtil.getRandomTextEN(random,10) + "\r\n");
            bufferedWriter.flush();
        }catch (IOException ex)
        {
            Console.Error.writeLine(ex.getMessage());
        }
    }

    @Value("${count}")
    private int count;

    private int n;

    @Scheduled(fixedRate = 1000)
    public void run()
    {
        if (count == n)
            System.exit(1);
        ++n;

        scheduledCallback();
    }

}
