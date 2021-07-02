package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 수열 N이 있고 이 수열을 좌표 압축하려고 한다.
 * 좌표 압축한 결과인 Xi는 Xi > Xj를 만족하는 서로 다른 좌표의 개수이다.
 * 수열 N의 좌표 압축한 결과를 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		// 정렬된 배열과 기존 배열을 선언
		int[] arr = new int[n];
		int[] sortedArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sortedArr[i] = arr[i];
		}
		// 한 개의 배열을 정렬시킨다.
		Arrays.sort(sortedArr);
		HashMap<Integer, Integer> hash = new HashMap<>();
		int count = 0;
		// 가장 앞에서부터 hash에 존재하지 않는다면 hash에 count값을 넣어준다.
		for (int value : sortedArr)
			if (!hash.containsKey(value))
				hash.put(value, count++);
		// 값 출력
		for (int i = 0; i < n; i++)
			sb.append(hash.get(arr[i])).append(" ");
		System.out.println(sb);
	}
}