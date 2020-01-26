import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = bf.readLine().split(" ");
		int base = Integer.parseInt(s[1]);
		long sum = 0;
		for(int i=0; i<s[0].length(); i++) {
			char c = s[0].charAt(i);
			int num;
			if(c >= 65 && c <= 90)
				num = c - 55;
			else
				num = Integer.parseInt(s[0].substring(i, i+1));
			sum += num * Math.pow(base, s[0].length()-(i+1));
		}
		bw.write(Long.toString(sum)+"\n");
		bw.flush();
	}
}
