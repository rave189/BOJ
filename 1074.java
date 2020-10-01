import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r;
	static int c;
	static int[] drtX = { 0, 0, 1, 1 };
	static int[] drtY = { 0, 1, 0, 1 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		Back(n, 0, 0);
	}

	public static boolean Back(int n, int x, int y) {
		int pow = (int) Math.pow(2, n - 1);
		int add = (int) Math.pow(4, n - 1);
		if (n == 1)
			add = 1;
		for (int i = 0; i < 4; i++) {
			int dx = x + pow + drtX[i] * pow;
			int dy = y + pow + drtY[i] * pow;
			if (n == 1) {
				dx = x + drtX[i];
				dy = y + drtY[i];
				if (dx == r && dy == c)
					System.out.println(count);
			} else if (dx > r && dy > c)
				return Back(n - 1, dx - pow, dy - pow);
			count += add;
		}
		return false;
	}
}
