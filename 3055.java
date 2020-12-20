import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int r = Integer.parseInt(line[0]);
		int c = Integer.parseInt(line[1]);
		int[] drtX = { 0, 0, 1, -1 };
		int[] drtY = { 1, -1, 0, 0 };
		String[][] map = new String[r][c];
		Queue<Point> waterQ = new LinkedList<Point>();
		Queue<Point> animalQ = new LinkedList<Point>();
		Point start = null;
		for (int i = 0; i < r; i++) {
			line = br.readLine().split("");
			for (int j = 0; j < c; j++) {
				map[i][j] = line[j];
				if (line[j].equals("S"))
					start = new Point(i, j);
				else if (line[j].equals("*"))
					waterQ.add(new Point(i, j));
			}
		}
		animalQ.add(start);
		int count = 0;
		while (!animalQ.isEmpty()) {
			count++;
			int waterLength = waterQ.size();
			int animalLength = animalQ.size();
			for (int j = 0; j < waterLength; j++) {
				Point water = waterQ.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = water.x + drtX[i];
					int nextY = water.y + drtY[i];
					if ((0 <= nextX && nextX < r) && (0 <= nextY && nextY < c))
						if (!map[nextX][nextY].equals("D") && !map[nextX][nextY].equals("X")
								&& !map[nextX][nextY].equals("*")) {
							map[nextX][nextY] = "*";
							waterQ.add(new Point(nextX, nextY));
						}
				}
			}
			for (int j = 0; j < animalLength; j++) {
				Point curPoint = animalQ.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = curPoint.x + drtX[i];
					int nextY = curPoint.y + drtY[i];
					if ((0 <= nextX && nextX < r) && (0 <= nextY && nextY < c))
						if (map[nextX][nextY].equals("D")) {
							System.out.println(count);
							return;
						} else if (!map[nextX][nextY].equals("X") && !map[nextX][nextY].equals("*")
								&& !map[nextX][nextY].equals("S")) {
							animalQ.add(new Point(nextX, nextY));
							map[nextX][nextY] = "S";
						}
				}
			}
		}
		System.out.println("KAKTUS");
	}
}

class Point {
	int x;
	int y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public String toString() {
		return x + " " + y;
	}
}
