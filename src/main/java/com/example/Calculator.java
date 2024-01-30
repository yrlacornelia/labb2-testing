package com.example;

public class Calculator {
    private final String numbers;

    public Calculator(String numbers) {
        this.numbers = numbers;
    }

    public int addNumbers() {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = "[,\n]";
        int sum = 0;
        String[] numArray = numbers.split(delimiter);
        for (String num : numArray) {
            int parsedNum = Integer.parseInt(num);
            sum += parsedNum;
        }
        return sum;
    }
}
