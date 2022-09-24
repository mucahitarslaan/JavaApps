package org.arslan.application.randomgenerator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Configuration
public class FileOutputStreamConfig {

    @Value("${filename1}")
    private String filename1;

    @Value("${filename2}")
    private String filename2;

    @Bean("first")
    public FileOutputStream getFirst() throws IOException {
        return new FileOutputStream(filename1,true);
    }

    @Bean("second")
    public FileOutputStream getSecond() throws IOException{
        return new FileOutputStream(filename2,true);
    }

}
