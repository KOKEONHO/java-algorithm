package baekjoon.gold.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나머지_합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long[] prefixSum = new long[N];
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        long answer = 0;
        Map<Long, Integer> modMap = new HashMap<>();
        modMap.put((long) 0, 1);

        for (long prefix : prefixSum) {
            long currentMod = prefix % M;
            if (modMap.containsKey(currentMod)) {
                answer += modMap.get(currentMod);
            }
            modMap.put(currentMod, modMap.getOrDefault(currentMod, 0) + 1);
        }

        System.out.println(answer);

    }
}