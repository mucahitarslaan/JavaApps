package com.borasahin.application.parser.configuration;

import org.csystem.library.parser.ComponentName;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class SourceInjectBeanConfig {

    private final Random random;

    public SourceInjectBeanConfig(Random random) {
        this.random = random;
    }

    @Bean(ComponentName.STRING_SOURCE_INJECT_BEAN_NAME)
    @Scope("prototype")
    public String createStringSourceBean()
    {
        return StringUtil.getRandomText(random, random.nextInt(10) + 20 , "abcdxyz1234567890");
    }

    @Bean(ComponentName.CHAR_ARRAY_SOURCE_INJECT_BEAN_NAME)
    @Scope("prototype")
    public String createCharArraySourceBean()
    {
        return StringUtil.getRandomText(random,  20 ,"abcdxyz1234567890");
    }

    @Bean(ComponentName.FILE_SOURCE_INJECT_BEAN_NAME)
    @Scope("prototype")
    public String getFileSourceBean(@Value("${parser.source.path}") String path)
    {
        return path;
    }
}
