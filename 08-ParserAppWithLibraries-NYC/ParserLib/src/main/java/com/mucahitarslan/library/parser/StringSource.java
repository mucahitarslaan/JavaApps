package com.mucahitarslan.library.parser;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(ComponentName.STRING_SOURCE)
@Scope("prototype")
public class StringSource implements ISource {
    private final String m_str;
    private int m_index;

    public StringSource(@Qualifier(ComponentName.STRING_SOURCE_INJECT_BEAN_NAME) String str)
    {
        m_str = str;
    }

    public int nextChar()
    {
        return m_index == m_str.length() ? -1 : m_str.charAt(m_index++);
    }

    public void reset()
    {
        m_index = 0;
    }
}
