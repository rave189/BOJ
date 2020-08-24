import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		int[] result = new int[n + 1];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(stk.nextToken());
		arr[0] = Integer.MAX_VALUE;
		for (int i = n; i > 0; i--) {
			while (!st.empty())
				if (arr[i] > arr[st.peek()])
					result[st.pop()] = i;
				else
					break;
			st.push(i);
		}
		for (int i = 1; i <= n; i++)
			bw.write(Integer.toString(result[i]) + " ");
		bw.flush();
	}
}
