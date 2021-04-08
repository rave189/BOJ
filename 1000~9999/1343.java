import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		String input = br.readLine();
		int xCnt = 0;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == 'X')
				xCnt++;
			else {
				xCnt = Replace(answer, xCnt);
				answer.append(ch);
			}
		}
		Replace(answer, xCnt);
		System.out.println(answer);
	}

	public static int Replace(StringBuilder answer, int xCnt) {
		if (xCnt % 2 != 0) {
			System.out.println(-1);
			System.exit(0);
		}
		while (xCnt - 4 >= 0) {
			answer.append("AAAA");
			xCnt -= 4;
		}
		while (xCnt - 2 >= 0) {
			answer.append("BB");
			xCnt -= 2;
		}
		return xCnt;
	}
}
