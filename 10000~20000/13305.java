package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 도시와 N-1개의 도로가 있다.
 * 이 도시를 일직선으로 두고, 제일 왼쪽의 도시에서 제일 오른쪽 도시로 이동하려고 한다.
 * 처음 출발 시에는 기름이 없어 차에 기름을 넣어야 한다.
 * 기름통의 크기는 무제한이어서 얼마든지 들어갈 수 있다.
 * 도로를 이용하여 1km마다 1리터의 기름을 사용하여 이동할 수 있다.
 * 각 도시에는 하나의 주유소가 있으며, 도시마다 리터당 가격은 다를 수 있다.
 * 이 때, 제일 오른쪽 도시를 갈 수 있는 최소 비용을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 각 도시를 이동하며 기름값이 가장 싼 도시의 기름 값을 저장한 후
	 * 이 기름으로 다음 도시까지 계속 간다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] distance = new long[n - 1];
		long[] city = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < distance.length; i++)
			distance[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			city[i] = Integer.parseInt(st.nextToken());
		// 기본값 max
		long min = Long.MAX_VALUE;
		long sum = 0;
		for (int i = 0; i < distance.length; i++) {
			// 기름 값이 가장 싼지 구한다.
			min = Math.min(min, city[i]);
			// 기름 값이 가장 싼 도시의 기름으로 다음 도시를 간다.
			sum += min * distance[i];
		}
		System.out.println(sum);
	}
}