package org.arslan.application.randomgenerator.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

@Configuration
public class BufferedWriterConfig {
    private final FileOutputStream fileOutputStream1;
    private final FileOutputStream fileOutputStream2;

    public BufferedWriterConfig(@Qualifier("fileOutputStream.first") FileOutputStream fileOutputStream1,
                                @Qualifier("fileOutputStream.second") FileOutputStream fileOutputStream2)
    {
        this.fileOutputStream1 = fileOutputStream1;
        this.fileOutputStream2 = fileOutputStream2;
    }

    @Bean("bufferedWriter.first")
    @Scope("prototype")
    public BufferedWriter getFirst()
    {
        return new BufferedWriter(new OutputStreamWriter(fileOutputStream1, StandardCharsets.UTF_8));
    }

    @Bean("bufferedWriter.second")
    @Scope("prototype")
    public BufferedWriter getSecond()
    {
        return new BufferedWriter(new OutputStreamWriter(fileOutputStream2,StandardCharsets.UTF_8));
    }

}
