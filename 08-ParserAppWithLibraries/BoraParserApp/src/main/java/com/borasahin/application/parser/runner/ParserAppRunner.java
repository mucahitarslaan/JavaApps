package com.borasahin.application.parser.runner;

import com.borasahin.application.parser.component.ParserApp;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ParserAppRunner implements ApplicationRunner {

    private final ParserApp parserApp;

    public ParserAppRunner(ParserApp parserApp) {
        this.parserApp = parserApp;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        parserApp.run();
    }
}
