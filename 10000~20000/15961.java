package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 회전 초밥집에서 먹을 수 있는 초밥의 가짓수의 최댓값을 구하는 문제
 * 초밥은 한 위치에서부터 k개 연속으로 먹는다.
 * 초밥집은 고객에게 쿠폰을 주어 쿠폰에 적힌 종류의 초밥 한 개를 무료로 제공한다.
 * 이 때, 초밥이 벨트위에 없으면 만들어서 제공한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 초밥을 0번부터 k개를 먹고 종류의 개수를 센다.
	 * 이후 0번을 지우고 k번째 초밥을 추가하고, 먹은 초밥의 종류가 최댓값인지 확인한다.
	 * 초밥집의 벨트는 회전을 하기 때문에 원형으로 이루어져 있다.
	 * 따라서 (0, k-1), (1, k), ... (n-1, k-1)까지 계산한다. 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		int[] type = new int[d + 1];
		int typeCnt = 0;
		// 처음 초밥 k개를 먹을 때의 초밥의 가짓수를 구한다.
		for (int i = 0; i < k; i++) {
			if (type[arr[i]] == 0)
				typeCnt++;
			type[arr[i]]++;
		}
		int answer = 0;
		for (int index = 0; index < n; index++) {
			// 초밥의 종류가 최댓값인지 확인한다.
			answer = type[c] == 0 ? Math.max(answer, typeCnt + 1) : Math.max(answer, typeCnt);
			// index번째의 초밥을 1개 빼고, 뺀 후의 값이 0 이면 종류를 1 감소시킨다.
			if (--type[arr[index]] == 0)
				typeCnt--;
			// 원형이기 때문에 n으로 모듈러를 취해준다.
			// index+k번째 있는 초밥을 1 증가시키고, 값이 0이었으면 종류를 1 증가시킨다.
			if (type[arr[(index + k) % n]]++ == 0)
				typeCnt++;
		}
		System.out.println(answer);
	}
}