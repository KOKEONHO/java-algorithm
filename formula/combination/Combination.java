package formula.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조합 Combination
 * 
 * 서로 다른 N개에서 순서 없이 R개를 뽑는 경우의 수
 * 
 * 순열과 달리 순서가 존재하지 않음
 * 
 * ex. [1, 2] == [2, 1]
 */

public class Combination {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] array = new int[M];
        boolean[] visited = new boolean[N];

        combination(0, 0, array, visited);

        System.out.println(sb);

    }

    private static void combination(int depth, int start, int[] array, boolean[] visited) {

        if (depth == M) {
            for (int num : array) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = i + 1;
                combination(depth + 1, i + 1, array, visited);
                visited[i] = false;
            }
        }

    }

}
