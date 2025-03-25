package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실_배정 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int start, end;
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            minHeap.add(new int[] {start, end});
        }

        int previousMeetingEndTime = 0;

        while (!minHeap.isEmpty()) {
            int[] meeting = minHeap.poll();
            if (previousMeetingEndTime <= meeting[0]) {
                cnt++;
                previousMeetingEndTime = meeting[1];
            }
        }

        System.out.println(cnt);

    }
}
