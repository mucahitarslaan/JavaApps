package org.arslan.applicationrunner.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThirdOperation {
    @Value("${operation.third.operand1:67}")
    private int m_top1;
    @Value("${operation.third.operand2:12}")
    private int m_top2;
    @Value("${operation.third.prefix:Third}")
    private String m_tprefix;

    public void doOperation()
    {
        System.out.printf("%s: %d + %d = %d%n", m_tprefix, m_top1, m_top2, m_top1 + m_top2);
    }
}
