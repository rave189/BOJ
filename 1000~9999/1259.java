import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String line = br.readLine();
			if (line.equals("0"))
				break;
			int length = line.length();
			boolean done = true;
			for (int i = 0; i < length / 2; i++) {
				if (!line.substring(i, i + 1).equals(line.substring(length - i - 1, length - i))) {
					done = false;
					break;
				}
			}
			if (done)
				bw.write("yes\n");
			else
				bw.write("no\n");
		}
		bw.flush();
	}
}
