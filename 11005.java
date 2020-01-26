import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] s = bf.readLine().split(" ");
		long num = Long.parseLong(s[0]);
		int base = Integer.parseInt(s[1]);
		while(num != 0) {
			long r = num % base;
			num = num/base;
			if (r >= 10) {
				r += 55;
				sb.append((char)r);
			} else
				sb.append(r);
		}
		sb = sb.reverse();
		bw.write(sb.toString());
		bw.flush();
	}
}
