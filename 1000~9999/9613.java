import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int number = Integer.parseInt(bf.readLine());
		for (int i = 0; i < number; i++) {
			String[] s = bf.readLine().split(" ");
			int num = Integer.parseInt(s[0]);
			long sum = 0;
			for (int j = 1; j < num + 1; j++) {
				for (int t = j + 1; t < num + 1; t++) {
					int a = Integer.parseInt(s[j]);
					int b = Integer.parseInt(s[t]);
					while (b != 0) {
						int r = a % b;
						a = b;
						b = r;
					}
					sum += a;
				}
			}
			bw.write(sum+"\n");
			bw.flush();
		}
	}
}
