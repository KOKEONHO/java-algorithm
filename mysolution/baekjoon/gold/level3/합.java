package baekjoon.gold.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] total = new long[26];
        boolean[] isHead = new boolean[26];
        List<Integer> usedAlphabets = new ArrayList<>();

        while (N-- > 0) {
            String input = br.readLine();
            int length = input.length();

            for (int i = 0; i < length; i++) {
                char alphabet = input.charAt(i);
                int position = (length - 1) - i;

                if (i == 0) {
                    isHead[alphabet - 'A'] = true;
                }

                total[alphabet - 'A'] += (long) Math.pow(10, position);
            }
        }

        for (int i = 0; i < 26; i++) {
            if (total[i] > 0) {
                usedAlphabets.add(i);
            }
        }

        usedAlphabets.sort((a, b) -> Long.compare(total[b], total[a]));

        int[] numberAssigned = new int[26];
        Arrays.fill(numberAssigned, -1);

        if (usedAlphabets.size() == 10) {
            for (int i = usedAlphabets.size() - 1; i >= 0; i--) {
                int idx = usedAlphabets.get(i);
                if (!isHead[idx]) {
                    numberAssigned[idx] = 0;
                    usedAlphabets.remove(i);
                    break;
                }
            }
        }

        int num = 9;
        for (int idx : usedAlphabets) {
            if (numberAssigned[idx] == -1) {
                numberAssigned[idx] = num--;
            }
        }

        long sum = 0;
        for (int i = 0; i < 26; i++) {
            if (total[i] > 0 && numberAssigned[i] != -1) {
                sum += total[i] * numberAssigned[i];
            }
        }

        System.out.println(sum);

    }
}
