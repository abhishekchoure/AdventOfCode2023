package day1.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    private static Map<String, Integer> numbers = new HashMap<>();

    private static void initializeMap() {
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
    }

    public static void main(String[] args) {
        List<String> inputList = getInputAsList("./day1/part2/input.txt");
        Integer finalCaliberationValue = 0;
        initializeMap();

        for (String inputString : inputList) {
            Integer caliberationValue = getCaliberationValue(inputString);
            System.out.println(inputString + ":" + caliberationValue);
            finalCaliberationValue += caliberationValue;
        }
        System.out.println("Caliberation Value of Document is : " +
                finalCaliberationValue);
    }

    private static Integer getCaliberationValue(String input) {
        Integer size = input.length();
        String value = "";

        // if first and last char are digits
        if (Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(size - 1))) {
            String firstDigit = Character.toString(input.charAt(0));
            String lastDigit = Character.toString(input.charAt(size - 1));
            value = firstDigit.concat(lastDigit);
        } else {
            value = getValueFrom(input);
        }

        return Integer.parseInt(value);
    }

    private static List<String> getInputAsList(String inputFilePath) {
        List<String> inputList = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(inputFilePath);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                inputList.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return inputList;
    }

    private static String getValueFrom(String input) {
        String tempInput = input;
        Map<Integer, String> indexes = new TreeMap<>();
        for (String key : numbers.keySet()) {
            Integer index = input.indexOf(key);
            indexes.put(index, key);
        }

        for (Integer index : indexes.keySet()) {
            String digitInWords = indexes.get(index);
            String digitInNumber = Integer.toString(numbers.get(indexes.get(index)));
            String lastCharOfNumber = Character.toString(digitInWords.charAt(digitInWords.length() - 1));
            tempInput = tempInput.replace(digitInWords,digitInNumber.concat(lastCharOfNumber));
        }

        List<Character> values = new ArrayList<Character>();
        String firstDigit = "";
        String lastDigit = "";

        for (int i = 0; i < tempInput.length(); i++) {
            Character letter = tempInput.charAt(i);
            if (Character.isDigit(letter)) {
                values.add(letter);
            }
        }

        firstDigit = Character.toString(values.get(0));

        if (values.size() == 1) {
            lastDigit = Character.toString(values.get(0));
        } else {
            lastDigit = Character.toString(values.get(values.size() - 1));
        }

        return firstDigit.concat(lastDigit);
    }
}
