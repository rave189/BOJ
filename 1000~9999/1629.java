import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		long A = Long.parseLong(s[0]);
		int B = Integer.parseInt(s[1]);
		int C = Integer.parseInt(s[2]);
		long remain = 1;
		while (B != 0) {
			if (B % 2 != 0) {
				remain = ((remain % C) * (A % C)) % C;
				B--;
			}
			A = ((A % C) * (A % C)) % C;
			B /= 2;
		}
		bw.write(Integer.toString((int) remain % C));
		bw.flush();
	}
}
