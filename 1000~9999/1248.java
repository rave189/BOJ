import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] result;
	static char[][] input;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		result = new int[n];
		input = new char[n][];
		String[] line = br.readLine().split("");
		int lineCnt = 0;
		for (int i = 0, j = n; i < n; i++, j--) {
			input[i] = new char[j];
			for (int t = 0; t < j; t++) {
				input[i][t] = line[lineCnt++].charAt(0);
			}
		}
		Search(0);
		System.out.println(answer);
	}

	public static boolean Search(int depth) {
		if (depth == result.length) {
			for (int i = 0; i < result.length; i++)
				answer.append(result[i] + " ");
			return true;
		}
		char ch = input[depth][0];
		int start = ch == '+' ? 1 : ch == '0' ? 0 : -10;
		int end = ch == '+' ? 10 : ch == '0' ? 0 : -1;
		for (int i = start; i <= end; i++) {
			result[depth] = i;
			if (Check(depth) && Search(depth + 1))
				return true;
		}
		return false;
	}

	public static boolean Check(int depth) {
		int sum = 0;
		for (int i = 0; i <= depth; i++)
			sum += result[i];
		for (int i = 0, j = depth; i <= depth; i++, j--) {
			char ch = input[i][j];
			if (sum > 0 && ch != '+')
				return false;
			else if (sum == 0 && ch != '0')
				return false;
			else if (sum < 0 && ch != '-')
				return false;
			sum -= result[i];
		}
		return true;
	}
}
