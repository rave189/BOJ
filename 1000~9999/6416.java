package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 각 테스트 케이스가 트리인지 판별하는 문제
 * 트리의 조건은 다음과 같다.
 * 1.들어오는 간선이 하나도 없는 단 하나의 노드가 존재한다. 이를 루트(root) 노드라고 부른다.
 * 2.루트 노드를 제외한 모든 노드는 반드시 단 하나의 들어오는 간선이 존재한다.
 * 3.루트에서 다른 노드로 가는 경로는 반드시 가능하며, 유일하다. 이는 루트를 제외한 모든 노드에 성립해야 한다.
 * @author Rave
 *
 */
public class Main {

	static HashMap<Integer, Integer> hash;
	static boolean isTree;

	/**
	 * 루트 노드가 두 개인지 확인하고, 들어오는 간선이 하나인지, 같은 번호로 간선이 들어오는지를 확인하여 구분한다.
	 * 1 2 2 3 3 1 4 5 0 0의 입력에서 트리라고 판단한다. (통과는 하지만 수정될 거 같다.) 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int testCase = 1;
		loop: while (true) {
			hash = new HashMap<>();
			isTree = true;
			input: while (true) {
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					int parent = Integer.parseInt(st.nextToken());
					int child = Integer.parseInt(st.nextToken());
					if (parent == 0 && child == 0)
						break input;
					if (parent < 0 && child < 0)
						break loop;
					if (hash.containsKey(child))
						isTree = false;
					else if (hash.containsKey(parent) && hash.get(parent) == child)
						isTree = false;
					else if(parent == child)
						isTree = false;
					hash.put(child, parent);
				}
			}
			if (isTree)
				isOneOfTree();
			if (isTree)
				sb.append(String.format("Case %d is a tree.\n", testCase++));
			else
				sb.append(String.format("Case %d is not a tree.\n", testCase++));
		}
		System.out.print(sb);
	}

	/**
	 * 루트 노드가 한 개인지 구하는 메소드.
	 * parent값을 가져와 parent가 다른 노드의 child 노드이면 모두 찾아 지운다.
	 * 이후 남은 노드들 중에 parent가 한 개라면 루트 노드가 한 개이다.
	 */
	public static void isOneOfTree() {
		ArrayList<Integer> removeList = new ArrayList<>();
		for (int child : hash.keySet()) {
			int parent = hash.get(child);
			if (hash.containsKey(parent))
				removeList.add(child);
		}
		for (int key : removeList)
			hash.remove(key);
		Integer root = null;
		for (int key : hash.keySet()) {
			if (root == null)
				root = hash.get(key);
			else if (root != hash.get(key)) {
				isTree = false;
				return;
			}
		}
	}
}