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
		String[] s = bf.readLine().split("");
		for(int i=s.length-1; i>=0; i-=3) {
			int sum = 0;
			for(int j=0; j<3 && i-j >= 0; j++) {
				if(s[i-j].equals("1"))
					sum += Integer.parseInt(s[i-j])*Math.pow(2, j);
			}
			sb.append(sum);
		}
		sb = sb.reverse();
		bw.write(sb.toString());
		bw.flush();
	}
}
