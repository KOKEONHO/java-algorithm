package leetcode.medium;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {

        char[] result = new char[n];

        Arrays.fill(result, 'a');

        int sum = n;
        int index = n;

        while (sum < k) {
            index--;
            result[index] = 'z';
            sum += 25;
        }

        if (sum > k) {
            result[index] = (char) ((int) 'z' - (sum - k));
        }

        return new String(result);

    }
}
