import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] date = new int[4];
			for (int j = 0; j < 4; j++)
				date[j] = Integer.parseInt(st.nextToken());
			int answer = -1;
			for (int j = 0; j < date[1]; j++)
				if ((j * date[0] + date[2] - 1) % date[1] + 1 == date[3]) {
					answer = j * date[0] + date[2];
					break;
				}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
}
