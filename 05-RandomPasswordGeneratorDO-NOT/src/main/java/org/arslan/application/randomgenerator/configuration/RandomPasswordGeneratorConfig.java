package org.arslan.application.randomgenerator.configuration;

import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Configuration
public class RandomPasswordGeneratorConfig {
    private final FileOutputStream fileOutputStream1;
    private final FileOutputStream fileOutputStream2;

    private void runForFirstCallback() throws IOException, InterruptedException {
        var dos = new DataOutputStream(fileOutputStream1);

        for(int i = 0 ; i < count ; ++i)
        {
            dos.writeUTF(StringUtil.getRandomTextEN(10));
            Thread.sleep(1000); // beklemeden kaynaklı initialize işlemi uzun sürer ve program ayağa kalkamaz. bunun gibi bekleme işlemleri yapılmamalıdır.
        }
    }

    private void runForSecondCallback() throws IOException, InterruptedException {
        var dos = new DataOutputStream(fileOutputStream2);

        for(int i = 0 ; i < count ; ++i)
        {
            dos.writeUTF(StringUtil.getRandomTextEN(10));
            Thread.sleep(1000);// beklemeden kaynaklı initialize işlemi uzun sürer ve program ayağa kalkamaz. bunun gibi bekleme işlemleri yapılmamalıdır.
        }
    }

    public RandomPasswordGeneratorConfig(@Qualifier("first") FileOutputStream fileOutputStream1,
                                         @Qualifier("second") FileOutputStream fileOutputStream2) {
        this.fileOutputStream1 = fileOutputStream1;
        this.fileOutputStream2 = fileOutputStream2;
    }


    @Value("${count}")
    private int count;

    @Bean
    public ApplicationRunner runForFirstFile()
    {
        return args -> runForFirstCallback();
    }

    @Bean
    public ApplicationRunner runForSecondFile()
    {
        return args -> runForSecondCallback();
    }
}
