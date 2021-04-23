package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �ִ� 500�� ���� �迭�� �������� �� K��° ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		MergeSort(0, n);
		System.out.println(arr[k - 1]);
	}

	/**
	 * �պ������� �̿��Ͽ� �迭�� �����ϴ� �޼ҵ�
	 * @param left ���� �� ��
	 * @param right ������ �� ��
	 */
	public static void MergeSort(int left, int right) {
		if (right - left <= 1)
			return;
		int mid = (left + right) / 2;
		MergeSort(left, mid);
		MergeSort(mid, right);
		Swap(left, mid, mid, right);
	}

	/**
	 * (x1, y1)�� (x2, y2)�� ������ �����ϸ� ��ġ�� �޼ҵ�
	 * @param x1 ���� �迭�� ���� �ε���
	 * @param y1 ���� �迭�� �� �ε���
	 * @param x2 ������ �迭�� ���� �ε���
	 * @param y2 ������ �迭�� �� �ε���
	 */
	public static void Swap(int x1, int y1, int x2, int y2) {
		int[] tmp = new int[y2 - x1];
		int tmpCnt = 0;
		int saveX1 = x1;
		while (x1 < y1 && x2 < y2) {
			if (arr[x1] < arr[x2])
				tmp[tmpCnt++] = arr[x1++];
			else
				tmp[tmpCnt++] = arr[x2++];
		}
		while (x1 < y1)
			tmp[tmpCnt++] = arr[x1++];
		while (x2 < y2)
			tmp[tmpCnt++] = arr[x2++];
		tmpCnt = 0;
		for (int i = saveX1; i < y2; i++)
			arr[i] = tmp[tmpCnt++];
	}
}