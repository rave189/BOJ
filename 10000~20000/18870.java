package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * ���� N�� �ְ� �� ������ ��ǥ �����Ϸ��� �Ѵ�.
 * ��ǥ ������ ����� Xi�� Xi > Xj�� �����ϴ� ���� �ٸ� ��ǥ�� �����̴�.
 * ���� N�� ��ǥ ������ ����� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		// ���ĵ� �迭�� ���� �迭�� ����
		int[] arr = new int[n];
		int[] sortedArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sortedArr[i] = arr[i];
		}
		// �� ���� �迭�� ���Ľ�Ų��.
		Arrays.sort(sortedArr);
		HashMap<Integer, Integer> hash = new HashMap<>();
		int count = 0;
		// ���� �տ������� hash�� �������� �ʴ´ٸ� hash�� count���� �־��ش�.
		for (int value : sortedArr)
			if (!hash.containsKey(value))
				hash.put(value, count++);
		// �� ���
		for (int i = 0; i < n; i++)
			sb.append(hash.get(arr[i])).append(" ");
		System.out.println(sb);
	}
}