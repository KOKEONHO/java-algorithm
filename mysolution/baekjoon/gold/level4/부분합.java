package baekjoon.gold.level4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < N; end++) {
            sum += sequence[end];

            while (sum >= S) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= sequence[start++];
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);

    }
}
