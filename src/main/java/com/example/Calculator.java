package com.example;

public class Calculator {
    private String numbers;

    public Calculator(String numbers) {
        this.numbers = numbers;
    }

    public int addNumbers() {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            numbers = numbers.substring(2);

            String delimiterPattern = "[,.:;*?\\n\\[\\]&%]+";
            String[] splitResult = numbers.split(delimiterPattern);

            numbers = String.join(",", splitResult);

            while (numbers.startsWith(",")) {
                numbers = numbers.substring(1);
            }
        }
        int sum = 0;
        String[] numArray = numbers.split(delimiter);
        for (String num : numArray) {
            int parsedNum = Integer.parseInt(num);
            sum += parsedNum;
        }
        return sum;
    }
}
