package org.arslan.application.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SecondOperation {
    @Value("${operation.second.operand1}")
    private int m_sop1;
    @Value("${operation.second.operand2}")
    private int m_sop2;
    @Value("${operation.second.prefix}")
    private String m_sprefix;

    @PostConstruct
    public void doOperation()
    {
        System.out.printf("%s: %d + %d = %d%n", m_sprefix, m_sop1, m_sop2, m_sop1 + m_sop2);
    }
}
