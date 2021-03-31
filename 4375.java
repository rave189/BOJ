import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer answer = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			int num = Integer.parseInt(line);
			int length = 1;
			for (int compare = 1; compare % num != 0; compare = ((compare * 10) + 1) % num, length++);
			answer.append(length + "\n");
		}
		System.out.println(answer);
	}
}
