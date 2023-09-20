package com.kalai.junittest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {



    @ParameterizedTest
    @ValueSource(ints = {10, 12, 23, 12, 83})
    public void testAdd() {


    }
}
