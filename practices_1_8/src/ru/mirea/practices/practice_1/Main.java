package ru.mirea.practices.practice_1;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<String> comparator = (s1, s2) -> {
            int sum1 = calculateSumOfNumbers(s1);
            int sum2 = calculateSumOfNumbers(s2);
            return Integer.compare(sum1, sum2);
        };

        String str1 = "abc123def456";
        String str2 = "xyz789uvw";

        int result = comparator.compare(str1, str2);

        if (result < 0) {
            System.out.println(str1 + " < " + str2);
        } else if (result > 0) {
            System.out.println(str1 + " > " + str2);
        } else {
            System.out.println(str1 + " равно " + str2);
        }
    }

    private static int calculateSumOfNumbers(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }
}