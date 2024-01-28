package com.zac.johnson.katas;

import java.util.ArrayList;
import java.util.List;

public class ConvertStringToArray {
    public static void main(String[] args) {
        // Test 1 Pass
        String input = "1, 3-5, 7, 9";
        List<Integer> output = getNumberArrayFromString(input);
        System.out.println(output);

        // Test 2 Pass (numbers greater than one decimal place)
        input = "1, 3-5, 7, 9, 100, 101";
        output = getNumberArrayFromString(input);
        System.out.println(output);

        // Test 3 Pass (No space after comma) Fixed by changing initial split to just
        // ',' and adding trims to get ride of space char.
        input = "1, 3-5, 7, 9, 100,101";
        output = getNumberArrayFromString(input);
        System.out.println(output);

        // Test 4 Pass (negative numbers) Fixed by checking if the element contained a
        // dash and its not the first char in an element. Also had to trim to account
        // for spaces before the -
        input = "-1,3-5, 7, 9, 100, -101";
        output = getNumberArrayFromString(input);
        System.out.println(output);

        // Test 5 Pass (negative to positive range) Fixed by adding special if clauses
        // for when dash count > 1
        input = "-10, -1-1 ,3-5, 7, 9, 100, -101";
        output = getNumberArrayFromString(input);
        System.out.println(output);

        // Test 6 Pass (negative to negative range) Fixed by adding if clause when dash
        // count == 3
        input = "-10,-9--7, -1-1 ,3-5, 7, 9, 100, -101";
        output = getNumberArrayFromString(input);
        System.out.println(output);

        // Test 7 Pass (negative to negative range with spaces and double digits)
        input = "-90- -70, -10,-9--7, -1-1 ,3-5, 7, 9, 100, -101";
        output = getNumberArrayFromString(input);
        System.out.println(output);
        
        // Test 8 Pass (positive to negative range with spaces and double digits)
        input = "-90- -70, -10,-9--7, -1-1 ,3-5, 7, 9, 100, -101, 1--1";
        output = getNumberArrayFromString(input);
        System.out.println(output);

        // Test 9 Pass (positive large number to positive smaller number range)
        input = "-90- -70, -10,-9--7, -1-1 ,3-5, 7, 9, 100, -101, 1--1, 10-8";
        output = getNumberArrayFromString(input);
        System.out.println(output);

    }

    private static List<Integer> getNumberArrayFromString(String input) {
        List<Integer> output = new ArrayList<>();
        String[] elements = input.split(",");

        for (String element : elements) {
            long dashCount = element.chars().filter(c -> c == '-').count();
            String[] range;

            switch ((int) dashCount) {
                case 0:
                    output.add(Integer.parseInt(element.trim()));
                    break;
                case 1:
                    if (element.trim().charAt(0) != '-') {
                        range = element.trim().split("-");
                        addRangeToArray(output, range[0], range[1]);
                        
                    } else {
                        output.add(Integer.parseInt(element.trim()));
                    }
                    break;
                case 2:
                    if (element.trim().charAt(0) == '-') {
                        range = element.trim().split("-");
                        addRangeToArray(output, '-' + range[1], range[2]);
                    } else {
                        range = element.trim().split("-");
                        addRangeToArray(output, range[0], '-' + range[2]);
                    }
                    break;
                case 3:
                    range = element.trim().split("-");
                    addRangeToArray(output, '-' + range[1], '-' + range[3]);
                    break;
                default:
                    System.out.println("To many Dashes");
                    break;
            }
        }

        return output;
    }

    private static void addRangeToArray(List<Integer> inputArray,  String startRange, String endRange) {
        if (Integer.parseInt(startRange) > Integer.parseInt(endRange)) {
            for (int i = Integer.parseInt(startRange); i >= Integer.parseInt(endRange); i--) {
                inputArray.add(i);
            }
        } else {
            for (int i = Integer.parseInt(startRange); i <= Integer.parseInt(endRange); i++) {
                inputArray.add(i);
            }
        }
    }
}
