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
			String s = bf.readLine();
			String[] sa = new String[s.length()];
			for (int j = 0; j < s.length(); j++)
				sa[j] = s.substring(j, j + 1);
			int sum = 0;
			int count = 0;
			for (int j = 0; j < s.length(); j++) {
				if (sa[j].equalsIgnoreCase("O"))
					sum += ++count;
				else if (sa[j].equalsIgnoreCase("X"))
					count = 0;
			}
			bw.write(Integer.toString(sum)+"\n");
			bw.flush();
		}
	}
}
