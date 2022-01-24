package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 수 N이 주어진다.
 * 이 N의 각 자리 숫자 중 i번째 숫자와 j번째 숫자를 바꾸는 연산을 K번 하려고 한다.
 * 단 맨 앞자리가 0이 오도록 바꿀 수는 없다.
 * K번 연산 후 만들 수 있는 가장 큰 수를 구하는 문제
 * 
 * @author Rave
 *
 */
public class Main {

	/**
	 * 중간 과정은 상관 없이 K번이 끝난 후 가장 큰 수를 찾는 문제이다.
	 * bfs를 통해 탐색한다.
	 * 만들 수 있는 수는 bruteforce를 사용하여 구한다.
	 * 단 같은 수가 많이 나올 수 있으므로 hash를 사용하여 걸러준다.
	 * 
	 * 뭔가 좀....
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> hash = new HashSet<>();
		q.add(n);
		while (!q.isEmpty() && k > 0) {
			hash.clear();
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				char[] strNum = Integer.toString(cur).toCharArray();
				for (int i = 0; i < strNum.length; i++) {
					for (int j = i + 1; j < strNum.length; j++) {
						if (strNum[j] == '0' && i == 0)
							continue;
						swap(strNum, i, j);
						int next = Integer.parseInt(new String(strNum));
						if (!hash.contains(next)) {
							q.add(next);
							hash.add(next);
						}
						swap(strNum, j, i);
					}
				}
			}
			k--;
		}
		int max = 0;
		while (!q.isEmpty())
			max = Math.max(max, q.poll());
		// N이 한자리 숫자이면 k = 0인데 q에 남은 수가 없어서 max가 0인 상황이 나온다.
		System.out.println(k == 0 && max != 0 ? max : -1);
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void swap(char[] num, int i, int j) {
		char tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
}