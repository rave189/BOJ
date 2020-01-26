import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String num = bf.readLine();
		int count = 0;
		if(Integer.parseInt(num) < 100)
			System.out.println(num);
		else {
			int number = Integer.parseInt(num);
			for(int i=100; i <= number; i++) {
				String temp = Integer.toString(i);
				int tempA = Integer.parseInt(temp.substring(0, 1));
				int tempB = Integer.parseInt(temp.substring(1, 2));
				int tempC = Integer.parseInt(temp.substring(2, 3));
				if(tempB-tempA == tempC - tempB)
					count++;
			}
			System.out.println(99+count);
		}
	}
}
