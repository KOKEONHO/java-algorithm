# Java Algorithm

## 📝 풀이 목록

### LeetCode

#### EASY

##### 1. Two Sum
`HashMap`: 내부적으로 해시 테이블로 구현되어 있음  
이 경우 조회는 평균적으로 O(1) 가능  
최악의 경우에는 O(n)이 될 수 있지만, 그럴 가능성 희박

##### 125. Valid Palindrome
`Character.isLetterOrDigit()`: 특정 문자가 영숫자인지 판별  

`StringBuilder`: 스레드 안전(Thread Safe)하지 않음  
`reverse()` 메서드 존재 → 문자열 뒤집기에 사용

##### 344. Reverse String
원시 자료형인 문자 배열 직접 조작 = 실행 속도 매우 빠름

#### 819. Most Common Word

- [ ] 나중에 다시 풀기  

`getOrDefault()`:  
값이 존재하지 않는 경우 기본 값 출력  
존재하는 경우에는 해당하는 값 출력

```java
Map<String, Integer> wordCount = new HashMap<>();
...
Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
```
이런 식으로 

#### MEDIUM

##### 937. Reorder Data in Log Files

- [ ] 나중에 다시 풀기

`Collections.sort()`에서 `Comparator` 사용 시 → 람다 표현식을 사용하면 훨씬 간단하고 실행 속도도 빠름

```java
Collections.sort(letterLogList, (s1, s2) -> {
	String[] s1x = s1.split(" ", 2);
	String[] s2x = s2.split(" ", 2);
    });
```

더 나아가 `List`의 메서드 직접 호출하는 형태로도 가능

```java
letterLogList.sort((s1, s2) -> {
	String[] s1x = s1.split(" ", 2);
	String[] s2x = s2.split(" ", 2);
    })
```

`letterLogList.toArray(new String[0]);`: 리스트를 배열로 변환하는 Java의 표준 방식  
배열의 크기를 0으로 지정하는 것 = 일종의 관례, Java 내부적으로 이 배열의 크기는 리스트의 크기에 맞게 자동으로 조정  
이 방식은 타입 안정성 제공 + 컴파일러에게 변환될 배열의 타입을 명확하게 알려줌

##### 452. Minimum Number of Arrows to Burst Balloons

한 화살로 최대한 많은 풍선을 터뜨려야 하기 때문에 → 배열에서 겹치는 부분을 구해줘야 함  
주어진 2차원 배열(`points`)의 각 원소(1차원 배열)들을 첫 번째 값으로 오름차순 정렬  
겹치는 부분을 `temp`에 저장하며 갱신

```java
Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
```
람다 표현식을 사용하여 2차원 배열의 원소들인 1차원 배열의 첫 번째 원소 값을 기준으로 오름차순 정렬
