import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int a = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		a -= Integer.parseInt(br.readLine());
		int count = 0;
		int[] arr = { 500, 100, 50, 10, 5, 1 };
		for (int i = 0; i < arr.length; i++)
			count += Change(arr[i]);
		bw.write(Integer.toString(count));
		bw.flush();
	}

	public static int Change(int num) {
		int count = 0;
		while (a >= num) {
			a -= num;
			count++;
		}
		return count;
	}
}
