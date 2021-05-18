package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 여행을 떠나기 위해서 입국 심사를 거쳐야 한다.
 * 각 심사대는 한 명씩만 들어갈 수 있고, 비어있어야 들어갈 수 있다.
 * 또한 심사관들은 모두 심사하는데 걸리는 시간이 다를 수 있다.
 * 이 때, M명의 사람을 모두 검사하는데 드는 최소 시간을 구하는 문제
 * 심사대가 비어있더라도 오래걸린다면 기다렸다가 짧은 심사대로 들어갈 수 있다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 심사에 걸리는 최소 시간을 mid로 두고 이분 탐색을 한다.
	 * mid의 시간으로 심사를 할 수 있는 사람은 mid/심사시간의 총합이다.
	 * 총합을 구하고 이 값이 M보다 큰지 작은지 확인한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] immigration = new int[n];
		// right는 심사가 가장 오래걸리는 심사대 * m명이 최대 시간이다.
		// m은 10억이고, 심사시간도 10억이기 때문에 long으로 선언한다.
		long left = 0, right = 0;
		for (int i = 0; i < n; i++) {
			immigration[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, immigration[i]);
		}
		right *= m;
		while (left <= right) {
			long mid = (left + right) / 2;
			long checkPeople = 0;
			for (int i = 0; i < n; i++)
				checkPeople += mid / immigration[i];
			if (checkPeople >= m)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left);
	}
}