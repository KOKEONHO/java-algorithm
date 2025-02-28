package programmers.level2;

public class 타겟_넘버_DFS {

    public int solution(int[] numbers, int target) {

        /*
         * numbers: 사용할 수 있는 숫자가 담긴 배열
         * target: 타겟 넘버
         */

        return dfs(numbers, target, 0, 0);

    }

    private int dfs(int[] numbers, int target, int index, int total) {

        if (index == numbers.length) {
            if (total == target) {
                return 1;
            }
            return 0;
        }

        return dfs(numbers, target, index + 1, total + numbers[index]) + dfs(numbers, target,
            index + 1, total - numbers[index]);

    }
}
