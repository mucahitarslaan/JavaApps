package com.mucahitarslan.test.number.runner;

import com.mucahitarslan.test.number.testcase.NumberUtilTestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class IsPrimeTestRunner {
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(NumberUtilTestCase.class);

        for (Failure f : result.getFailures())
            System.err.println(f);

        System.err.printf("Number Of Failures:%d%n",result.getFailureCount());
        System.err.println(result.wasSuccessful() ? "Success" : "Fail");
    }
}
