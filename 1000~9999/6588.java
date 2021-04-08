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
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				break;
			String ans = "";
			for (int i = 1; i <= num / 2; i++) {
				int a = prime(i);
				int b = 0;
				if (a > 0) {
					b = prime(num - a);
					if(b > 0) {
						ans = num + " = " + a + " + " + b;
						break;
					}
				}
			}
			if(ans.equals(""))
				bw.write("Goldbach's conjecture is wrong.\n");
			else
				bw.write(ans+"\n");
			bw.flush();
		}
	}

	public static int prime(int n) {
		if (n < 2)
			return -1;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return -1;
		return n;
	}
}
