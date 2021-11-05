package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 한 반의 30명의 학생이 있다.
 * 이 중 28명의 학생만 과제를 제출햇을 때
 * 제출하지 않은 학생의 출석 번호를 구하는 문제
 * 입력으로 과제를 제출한 28명의 학생의 출석 번호가 주어진다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isSubmit = new boolean[31];
		for (int i = 0; i < 28; i++)
			isSubmit[Integer.parseInt(br.readLine())] = true;
		for (int i = 1; i < isSubmit.length; i++)
			if (!isSubmit[i])
				System.out.println(i);
	}
}