package com.mucahitarslan.test.string.util;

import java.util.Random;

public class StringUtil
{
    public static String getRandomText(Random r, int n, String str)
    {
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; ++i)
            sb.append(str.charAt(r.nextInt(str.length())));

        return sb.toString();
    }
}
