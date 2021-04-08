import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder[] arr = new StringBuilder[4];
		for (int i = 0; i < arr.length; i++)
			arr[i] = new StringBuilder(br.readLine());
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(stk.nextToken()) - 1;
			int direction = Integer.parseInt(stk.nextToken());
			int leftDirection = direction;
			int rightDirection = direction;
			Queue<Integer> q = new LinkedList<Integer>();
			for (int j = num; j > 0; j--)
				if (arr[j].charAt(6) != arr[j - 1].charAt(2))
					q.add(j - 1);
				else
					break;
			while (!q.isEmpty())
				Rotation(arr[q.poll()], leftDirection *= -1);
			for (int j = num; j < arr.length - 1; j++)
				if (arr[j].charAt(2) != arr[j + 1].charAt(6))
					q.add(j + 1);
				else
					break;
			while (!q.isEmpty())
				Rotation(arr[q.poll()], rightDirection *= -1);
			Rotation(arr[num], direction);
		}
		int answer = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i].charAt(0) == '1')
				answer += Math.pow(2, i);
		System.out.println(answer);
	}

	public static void Rotation(StringBuilder sb, int direction) {
		if (direction == 1) {
			sb.insert(0, sb.charAt(sb.length() - 1));
			sb.deleteCharAt(sb.length() - 1);
		} else {
			sb.append(sb.charAt(0));
			sb.deleteCharAt(0);
		}
	}
}
