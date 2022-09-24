package org.arslan.applicationrunner.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component //// Post Construct nesne yaratılırken çağırılır.Application Runner kullanılan nesnelerin yaratılması bittikten sonra çağırılıyor.
public class FirstOperationRunner implements ApplicationRunner {
    @Value("${operation.first.operand1}")
    private int m_fop1;
    @Value("${operation.first.operand2}")
    private int m_fop2;
    @Value("${operation.first.prefix}")
    private String m_fprefix;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        System.out.printf("%s: %d + %d = %d%n",m_fprefix,m_fop1,m_fop2,m_fop1+m_fop2);
    }
}
