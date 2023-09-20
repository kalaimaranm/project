package com.advancedjava.functionalprogramming;

//import java.util.function.Function;
import java.util.function.Function;
import java.util.Scanner;
import java.util.function.BiFunction;

public class _Function {

    static Scanner scan = new Scanner(System.in);
    BiFunction<Integer, Integer, Integer> bi;

    public static void main(String[] args) {

        Integer i = incrementByOne(1);
        System.out.println("i = " + i);

        Integer i2 = incrementByOne.apply(2);
        System.out.println("incrementByOne   i2 = " + i2);

        Integer i2Multiple = multipleByTen.apply(i2);
        System.out.println("MultipleOf    i2 = " + i2Multiple);

        Integer i2Dup = incrementByOneAndMultipleByTen.apply(2);
        System.out.println("incrementByOneAndMultipleByTen = " + i2Dup);

//        System.out.println("Enter the Integer number : ");
//        int input = scan.nextInt();
//        System.out.println("Input = " + input + "\noutput = " + magic(input));

        System.out.println("manual method addByOneAndMultiple \n num = 10 num = 5\n output : "
                + incrementByOneAndMultiple(10, 5));
        System.out.println("BiFunction addByOneAndMultiple \n num = 10 num = 5\n output : "
                + incrementByOneAndMultiple.apply(10, 5));

    }

    static int incrementByOne(int i) {
        return i + 1;
    }

    static int incrementByOneAndMultiple(int num1, int num2) {
        return (num1 + 1) * num2;
    }
    // Function which take one argument and return one value
    static Function<Integer, Integer> incrementByOne = (num) -> num + 1;
    static Function<Integer, Integer> multipleByTen = (num) -> num * 10;
    static Function<Integer, Integer> incrementByOneAndMultipleByTen = incrementByOne.andThen(multipleByTen);

    // BiFunction which take two argument and return one value
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiple = (num1, num2) -> (num1 + 1) * num2;

    // addby 1, multiple by 10, divisible 10, subtractby 1
    // first add 1, multiple by 10, reverse to 1,reverto given number
    static int magic(int i) {

        Function<Integer, Integer> addByOneFunction = (num) -> num + 1;
        Function<Integer, Integer> multipleByTenFunction = (num) -> num * 10;
        Function<Integer, Integer> divisibleByTenFunction = (num) -> (int) num / 10;
        Function<Integer, Integer> subtractByOneFunction = (num) -> num - 1;

        Function<Integer, Integer> addByOneFunctionAndMultipleByTenFunction = addByOneFunction.andThen(multipleByTen);
        Function<Integer, Integer> divisibleByTenFunctionAndSubtractByOneFunction = divisibleByTenFunction.andThen(subtractByOneFunction);
        Function<Integer, Integer> overAllCombinedFunction = addByOneFunctionAndMultipleByTenFunction.andThen(divisibleByTenFunctionAndSubtractByOneFunction);

        return overAllCombinedFunction.apply(i);
    }
}
