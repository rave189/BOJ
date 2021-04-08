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
		if (number < 10)
			number *= 10;
		String num = Integer.toString(number);
		int cycle = 0;
		int A, B, result;
		while (true) {
			if (num.length() == 1) {
				A = 0;
				B = Integer.parseInt(num);
			} else {
				A = Integer.parseInt(num.substring(0, 1));
				B = Integer.parseInt(num.substring(1, 2));
			}
			String sum = Integer.toString(A+B);
			if(sum.length() == 1) {
				result = Integer.parseInt(Integer.toString(B)+sum);
			}
			else {
				result = Integer.parseInt(Integer.toString(B)+sum.substring(1, 2));
			}
			cycle++;
			if(number == result)
				break;
			num = Integer.toString(result);
		}
		System.out.println(cycle);
	}
}
