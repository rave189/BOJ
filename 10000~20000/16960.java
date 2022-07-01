package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 스위치 N개와 램프 M개가 있다.
 * 스위치는 0개 이상의 램프와 연결되어 있다.
 * 스위치를 누르면 연결된 모든 램프의 불이 켜진다.
 * N개의 스위치를 모두 누르면 모든 램프가 켜진다.
 * N-1개의 스위치를 눌러서 모든 램프가 켜지는지 구하는 문제
 * 모든 램프가 켜지면 1 아니면 0을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static Set<Integer>[] map;

	/**
	 * 구현문제
	 * N, M이 2000인데 생각보다 컷이 널널함
	 * hash로 안하고 배열로 하면 좀 더 빠를지도?
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new Set[n];
		for (int i = 0; i < n; i++)
			map[i] = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			while (t-- > 0)
				map[i].add(Integer.parseInt(st.nextToken()) - 1);
		}
		loop: for (int i = 0; i < n; i++) {
			next: for (int v : map[i]) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					if (map[j].contains(v))
						continue next;
				}
				continue loop;
			}
			System.out.println(1);
			return;
		}
		System.out.println(0);
	}
}