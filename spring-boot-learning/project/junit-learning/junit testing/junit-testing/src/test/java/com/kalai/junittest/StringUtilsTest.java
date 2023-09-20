package com.kalai.junittest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringUtilsTest {

    @Test
    public void testStringToInt() {

        String str = null;
        assertThrows(IllegalArgumentException.class, ()-> StringUtils.StringToInt(str));
    }
}
