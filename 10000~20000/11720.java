import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bf.readLine());
		String line = bf.readLine();
		int sum = 0;
		for(int i=0; i<num; i++)
			sum += Integer.parseInt(line.substring(i, i+1));
		bw.write(Integer.toString(sum));
		bw.flush();
	}
}
