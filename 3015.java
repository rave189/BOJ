import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<Integer>();
		int[] arr = new int[n];
		int[] check = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		long result = 0;
		for (int i = 0; i < n; i++) {
			while (!st.empty()) {
				result++;
				if (arr[i] > arr[st.peek()])
					result += check[st.pop()];
				else if (arr[i] == arr[st.peek()]) {
					result += check[st.peek()];
					check[i] = check[st.pop()] + 1;
				} else
					break;
			}
			st.push(i);
		}
		System.out.println(result);
	}
}
