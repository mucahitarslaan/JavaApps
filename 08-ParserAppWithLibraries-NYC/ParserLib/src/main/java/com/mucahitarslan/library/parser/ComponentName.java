package com.mucahitarslan.library.parser;

import org.springframework.stereotype.Component;

public final class ComponentName {
    private ComponentName()
    {

    }

    public static final String PARSER = "com.arslan.library.parser";
    public static final String CHAR_ARRAY_SOURCE= "com.arslan.library.parser.source.chararray";
    public static final String STRING_SOURCE= "com.arslan.library.parser.source.string";
    public static final String FILE_SOURCE= "com.arslan.library.parser.source.file";
    public static final String STRING_SOURCE_INJECT_BEAN_NAME = "com.arslan.library.parser.source.string.string";
    public static final String CHAR_ARRAY_SOURCE_INJECT_BEAN_NAME = "com.arslan.library.parser.source.chararray.string";
    public static final String FILE_SOURCE_INJECT_BEAN_NAME = "com.arslan.library.parser.source.file.name";
    public static final String PARSER_INJECT_BEAN_NAME = "com.arslan.library.parser.parser.source";

}
