import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		int[][] rotateMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				rotateMap[j][i] = map[i][j];
			}
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (Search(map[i], length))
				answer++;
			if (Search(rotateMap[i], length))
				answer++;
		}
		System.out.println(answer);
	}

	public static boolean Search(int[] line, int length) {
		ArrayList<Type> list = new ArrayList<Type>();
		list.add(new Type(line[0], 1));
		int index = 0;
		for (int i = 1; i < line.length; i++)
			if (list.get(index).value == line[i])
				list.get(index).count++;
			else {
				list.add(new Type(line[i], 1));
				index++;
			}
		for (int i = 1; i < list.size(); i++) {
			Type prev = list.get(i - 1);
			Type cur = list.get(i);
			if (Math.abs(prev.value - cur.value) == 1) {
				if (prev.value < cur.value) {
					if (prev.count < length)
						return false;
					else
						prev.count -= length;
				} else {
					if (cur.count < length)
						return false;
					else
						cur.count -= length;
				}
			} else
				return false;
		}
		return true;
	}
}

class Type {
	int value;
	int count;

	public Type(int _value, int _count) {
		this.value = _value;
		this.count = _count;
	}
}
