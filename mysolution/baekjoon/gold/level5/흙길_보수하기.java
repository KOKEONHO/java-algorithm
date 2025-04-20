package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 흙길_보수하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 물 웅덩이 개수
        int L = Integer.parseInt(st.nextToken());   // 널빤지 길이

        PriorityQueue<Pool> pools = new PriorityQueue<>(Comparator.comparingInt(pool -> pool.start));

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            Pool pool = new Pool(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            pools.add(pool);
        }

        int total = 0;

        while (!pools.isEmpty()) {
            Pool currentPool = pools.poll();

            int currentStart = currentPool.start;
            int currentEnd = currentPool.end;

            int currentGap = currentEnd - currentStart;

            int plankCnt = currentGap / L;
            if (currentGap % L > 0) {
                plankCnt++;
            }

            int plankEnd = currentStart + (L * plankCnt);

            while (!pools.isEmpty()) {
                Pool peek = pools.peek();

                if (plankEnd >= peek.end) {
                    pools.poll();
                    continue;
                }

                if (plankEnd >= peek.start) {
                    Pool poll = pools.poll();

                    int pollGap = poll.end - plankEnd;

                    plankCnt += pollGap / L;
                    if (pollGap % L > 0) {
                        plankCnt++;
                    }

                    plankEnd = currentStart + (L * plankCnt);
                    continue;
                }

                break;
            }

            total += plankCnt;

        }

        System.out.println(total);

    }

    private static class Pool {

        int start;
        int end;

        public Pool(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}

