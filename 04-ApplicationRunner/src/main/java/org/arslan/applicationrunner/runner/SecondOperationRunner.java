package org.arslan.applicationrunner.runner;

import org.arslan.applicationrunner.component.SecondOperation;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component // Post Construct nesne yaratılırken çağırılır.Application Runner kullanılan nesnelerin yaratılması bittikten sonra çağırılıyor.
public class SecondOperationRunner implements ApplicationRunner {
    private final SecondOperation secondOperation;

    public SecondOperationRunner(SecondOperation secondOperation) {
        this.secondOperation = secondOperation;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        secondOperation.doOperation();
    }
}
