package com.beyzayazici.lib.parser.component;


import org.csystem.library.parser.ISource;
import org.csystem.library.parser.Parser;
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
