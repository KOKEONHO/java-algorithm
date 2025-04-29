package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class 숨바꼭질_3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수빈 위치
        int K = Integer.parseInt(st.nextToken());   // 동생 위치

        boolean[] visited = new boolean[100001];
        visited[N] = true;

        Position position = new Position(N, 0);

        Deque<Position> deque = new ArrayDeque<>();
        deque.addLast(position);

        while (!deque.isEmpty()) {
            Position poll = deque.pollFirst();

            int currPosition = poll.position;
            int currTime = poll.time;

            if (currPosition == K) {
                System.out.println(currTime);
                return;
            }

            if (currPosition * 2 <= 100000 && !visited[currPosition * 2]) {
                deque.addFirst(new Position(currPosition * 2, currTime));
                visited[currPosition * 2] = true;
            }

            if (currPosition - 1 <= 100000 && currPosition - 1 >= 0 && !visited[currPosition - 1]) {
                deque.addLast(new Position(currPosition - 1, currTime + 1));
                visited[currPosition - 1] = true;
            }

            if (currPosition + 1 <= 100000 && !visited[currPosition + 1]) {
                deque.addLast(new Position(currPosition + 1, currTime + 1));
                visited[currPosition + 1] = true;
            }
        }
    }

    private static class Position {

        int position;
        int time;

        public Position(int position, int time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.position, this.time);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Position)) // 여기서도 Main.Position이 아니라 그냥 Position
                return false;
            Position other = (Position) obj;
            return this.position == other.position && this.time == other.time;
        }
    }
}
