package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전구와_스위치 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder original = new StringBuilder(br.readLine());
        String target = br.readLine();

        StringBuilder firstSwitch = new StringBuilder();

        for (int i = 0; i < original.length(); i++) {
            if (i < 2) {
                if (original.charAt(i) == '0') {
                    firstSwitch.append('1');
                    continue;
                }
                firstSwitch.append('0');
                continue;
            }
            firstSwitch.append(original.charAt(i));
        }

        int originalCnt = 0;

        for (int i = 1; i < original.length(); i++) {
            if (original.charAt(i - 1) != target.charAt(i - 1)) {
                changeBulbsStatus(original, i);
                originalCnt++;
            }
        }

        if (original.toString().equals(target)) {
            System.out.println(originalCnt);
            return;
        }

        int firstSwitchCnt = 1;

        for (int i = 1; i < firstSwitch.length(); i++) {
            if (firstSwitch.charAt(i - 1) != target.charAt(i - 1)) {
                changeBulbsStatus(firstSwitch, i);
                firstSwitchCnt++;
            }
        }

        if (firstSwitch.toString().equals(target)) {
            System.out.println(firstSwitchCnt);
            return;
        }

        System.out.println(-1);

    }

    private static void changeBulbsStatus(
        StringBuilder sb,
        int index
    ) {

        if (sb.charAt(index - 1) == '0') {
            sb.setCharAt(index - 1, '1');
        } else {
            sb.setCharAt(index - 1, '0');
        }

        if (sb.charAt(index) == '0') {
            sb.setCharAt(index, '1');
        } else {
            sb.setCharAt(index, '0');
        }

        if (index == sb.length() - 1) {
            return;
        }

        if (sb.charAt(index + 1) == '0') {
            sb.setCharAt(index + 1, '1');
        } else {
            sb.setCharAt(index + 1, '0');
        }

    }

}
