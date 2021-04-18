package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N개의 트럭이 길이가 W인 다리를 지나려고 한다.
 * 다리는 최대하중인 L만큼의 무게를 견딜 수 있다.
 * 이때 N개의 트럭이 다리를 지나는데 드는 시간의 최솟값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		// 다리의 길이만큼 0을 채워 넣는다.
		for (int i = 0; i < w; i++)
			q.add(0);
		int weightSum = 0;
		int time = 0;
		for (int i = 0; i < arr.length; time++) {
			// 길이가 w이면 q에서 하나를 뺀다. 
			if (q.size() == w)
				weightSum -= q.poll();
			// 무게를 견딜 수 있다면 트럭을 한 대 올린다.
			if (weightSum + arr[i] <= l) {
				weightSum += arr[i];
				q.add(arr[i++]);
			} 
			// 무게를 견딜 수 없다면 0을 추가한다.
			else
				q.add(0);
		}
		// 트럭이 모두 다리에 올라가는데 드는 시간 + 남은 트럭이 다리를 건너는데 드는 시간을 출력한다.
		System.out.println(time + q.size());
	}
}