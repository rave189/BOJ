import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder[] totalGeer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		totalGeer = new StringBuilder[t];
		for (int i = 0; i < t; i++)
			totalGeer[i] = new StringBuilder(br.readLine());
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int geerIdx = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			RightRotation(geerIdx, direction);
			LeftRotation(geerIdx, direction);
			doRotate(geerIdx, direction);
		}
		int answer = 0;
		for (int i = 0; i < t; i++)
			if (totalGeer[i].charAt(0) == '1')
				answer++;
		System.out.println(answer);
	}

	public static void LeftRotation(int geerIdx, int direction) {
		if (geerIdx - 1 < 0)
			return;

		if (totalGeer[geerIdx - 1].charAt(2) != totalGeer[geerIdx].charAt(6)) {
			LeftRotation(geerIdx - 1, direction * -1);
			doRotate(geerIdx - 1, direction * -1);
		}
	}

	public static void RightRotation(int geerIdx, int direction) {
		if (geerIdx + 1 >= totalGeer.length)
			return;

		if (totalGeer[geerIdx].charAt(2) != totalGeer[geerIdx + 1].charAt(6)) {
			RightRotation(geerIdx + 1, direction * -1);
			doRotate(geerIdx + 1, direction * -1);
		}
	}

	public static void doRotate(int geerIdx, int direction) {
		StringBuilder geer = totalGeer[geerIdx];
		if (direction == 1) {
			geer.insert(0, geer.charAt(geer.length() - 1));
			geer.deleteCharAt(geer.length() - 1);
		} else {
			geer.append(geer.charAt(0));
			geer.deleteCharAt(0);
		}
	}
}
