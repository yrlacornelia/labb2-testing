package com.example;

import java.util.ArrayList;
import java.util.List;

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

        String[] numArray = numbers.split(delimiter);

        int sum = 0;
        List<String> negatives = new ArrayList<>();
        for (String num : numArray) {
            if(num.length() >= 4) {
                num = "0";
            }
            try {
                int parsedNum = Integer.parseInt(num);
                if (parsedNum >= 0) {
                    sum += parsedNum;
                } else {
                    negatives.add(num);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Negatives not allowed: " + num);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }
        return sum;
    }
}
