package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 에라토스테네스의 체를 사용하여 K번째로 지워지는 수를 구하는 문제
 * 알고리즘은 다음과 같다.
 * 2부터 N까지 모든 정수를 적는다.
 * 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
 * P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
 * 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] isRemoved = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			if (isRemoved[i])
				continue;
			for (int j = i; j <= n; j += i) {
				if (!isRemoved[j]) {
					isRemoved[j] = true;
					k--;
					if (k == 0) {
						System.out.println(j);
						return;
					}
				}
			}
		}
	}
}