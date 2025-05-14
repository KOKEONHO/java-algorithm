package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n + 1];
        int[] prefix = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + sequence[i];
        }

        int minPrefix = 0;
        int result = prefix[1];
        for (int i = 1; i < n + 1; i++) {
            result = Math.max(result, prefix[i] - minPrefix);
            minPrefix = Math.min(minPrefix, prefix[i]);
        }

        System.out.println(result);

    }
}

