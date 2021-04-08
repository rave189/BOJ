import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int answer = 0;
		if (input[0].length() == input[1].length()) {
			for (int i = 0; i < input[0].length(); i++) {
				char left = input[0].charAt(i);
				char right = input[1].charAt(i);
				if (left == right) {
					if (left == '8')
						answer++;
				} else
					break;
			}
		}
		System.out.println(answer);
	}
}
