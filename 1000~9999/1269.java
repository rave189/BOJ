package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 공집합이 아닌 두 집합이 주어질 때,
 * 이 두 집합의 합집합에서 교집합을 뺀 집합의 원소의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 한 쪽의 원소를 모두 hash에 넣는다.
	 * 이후 다른 집합에서 교집합이 발생하면 hash에서 빼고 그렇지 않다면 answer의 값을 증가시킨다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		HashSet<Integer> hash = new HashSet<>();
		while (n-- > 0) {
			int key = Integer.parseInt(st.nextToken());
			hash.add(key);
		}
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			int key = Integer.parseInt(st.nextToken());
			if (hash.contains(key))
				hash.remove(key);
			else
				answer++;
		}
		System.out.println(answer + hash.size());
	}
}