package com.mucahitarslan.test.number;

import com.mucahitarslan.test.string.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class GetRandomTextTestCase
{
    private final DataInfo dataInfo;
    private final Random random = new Random();
    public static class DataInfo{
        String sourceText;
        int count;

        public DataInfo(String sourceText, int count) {
            this.sourceText = sourceText;
            this.count = count;
        }

        public boolean isValid(String text)
        {
            int len = text.length();

            for (int i = 0; i < len; ++i)
                if (!sourceText.contains(text.charAt(i) + ""))
                    return false;

            return true;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> collectionTestData() throws IOException
    {
        return Files.newBufferedReader(Path.of("sourcetexts.txt"))
                .lines()
                .map(s -> s.split("[ \t]+"))
                .map(str -> new DataInfo(str[0], Integer.parseInt(str[1])))
                .collect(Collectors.toList());
    }

    public GetRandomTextTestCase(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    @Test
    public void test_getRandomText()
    {
        String str = StringUtil.getRandomText(random,dataInfo.count, dataInfo.sourceText);

        Assert.assertEquals(dataInfo.count,str.length());
        Assert.assertTrue(dataInfo.isValid(str));
    }
}
