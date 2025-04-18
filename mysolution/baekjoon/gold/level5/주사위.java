package baekjoon.gold.level5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[6];
        int[] smallThree = new int[3];

        for (int i = 0; i < 6; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            Arrays.sort(numbers);
            System.out.println(numbers[0] + numbers[1] + numbers[2] + numbers[3] + numbers[4]);
            return;
        }

        for (int i = 0; i < 3; i++) {
            smallThree[i] = Math.min(numbers[i], numbers[5 - i]);
        }

        Arrays.sort(smallThree);

        long total = 0;

        if (N > 2) {
            total += oneSide(N, smallThree);
        }

        total += twoSide(N, smallThree);

        total += threeSide(N, smallThree);

        System.out.println(total);

    }

    private static long oneSide(
        int N,
        int[] smallThree
    ) {

        long total = 0;

        long smallest = smallThree[0];

        total += (long) (N - 1) * (N - 2) * 4 * smallest;
        total += (long) (N - 2) * (N - 2) * smallest;

        return total;

    }

    private static long twoSide(
        int N,
        int[] smallThree
    ) {

        long total = 0;

        long value = smallThree[0] + smallThree[1];

        total += (long) (N - 1) * 4 * value;
        total += (long) (N - 2) * 4 * value;

        return total;

    }

    private static long threeSide(
        int N,
        int[] smallThree
    ) {

        long value = smallThree[0] + smallThree[1] + smallThree[2];

        return (long) value * 4;

    }

}

