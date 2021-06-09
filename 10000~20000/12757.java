package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 데이터베이스에서 데이터 추가, 수정, 검색을 지원하는 프로그램을 만드는 문제
 * 이 프로그램에서는 Key가 존재하지 않아도 가장 근접한 Key를 찾아주는 프로그램이다.
 * 단, 두 수의 차이가 K보다 큰 경우 Key로 인정하지 않는다.
 * 1 Key Value가 들어오면 Key와 Value를 데이터베이스에 추가한다.
 * 2 Key Value가 들어오면 Key로 검색된 데이터를 Value로 변경한다.
 * 	조건을 만족하는 Key가 없다면 무시한다.
 * 3 Key가 들어오면 해당 Key로 검색된 데이터를 출력한다.
 * 	조건을 만족하는 Key가 없다면 -1을 출력한다.
 * 	조건을 만족하는 Key가 두 개 이상 존재한다면 ?를 출력한다.
 * @author Rave
 *
 */
public class Main {

	static TreeMap<Integer, Integer> tree = new TreeMap<>();
	static int k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			tree.put(key, value);
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int key = Integer.parseInt(st.nextToken());
			// 1이 들어오면 데이터를 추가한다.
			if (type == 1) {
				int value = Integer.parseInt(st.nextToken());
				tree.put(key, value);
			}
			// 2가 들어오면 Key를 찾을 수 있는 경우 데이터를 변경한다.
			else if (type == 2) {
				int value = Integer.parseInt(st.nextToken());
				int correctKey = getCorrectKey(key);
				if (correctKey >= 0)
					tree.put(correctKey, value);
			}
			// 3이 들어오면 Key를 찾을 수 있다면 그에 해당하는 Value를 출력하고
			// 두 개 이상이면 ?를, 찾을 수 없다면 -1을 출력한다.
			else if (type == 3) {
				int correctKey = getCorrectKey(key);
				if (correctKey >= 0)
					sb.append(tree.get(correctKey) + "\n");
				else if (correctKey == -2)
					sb.append("?\n");
				else
					sb.append("-1\n");
			}
		}
		System.out.println(sb);
	}

	/**
	 * 데이터베이스에서 Key와 가장 근접한 Key를 찾는 메소드
	 * @param key 찾으려는 Key
	 * @return Key가 존재한다면 Key, 두 개 이상이라면 -2, 찾을 수 없다면 -1
	 */
	public static int getCorrectKey(int key) {
		Integer ceilKey = tree.ceilingKey(key);
		Integer floorKey = tree.floorKey(key);
		// null일 경우에는 다른 Key를 비교한다.
		if (ceilKey == null) {
			if (isMatching(key, floorKey))
				return floorKey;
		} else if (floorKey == null) {
			if (isMatching(key, ceilKey))
				return ceilKey;
		}
		// 두 키가 null이 아닐 경우 두 수의 차이가 더 작은 키를 반환한다.
		else {
			int ceilDiff = Math.abs(ceilKey - key);
			int floorDiff = Math.abs(floorKey - key);
			if (ceilDiff < floorDiff) {
				if (isMatching(key, ceilKey))
					return ceilKey;
			} else if (ceilDiff == floorDiff) {
				// Key가 두 개 이상인 경우는 Key가 일치하거나 두 개의 Key가 있는 경우이다.
				if (ceilKey == key)
					return key;
				else {
					return -2;
				}
			} else if (isMatching(key, floorKey))
				return floorKey;
		}
		return -1;
	}

	public static boolean isMatching(int key, int compare) {
		if (key - k <= compare && compare <= key + k)
			return true;
		return false;
	}
}