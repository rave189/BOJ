package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N*4개의 데이터가 주어진다.
 * 하나의 열은 하나의 배열이다.
 * 각 배열에서 하나씩 꺼내 모두 더한 값이 0이 되는 쌍의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] left, right;

	/**
	 * 이분탐색과 두 포인터로 풀 수 있다.
	 * 두 포인터는 2개의 배열로 쪼개 각 배열에서 나올 수 있는 모든 경우의 수를 더한다.
	 * 결과로 나온 두 배열을 두 포인터로 0이 되는 값을 찾아 나간다.
	 * 이분 탐색은 2개의 배열만 선택하여 모든 경우의 수를 더하고 정렬한다.
	 * 남은 2개의 배열을 완전 탐색하며 나온 값의 -를 붙인 값이 정렬된 값 안에 있는지 확인한다.
	 * 같은 수가 여러 개 나올 수 있으므로 target의 가장 왼쪽의 인덱스를 구하고 target +1의 가장 왼쪽의 인덱스를 구해 빼주는 것으로
	 * 같은 수의 개수를 구할 수 있다.
	 * 
	 * 이분 탐색으로 구현할 때, ArrayList를 사용하면 무조건 시간 초과가 나온다.
	 * N이 최대 4000개이고 이를 배열로 만들면 16000개인데 ArrayList에는 값이 너무 많이 들어오면 기존 저장 배열을 늘리는 연산이 추가로 들기 때문에
	 * 안그래도 아슬아슬한 시간을 못견디고 시간 초과가 난다.
	 * 이를 고정된 크기의 int 배열로 선언해두면 시간 초과는 안나는데 시간이 11초 걸리게 된다.
	 * 그래서 두 포인터를 사용하면 4초로 줄일 수 있다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		left = new int[n * n];
		right = new int[n * n];
		int[][] arr = new int[n][4];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				left[i * n + j] = arr[i][0] + arr[j][1];
				right[i * n + j] = arr[i][2] + arr[j][3];
			}
		Arrays.sort(left);
		Arrays.sort(right);
		long answer = 0;
		int start = 0, end = right.length - 1;
		while (start < left.length && 0 <= end) {
			int sum = left[start] + right[end];
			if (sum > 0)
				end--;
			else if (sum < 0)
				start++;
			else {
				long startCnt = 0, endCnt = 0;
				int leftTarget = left[start], rightTarget = right[end];
				while (start < left.length && left[start] == leftTarget) {
					startCnt++;
					start++;
				}
				while (0 <= end && right[end] == rightTarget) {
					endCnt++;
					end--;
				}
				answer += startCnt * endCnt;
			}
		}
		System.out.println(answer);
	}
}