package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 8x8 크기의 체스판이 있다.
 * 가장 왼쪽 위인 (0, 0)은 하얀색이다.
 * 체스판은 하얀색과 검정색이 번갈아가며 칠해져 있다.
 * 체스판의 상태가 주어졌을 때, 하얀 칸 위에 말이 몇 개 있는지 구하는 문제 말은 F이고 .은 빈칸이다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * i와 j의 %2가 같은 위치가 하얀색이다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = 8;
		int answer = 0;
		for (int i = 0; i < size; i++) {
			String line = br.readLine();
			for (int j = 0; j < size; j++)
				if (i % 2 == j % 2 && line.charAt(j) == 'F')
					answer++;
		}
		System.out.println(answer);
	}
}