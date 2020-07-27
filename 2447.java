import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			boolean done = false;
			int temp = num;
			for (int j = 0; j < num; j += temp) {
				done = false;
				temp = num;
				int tmpX = i;
				int tmpY = j;
				while (temp != 1) {
					tmpX %= temp;
					tmpY %= temp;
					temp = temp / 3;
					if ((tmpX >= temp && tmpX < temp * 2) && tmpY >= temp && tmpY < temp * 2) {
						for (int t = 0; t < temp; t++)
							bw.write(" ");
						done = true;
						break;
					}
				}
				if (!done)
					bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
