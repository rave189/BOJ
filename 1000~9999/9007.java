package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 카누 경주 챔피언십에 나갈 학생을 뽑으려고 한다.
 * 이 카누 경주에서 최대의 성과를 내려면 학생들의 몸무게의 합이 특정한 값에 근사해야 한다.
 * 총 4개의 반에 N명의 학생들이 있을 때, 몸무게의 합이 특정한 값에 근사하는 4명의 학생을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 4개의 반을 브루트포스로 탐색하기에는 너무 오래걸리므로
	 * 4개의 반을 2개, 2개로 나눈 후 2개의 반에서 나올수 있는 모든 몸무게의 합을 하나의 배열에 넣는다.
	 * 이후 한 개의 반을 정렬한 후, 정렬하지 않은 반에선 선형 탐색을 정렬된 반에서는 이분 탐색으로 4명의 학생을 찾는다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[][] classes = new int[4][n];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					classes[i][j] = Integer.parseInt(st.nextToken());
			}
			// 반을 2개로 나눈다.
			int[] class1 = new int[n * n];
			int[] class2 = new int[n * n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					// 나올 수 있는 모든 몸무게의 합을 넣는다.
					class1[i * n + j] = classes[0][i] + classes[1][j];
					class2[i * n + j] = classes[2][i] + classes[3][j];
				}
			// 한 쪽 반만 정렬한다.
			Arrays.sort(class2);
			int answer = Integer.MAX_VALUE;
			// 정렬되지 않은 반에선 선형탐색을, 정렬된 반에는 이분 탐색을 수행한다.
			loop: for (int i = 0; i < class1.length; i++) {
				int left = 0, right = class2.length - 1;
				while (left <= right) {
					int mid = (left + right) / 2;
					int sum = class1[i] + class2[mid];
					int check = Math.abs(sum - k) - Math.abs(answer - k);
					if (check < 0)
						answer = sum;
					else if (check == 0)
						answer = Math.min(answer, sum);
					if (sum - k < 0)
						left = mid + 1;
					else if (sum == k)
						break loop;
					else
						right = mid - 1;
				}
			}
			sb.append(answer + "\n");
		}
		System.out.print(sb);
	}
}