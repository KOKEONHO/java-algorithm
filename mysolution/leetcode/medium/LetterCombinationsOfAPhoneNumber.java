package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    static List<String> result;
    static Map<Integer, char[]> map;

    public List<String> letterCombinations(String digits) {

        initializeMap();

        result = new ArrayList<>();

        combination(0, digits, new StringBuilder());

        return result;

    }

    private void combination(int depth, String digits, StringBuilder sb) {

        if (depth == digits.length()) {
            if (sb.isEmpty()) {
                return;
            }
            result.add(sb.toString());
            return;
        }

        char[] alphabets = map.get(Character.getNumericValue(digits.charAt(depth)));

        for (int i = 0; i < alphabets.length; i++) {
            sb.append(alphabets[i]);
            combination(depth + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private void initializeMap() {

        char alphabet = 'a';
        map = new HashMap<>();

        for (int i = 2; i < 10; i++) {
            char[] alphabets = new char[3];
            if (i == 7 || i == 9) {
                alphabets = new char[4];
            }
            for (int j = 0; j < 3; j++) {
                alphabets[j] = alphabet;
                alphabet++;
            }
            if (i == 7 || i == 9) {
                alphabets[3] = alphabet;
                alphabet++;
            }
            map.put(i, alphabets);
        }

    }
}
