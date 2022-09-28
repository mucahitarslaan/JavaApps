package com.arslan.library.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.arslan.library.parser.ComponentName.*;
@Component(PARSER)
@Scope("prototype")
public class Parser {
    private ISource m_source;

    @Autowired
    public Parser()
    {
    }

    public Parser(ISource source)
    {
        setSource(source);
    }

    public Parser setSource(ISource source)
    {
        //...
        m_source = source;

        return this;
    }

    public int countDigits() throws Exception
    {
        m_source.reset();
        int count = 0;
        int c;

        while ((c = m_source.nextChar()) != -1)
            if (Character.isDigit(c))
                ++count;

        return count;
    }

    public int countWhitespaces() throws Exception
    {
        m_source.reset();
        int count = 0;
        int c;

        while ((c = m_source.nextChar()) != -1)
            if (Character.isWhitespace(c))
                ++count;

        return count;
    }
    //...
}
