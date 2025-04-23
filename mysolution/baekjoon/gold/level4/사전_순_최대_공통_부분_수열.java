package baekjoon.gold.level4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 사전_순_최대_공통_부분_수열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Integer> result = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[] nArray = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] mArray = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            mArray[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, List<Integer>> nMap = new HashMap<>();
        Map<Integer, List<Integer>> mMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            nMap.computeIfAbsent(nArray[i], k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < M; i++) {
            mMap.computeIfAbsent(mArray[i], k -> new ArrayList<>()).add(i);
        }

        int prevNIdx = -1;
        int prevMIdx = -1;

        for (int num = 100; num > 0; num--) {

            if (!nMap.containsKey(num) || !mMap.containsKey(num)) {
                continue;
            }

            int ptrN = 0;
            int ptrM = 0;

            List<Integer> nIdxList = nMap.get(num);
            List<Integer> mIdxList = mMap.get(num);

            int nListSize = nIdxList.size();
            int mListSize = mIdxList.size();

            while (ptrN < nListSize && nIdxList.get(ptrN) <= prevNIdx) {
                ptrN++;
            }

            while (ptrM < mListSize && mIdxList.get(ptrM) <= prevMIdx) {
                ptrM++;
            }

            while (ptrN < nListSize && ptrM < mListSize) {
                int nIdx = nIdxList.get(ptrN);
                int mIdx = mIdxList.get(ptrM);

                if (nIdx > prevNIdx && mIdx > prevMIdx) {
                    result.add(num);
                    prevNIdx = nIdx;
                    prevMIdx = mIdx;
                    ptrN++;
                    ptrM++;
                } else {
                    break;
                }

            }
        }

        sb.append(result.size()).append("\n");

        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
