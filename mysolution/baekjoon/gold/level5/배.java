package baekjoon.gold.level5;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class 배 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranes, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        boxes.sort(Collections.reverseOrder());

        if (boxes.getFirst() > cranes[0]) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        while (!boxes.isEmpty()) {
            int boxIdx = 0;

            for (int i = 0; i < N; ) {
                if (boxIdx == boxes.size()) {
                    break;
                }

                if (cranes[i] >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    i++;
                } else {
                    boxIdx++;
                }
            }

            time++;
        }

        System.out.println(time);
    }
}
