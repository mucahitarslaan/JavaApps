package com.mucahitarslan.test.number.testcase;

import com.mucahitarslan.test.number.util.NumberUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class NumberUtilTestCase
{
    private final DataInfo dataInfo;
    public static class DataInfo{
        long val;
        boolean result;

        public DataInfo(long val, boolean result) {
            this.val = val;
            this.result = result;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> collectionTestData() throws IOException
    {
        return Files.newBufferedReader(Path.of("numbers.txt"))
                .lines()
                .map(str -> new DataInfo(Long.parseLong(str),true))
                .collect(Collectors.toList());
    }

    public NumberUtilTestCase(DataInfo dataInfo)
    {
        this.dataInfo = dataInfo;
    }

    @Test
    public void test_isPrime()
    {
        long value = dataInfo.val;

        Assert.assertTrue(String.format("%d must be prime !!",value), NumberUtil.isPrime(value));
    }
}
