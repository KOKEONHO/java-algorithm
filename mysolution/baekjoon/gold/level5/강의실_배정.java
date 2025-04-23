package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실_배정 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> lectures = new PriorityQueue<>(Comparator.comparingInt(lecture -> lecture.start));
        PriorityQueue<Integer> endTime = new PriorityQueue<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            Lecture lecture = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            lectures.add(lecture);
        }

        while (!lectures.isEmpty()) {
            Lecture poll = lectures.poll();

            if (!endTime.isEmpty() && endTime.peek() <= poll.start) {
                endTime.poll();
                endTime.add(poll.end);
                continue;
            }

            endTime.add(poll.end);
        }

        System.out.println(endTime.size());

    }

    private static class Lecture {

        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Lecture)) {
                return false;
            }
            Lecture other = (Lecture) obj;
            return start == other.start && end == other.end;
        }

    }
}
