package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 불기 연도를 서기 연도로 바꾸는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 불기 연도에서 543년을 빼면 서기 연도가 된다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Integer.parseInt(br.readLine()) - 543);
	}
}