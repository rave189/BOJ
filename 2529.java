import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] check = new boolean[10];
	static String max = "0";
	static String min = Long.MAX_VALUE + "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		String[] signs = br.readLine().split(" ");
		for (int i = 0; i < 10; i++) {
			check[i] = true;
			Search(signs, 0, i, "" + i);
			check[i] = false;
		}
		System.out.println(max + "\n" + min);
	}

	public static void Search(String[] signs, int index, int prevValue, String result) {
		if (index >= signs.length) {
			long numOfResult = Long.parseLong(result);
			max = numOfResult > Long.parseLong(max) ? result : max;
			min = numOfResult < Long.parseLong(min) ? result : min;
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (check[i])
				continue;
			boolean done = false;
			if (signs[index].charAt(0) == '<' && prevValue < i)
				done = true;
			else if (signs[index].charAt(0) == '>' && prevValue > i)
				done = true;
			if (done) {
				check[i] = true;
				Search(signs, index + 1, i, result + i);
				check[i] = false;
			}
		}
	}
}
