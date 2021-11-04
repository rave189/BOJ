package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 뒤풀이를 하려고 한다.
 * 뒤풀이에 오는 사람들이 술을 마셨을 때 어느정도 마시면 기분이 좋은지, 어느정도 마시면 힘든지가 주어진다.
 * 모든 사람이 기분이 좋은 정도와 힘든 정도 사이의 술을 받으면서
 * 모든 사람이 받은 술의 총합이 정확히 T가 되고
 * 어떤 사람도 S를 초과하는 술은 받지 않도록하는 S의 최솟값을 구하는 문제
 * S 값에 관계없이 불가능하다면 -1 출력
 * @author Rave
 *
 */
public class Main {

	static Beer[] people;
	static int t;

	/**
	 * 이분탐색을 통해 S를 구한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		people = new Beer[n];
		int minSum = 0, maxSum = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			people[i] = new Beer(min, max);
			minSum += min;
			maxSum += max;
		}
		// 미리 min과 max를 모두 더해 이 값 사이에 없다면 -1을 출력
		if (t < minSum || t > maxSum) {
			System.out.println(-1);
			return;
		}
		int left = 0, right = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			// 가능하면 최소값을 구해야하니 오른쪽을 줄인다.
			if (isPossible(mid, minSum))
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left);
	}

	/**
	 * 모든 사람이 최소 술을 마셨다고 가정한다.
	 * 이후 v와 max 중 작은 값을 구하고 여기에 min값을 빼주어 더 마실 수 있는 양을 구한다.
	 * 최소 술 + 더 마실 수 있는 술의 합이 T보다 크면 true를 반환하여 오른쪽을 줄인다.
	 * @param v S가 될 수 있는 값
	 * @param minSum 모든 사람들이 마신 최소한의 술의 양
	 * @return T 이상으로 마실 수 있다면 true, 아니라면 false
	 */
	public static boolean isPossible(int v, int minSum) {
		int more = 0;
		
		for (int i = 0; i < people.length; i++) {
			if (people[i].min > v)
				return false;
			more += Math.min(people[i].max, v) - people[i].min;
		}
		if (more >= t - minSum)
			return true;
		return false;
	}
}

class Beer {
	int min, max;

	public Beer(int min, int max) {
		this.min = min;
		this.max = max;
	}
}