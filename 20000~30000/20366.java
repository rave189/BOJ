package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 눈덩이 N개 중에서 4개의 눈덩이를 골라 눈사람 2개를 만드려고 한다.
 * 눈사람은 큰 눈덩이 한 개를 아래에 두고 크지 않은 눈덩이를 위에 올리는 방식으로 만든다.
 * 눈사람의 키는 두 눈덩이의 지름의 합과 같다.
 * 두 눈사람의 키의 차이의 최솟값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 이중 for문을 통해 눈사람 한 개를 완성한다.
	 * 이후 i와 j사이의 값들로 이분 탐색을 하여 두 번째 눈사람을 만든다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int answer = Integer.MAX_VALUE;
		// 눈사람 하나를 브루트포스로 찾는다.
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 3; j < n; j++) {
				// i와 j사이의 값들로 이분 탐색을 수행한다.
				int left = i + 1, right = j - 1;
				int snowMan = arr[i] + arr[j];
				while (left < right) {
					int compare = arr[right] + arr[left];
					// 눈사람의 키의 차이가 최소값을 저장한다.
					answer = Math.min(answer, Math.abs(snowMan - compare));
					// snowMan이 크다면 left를 증가시켜 compare의 크기를 늘린다.
					if (snowMan - compare > 0)
						left++;
					// 키의 차이가 0보다 작을 수 없으므로 0이면 출력하고 종료한다.
					else if (snowMan - compare == 0) {
						System.out.println(0);
						return;
					}
					// compare가 크다면 right를 감소시켜 compare의 크기를 줄인다.
					else
						right--;
				}
			}
		}
		System.out.println(answer);
	}
}