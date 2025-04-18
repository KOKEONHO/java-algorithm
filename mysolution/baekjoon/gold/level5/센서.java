package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 센서 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 센서 개수
        int K = Integer.parseInt(br.readLine());    // 집중국 개수

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sensors = new int[N];

        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        if (N <= K) {
            System.out.println(0);
            return;
        }

        Arrays.sort(sensors);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N - 1; i++) {
            maxHeap.add(sensors[i + 1] - sensors[i]);
        }

        K -= 1;

        while (K-- > 0) {
            maxHeap.poll();
        }

        long total = 0;
        while (!maxHeap.isEmpty()) {
            total += maxHeap.poll();
        }

        System.out.println(total);

    }
}

