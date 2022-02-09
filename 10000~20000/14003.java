package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 수열 A가 주어질 때, 가장 긴 증가하는 부분 수열을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static ArrayList<Integer> d = new ArrayList<>();

	/**
	 * 입력이 너무 크기 때문에 기존의 증가하는 부분 수열 구하듯이 하면 시간 초과가 난다.
	 * 이전 값을 저장해둘 d 배열을 만든다.
	 * d 배열의 값은 앞으로 나올 수가 어느 구간에 있는지를 저장하는 정렬된 배열로 바이너리 서치를 통해 찾을 수 있다.(또는 인덱스 트리)
	 * 만약 검사해야 하는 수가 d의 마지막 수보다 큰 값이라면 d에 그대로 수를 추가해주어 최장 증가 수열의 크기를 늘린다.
	 * 만약 중간에 있는 수라면 이분 탐색을 통해 이 수가 어느 구간으로 들어가야 하는지를 받아온다.
	 * 이후 그 구간이 몇 번째 구간인지를 order 배열에 저장한다.
	 * 그리고 특정 구간의 수라면 특정 구간을 업데이트 해주고, d의 마지막 수보다 크다면 d에 그대로 추가해준다.
	 * 이후 최장 증가 수열은 order에 적힌 인덱스를 d의 크기를 하나씩 줄여가며 맞는지 비교한다.
	 * 최장 증가 수열의 요소는 여러 개가 될 수 있지만 가장 처음으로 만나는 인덱스를 최장 증가 수열의 요소로 판단하여 저장하고 출력한다. 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] order = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		d.add(arr[0]);
		for (int i = 1; i < n; i++) {
			int index = binarySearch(arr[i]);
			order[i] = index;
			if (index >= d.size())
				d.add(arr[i]);
			else
				d.set(index, arr[i]);
		}
		answer.append(d.size()).append('\n');
		int[] result = new int[d.size()];
		for (int i = n - 1, count = d.size() - 1; i >= 0; i--) {
			if (order[i] == count)
				result[count--] = arr[i];
		}
		for (int v : result)
			answer.append(v).append(' ');
		System.out.print(answer);
	}

	public static int binarySearch(int target) {
		int left = 0, right = d.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (d.get(mid) >= target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}
}