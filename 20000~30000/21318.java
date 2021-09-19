package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시은이는 N개의 피아노 악보를 가지고 있다.
 * 각각의 악보는 정수로 표현되는 난이도를 가지고 있다.
 * 1부터 N까지의 수 중에서 두 수 x, y를 골라 x번부터 y번까지 연주하려고 한다.
 * 하지만 i번 악보가 i+1번 악보보다 난이도가 높다면 시은이는 항상 실수를 한다.
 * 따라서 마지막 악보에서는 절대 실수하지 않는다.
 * 이 때, 두 수 x, y가 q번 주어질 때 시은이가 실수하는 횟수를 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 시은이가 실수하는 횟수를 누적합으로 미리 구해두고
	 * 주어지는 x, y에 따라 시은이가 실수하는 횟수를 출력한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] notes = new int[n];
		for (int i = 0; i < n; i++)
			notes[i] = Integer.parseInt(st.nextToken());
		int[] partSum = new int[n];
		for (int i = 1; i < n; i++) {
			partSum[i] = notes[i] < notes[i - 1] ? 1 : 0;
			partSum[i] += partSum[i - 1];
		}
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			sb.append(partSum[second] - partSum[first]).append("\n");
		}
		System.out.println(sb);
	}
}