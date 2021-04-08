import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		Stack<Integer> st = new Stack<Integer>();
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
			while (!st.isEmpty() && arr[st.peek()] < arr[i])
				result[st.pop()] = arr[i];
			st.add(i);
		}
		for (int i = 0; i < n; i++)
			sb.append(result[i] != 0 ? result[i] + " " : "-1 ");
		System.out.println(sb);
	}
}
