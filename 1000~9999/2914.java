package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 앨범의 저작권을 내야 한다.
 * 이 때, 저작권이 있는 멜로디의 평균값을 구하려고 한다.
 * 평균값은 항상 올림으로 계산한다.
 * 앨범에 수록된 곡의 개수와 평균 값이 주어질 때,
 * 적어도 몇 곡이 저작권이 있는 멜로디인지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int i = Integer.parseInt(st.nextToken());
		System.out.println(a*(i-1)+1);
	}
}