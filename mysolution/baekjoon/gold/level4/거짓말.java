package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 거짓말 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 인원 수
        int M = Integer.parseInt(st.nextToken());   // 파티 수

        makeSet(N); // parent 배열 initialize

        List<List<Integer>> parties = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int truthCnt = Integer.parseInt(st.nextToken());    // 진실을 아는 인원 수

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int truthLeader = 0; // 추가: 진실을 아는 대표 루트 저장

        while (st.hasMoreTokens()) {
            int person = Integer.parseInt(st.nextToken());
            minHeap.add(person);
        }

        // 진실 아는 사람들끼리 union
        if (!minHeap.isEmpty()) {
            int minNumber = minHeap.poll();
            truthLeader = minNumber; // 가장 작은 번호를 기준 대표로 설정

            while (!minHeap.isEmpty()) {
                union(minNumber, minHeap.poll());
            }
        }

        // 파티 정보 입력 및 union 처리
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int peopleCnt = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();

            while (st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                minHeap.add(number);
                party.add(number);
            }

            parties.add(party);

            if (!party.isEmpty()) {
                int minNum = party.get(0);
                for (int i = 1; i < party.size(); i++) {
                    union(minNum, party.get(i));
                }
            }
        }

        // 진실 root 확인 (한 번만 하면 됨)
        int truthRoot = find(truthLeader);

        int result = 0;

        for (List<Integer> party : parties) {
            boolean flag = true;

            for (int number : party) {
                if (truthCnt > 0 && find(number) == truthRoot) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                result++;
        }

        System.out.println(result);
    }

    private static void makeSet(int N) {
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
    }

    private static int find(int a) {
        if (parent[a] != a)
            parent[a] = find(parent[a]);
        return parent[a];
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB)
            parent[rootB] = rootA;
    }
}
