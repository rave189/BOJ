package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 휴게소가 있는 고속도로에 M개의 휴게소를 더 세우려고 한다.
 * M개의 휴게소를 더 지어 휴게소가 없는 구간의 길이의 최댓값을 최소값을 구하는 문제
 * 반드시 M개를 모두 지어야 한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 휴개소가 없는 구간의 길이의 최댓값을 이분탐색을 통해 찾는다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 배열의 0과 l을 추가하여 만든다.
		int[] RestArea = new int[n + 2];
		for (int i = 1; i <= n; i++)
			RestArea[i] = Integer.parseInt(st.nextToken());
		RestArea[n + 1] = l;
		// 정렬을 하여 휴개소가 없는 구간의 길이를 알 수 있게 한다.
		Arrays.sort(RestArea);
		int left = 1, right = l, answer = Integer.MAX_VALUE;
		// 이분 탐색을 통해 정답을 찾는다.
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			// mid가 70이고 두 휴개소의 거리 차이가 210일 때, 70과 140에 설치하면 된다.
			// 따라서 차이를 mid로 나누고 값을 올림한 후 1을 빼는 방법으로 구할 수 있다.
			for (int i = 1; i < RestArea.length; i++)
				cnt += Math.ceil((RestArea[i] - RestArea[i - 1]) / (double) mid) - 1;
			if (cnt > m)
				left = mid + 1;
			else {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}