package formula.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RepeatedCombination {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] array = new int[M];

        combination(0, 0, array);

        System.out.println(sb);

    }

    private static void combination(int depth, int start, int[] array) {

        if (depth == M) {
            for (int num : array) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            array[depth] = i + 1;
            combination(depth + 1, i, array);
        }

    }

}
