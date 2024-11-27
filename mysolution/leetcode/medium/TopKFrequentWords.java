package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

  public List<String> topKFrequent(String[] words, int k) {

    Map<String, Integer> wordCount = new HashMap<>();

    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<String> maxHeap = new PriorityQueue<>((word1, word2) -> {
      if (wordCount.get(word1).equals(wordCount.get(word2))) { // when words appear equally, goes with lexicographical order
        return word1.compareTo(word2);
      }
      return wordCount.get(word2) - wordCount.get(word1);
    });

    for (String word : wordCount.keySet()) {
      maxHeap.add(word);
    }

    List<String> result = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      result.add(maxHeap.poll());
    }

    return result;

  }

}
