package com.mucahitarslan.library.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(ComponentName.CHAR_ARRAY_SOURCE)
@Scope("prototype")
public class CharArraySource implements ISource {
    private final char [] m_chars;
    private int m_index;

    @Autowired // birden fazla constructor oldugu icin autowired kullanilmalidir.
    public CharArraySource(@Qualifier(ComponentName.CHAR_ARRAY_SOURCE_INJECT_BEAN_NAME) String str)
    {
        this(str.toCharArray());
    }

    public CharArraySource(char [] chars)
    {
        m_chars = chars;
    }

    public int nextChar()
    {
        return m_index == m_chars.length ? -1 : m_chars[m_index++];
    }

    public void reset()
    {
        m_index = 0;
    }
}
