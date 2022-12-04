package com.mucahitarslan.test.number.util;

public class NumberUtil
{
    public static boolean isPrime(long val)
    {
        if (val <= 1L)
            return false;

        if (val % 2L == 0)
            return val == 2L;

        if (val % 3L == 0)
            return val == 3L;

        if (val % 5L ==0)
            return val == 5L;

        if (val % 7L == 0)
            return val == 7L;

        long sqrtVal = (long)Math.sqrt(val);

        for (long i = 11L; i <= sqrtVal; i += 2L)
            if (val % i == 0)
                return false;

        return true;

    }
}
