package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumReference {

	public int[] twoSumReference1(int[] nums, int target) {
		// 첫 번째 수를 뺀 결과 키 조회

		// HashMap: 내부적으로 해시 테이블로 구현되어 있음 → 이 경우 조회는 평균적으로 𝑂(1)에 가능
		// 최악의 경우에는 𝑂(𝑛)이 될 수 있지만 그럴 가능성은 굉장히 적음

		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], i);
		}

		for (int i = 0; i < hashMap.size(); i++) {
			if (hashMap.containsKey(target - nums[i]) && i != hashMap.get(target - nums[i])) {
				// `containsKey()`로 포함 여부를 판별하고
				// `get(target - nums[i])`로 중복 인덱스는 제외함
				// ex.
				// nums = [3, 2, 4]
				// target = 6
				// `get(target - nums[i])`가 없으면 `[0, 0]` 반환
				return new int[] {i, hashMap.get(target - nums[i])};
			}
		}
		return null;
	}

	public int[] twoSumReference2(int[] nums, int target) {
		// 조회 구조 개선

		// 기존 2개의 for문을 사용하던 코드를 1개를 사용하도록 수정

		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(target - nums[i])) {
				return new int[] {i, hashMap.get(target - nums[i])};
			}
			hashMap.put(nums[i], i);
		}
		return null;
	}

}
