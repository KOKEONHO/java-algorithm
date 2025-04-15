package baekjoon.gold.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 순회강연 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> lectures = new PriorityQueue<>(Comparator.comparingInt(lecture -> lecture.day));
        PriorityQueue<Lecture> prices = new PriorityQueue<>(Comparator.comparingInt(lecture -> lecture.price));

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Lecture lecture = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            lectures.add(lecture);
        }

        while (!lectures.isEmpty()) {
            Lecture polled = lectures.poll();

            prices.add(polled);

            if (prices.size() > polled.day) {
                prices.poll();
            }
        }

        int result = 0;

        while (!prices.isEmpty()) {
            result += prices.poll().price;
        }

        System.out.println(result);

    }

    private static class Lecture {

        int price;
        int day;

        public Lecture(int price, int day) {
            this.price = price;
            this.day = day;
        }
    }
}

