package org.arslan.application.randomgenerator.runner;

import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;

@Component
public class RandomPasswordGeneratorSecond implements ApplicationRunner {
    private final BufferedWriter bufferedWriter;

    public RandomPasswordGeneratorSecond(@Qualifier("bufferedWriter.second") BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Value("${count}")
    private int count;

    @Value("${timeout}")
    private int timeout;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0 ; i < count; ++i)
        {
            bufferedWriter.write(StringUtil.getRandomTextEN(10) + "\r\n");
            bufferedWriter.flush();
            Thread.sleep(timeout);
        }
        bufferedWriter.flush();
    }
}
