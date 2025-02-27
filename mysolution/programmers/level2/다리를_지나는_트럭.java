package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<int[]> bridge = new ArrayDeque<>();

        int index = 0;
        int result = 0;

        while (index < truck_weights.length || !bridge.isEmpty()) {
            result++;

            if (!bridge.isEmpty() && bridge.peekFirst()[1] == result) {
                weight += bridge.pollFirst()[0];
            }

            if (index < truck_weights.length && weight >= truck_weights[index]) {
                bridge.addLast(new int[] {truck_weights[index], result + bridge_length});
                weight -= truck_weights[index];
                index++;
            }
        }

        return result;

    }
}
