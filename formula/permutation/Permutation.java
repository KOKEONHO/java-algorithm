package formula.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 순열 Permutation
 * 
 * 서로 다른 N개에서 R개를 뽑아 정렬하는 경우의 수
 * 
 * 정렬 = 순서가 존재
 * 
 * ex. [1, 2] != [2, 1]
 */

public class Permutation {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] array = new int[M]; // 정렬을 위한 배열
        boolean[] visited = new boolean[N]; // 방문 배열

        permutation(0, array, visited);

        System.out.println(sb);
    }

    private static void permutation(int depth, int[] array, boolean[] visited) {

        if (depth == M) {
            for (int num : array) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = i + 1;
                permutation(depth + 1, array, visited);
                visited[i] = false;
            }
        }

    }

}
