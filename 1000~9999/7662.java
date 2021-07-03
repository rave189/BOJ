package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 이중 우선순위 큐는 우선순위 큐처럼 데이터를 삽입, 삭제할 수 있는 자료구조이다.
 * 우선순위 큐와 다른 점은 연산 명령에 따라 최댓값과 최솟값을 삭제할 수 있다는 점이다.
 * 큐에 적용될 연산들을 모두 수행하고 난 후 큐에 저장된 최댓값과 최솟값을 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	// 트리 맵으로 정렬된 우선순위 큐를 구현한다.
	static TreeMap<Long, Integer> tree = new TreeMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			tree.clear();
			int n = Integer.parseInt(br.readLine());
			while (n-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				long value = Long.parseLong(st.nextToken());
				if (command.equals("I"))
					tree.put(value, tree.getOrDefault(value, 0) + 1);
				else if (!tree.isEmpty()) {
					if (value == 1)
						remove(tree.lastKey());
					else
						remove(tree.firstKey());
				}
			}
			if (tree.isEmpty())
				sb.append("EMPTY");
			else
				sb.append(tree.lastKey() + " " + tree.firstKey());
			sb.append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * key값에 해당하는 value를 1 감소한다.
	 * value가 0이 되면 트리 맵에서 삭제한다.
	 * @param key 지울 key
	 */
	public static void remove(long key) {
		tree.put(key, tree.get(key) - 1);
		if (tree.get(key) == 0)
			tree.remove(key);
	}
}