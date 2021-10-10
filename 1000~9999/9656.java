package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 돌 게임은 두 명이서 하는 게임이다.
 * N개의 돌이 있을 때, 상근이와 창영이가 번갈아가며 1개 또는 3개의 돌을 가져갈 수 있다.
 * 마지막 돌을 가져가는 사람이 게임에서 패배한다.
 * 두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 문제
 * 게임은 상근이가 먼저 시작한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 상근이가 처음 시작하므로 1개 또는 3개는 무조건 창영이가 이긴다.
	 * 2개 또는 4개는 상근이가 무조건 이긴다.
	 * 이 규칙이 계속 되므로 n개의 돌을 2로 나눈 나머지가 0이면 상근이가, 아니라면 창영이가 이긴다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(n % 2 == 0 ? "SK" : "CY");
	}
}