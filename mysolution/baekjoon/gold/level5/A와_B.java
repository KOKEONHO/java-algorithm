package baekjoon.gold.level5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A와_B {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        System.out.println(backTrack(T, S));
    }

    private static int backTrack(
        StringBuilder T,
        StringBuilder S
    ) {

        if (T.length() == S.length()) {
            return T.compareTo(S) == 0 ? 1 : 0;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            T.deleteCharAt(T.length() - 1);
            return backTrack(T, S);
        }

        if (T.charAt(T.length() - 1) == 'B') {
            T.deleteCharAt(T.length() - 1);
            T.reverse();
            return backTrack(T, S);
        }

        return 0;

    }
}
