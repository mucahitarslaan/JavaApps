package org.arslan.application.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class FirstOperation {
    @Value("${operation.first.operand1}")
    private int m_fop1;
    @Value("${operation.first.operand2}")
    private int m_fop2;
    @Value("${operation.first.prefix}")
    private String m_fprefix;

    @PostConstruct
    public void doOperation()
    {
        System.out.printf("%s: %d + %d = %d%n",m_fprefix,m_fop1,m_fop2,m_fop1+m_fop2);
    }
}
