package com.borasahin.application.parser.component;

import com.arslan.library.parser.ISource;
import com.arslan.library.parser.Parser;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ParserApp {

    private final Collection<ISource> sources;
    private Parser parser;

    private void consumerCallback(Parser p)
    {
        try {
            System.out.printf("\r\nNumber of Digits:%d", p.countDigits());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ParserApp(Collection<ISource> sources, Parser parser) {
        this.sources = sources;
        this.parser = parser;
    }

    public void run()
    {
        sources.stream()
                .map(parser::setSource)
                .forEach(this::consumerCallback);
    }
}
