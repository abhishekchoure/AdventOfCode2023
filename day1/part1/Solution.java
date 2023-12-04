package day1.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] argv) {
        Integer finalCaliberationValue = 0;
        List<String> inputList = getInputAsList("./day1/part1/input.txt");
        for (String inputString : inputList) {
            Integer caliberationValue = getCaliberationValue(inputString);
            finalCaliberationValue += caliberationValue;
        }
        System.out.println("Caliberation Value of Document is : " + finalCaliberationValue);
    }

    private static Integer getCaliberationValue(String input) {
        List<Character> values = new ArrayList<Character>();
        Integer size = input.length();
        for (int i = 0; i < size; i++) {
            Character letter = input.charAt(i);
            if (Character.isDigit(letter)) {
                values.add(letter);
            }
        }
        String firstDigit = Character.toString(values.get(0));
        String lastDigit = "";
        if (values.size() == 1) {
            lastDigit = Character.toString(values.get(0));
        } else {
            lastDigit = Character.toString(values.get(values.size() - 1));
        }
        String value = firstDigit.concat(lastDigit);
        System.out.println(value);
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
}