package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N���� Ʈ���� ���̰� W�� �ٸ��� �������� �Ѵ�.
 * �ٸ��� �ִ������� L��ŭ�� ���Ը� �ߵ� �� �ִ�.
 * �̶� N���� Ʈ���� �ٸ��� �����µ� ��� �ð��� �ּڰ��� ���ϴ� ����
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
		// �ٸ��� ���̸�ŭ 0�� ä�� �ִ´�.
		for (int i = 0; i < w; i++)
			q.add(0);
		int weightSum = 0;
		int time = 0;
		for (int i = 0; i < arr.length; time++) {
			// ���̰� w�̸� q���� �ϳ��� ����. 
			if (q.size() == w)
				weightSum -= q.poll();
			// ���Ը� �ߵ� �� �ִٸ� Ʈ���� �� �� �ø���.
			if (weightSum + arr[i] <= l) {
				weightSum += arr[i];
				q.add(arr[i++]);
			} 
			// ���Ը� �ߵ� �� ���ٸ� 0�� �߰��Ѵ�.
			else
				q.add(0);
		}
		// Ʈ���� ��� �ٸ��� �ö󰡴µ� ��� �ð� + ���� Ʈ���� �ٸ��� �ǳʴµ� ��� �ð��� ����Ѵ�.
		System.out.println(time + q.size());
	}
}