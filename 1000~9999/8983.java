package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사냥터에서 동물을 사냥하려고 한다.
 * 사냥은 지정된 사대에서만 사격이 가능하다.
 * 이 때, 사냥꾼의 총의 사정거리가 L일 때 L보다 작거나 같은 위치의 동물만 잡을 수 있다.
 * 사대와 동물 사이의 거리는 abs(동물의 x좌표 - 사대의 위치) + 동물의 y좌표로 구할 수 있다.
 * 사대와 동물들의 위치가 주어질 때, 잡을 수 있는 동물의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 사대와 동물의 위치를 저장한다.
	 * 동물을 기준으로 사냥할 수 있는 사대를 찾는다.
	 * Bird를 만들지 않고 입력으로 받자마자 사대와의 거리를 측정하는게 더 빠르다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] location = new int[m];
		for (int i = 0; i < m; i++)
			location[i] = Integer.parseInt(st.nextToken());
		Animal[] animals = new Animal[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			animals[i] = new Animal(x, y);
		}
		Arrays.sort(location);
		int answer = 0;
		// 잡을 수 있는 동물의 수를 구한다.
		for (Animal animal : animals) {
			// 동물의 y좌표가 사정거리보다 길면 무조건 사냥하지 못한다.
			if (animal.y > l)
				continue;
			// 이분 탐색으로 사냥할 수 있는 사대를 찾는다.
			int left = 0, right = m - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				// 사냥할 수 있다면 answer++ 후 while문을 종료한다.
				if (Math.abs(location[mid] - animal.x) + animal.y <= l) {
					answer++;
					break;
				}
				if (location[mid] > animal.x)
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		System.out.println(answer);
	}
}

class Animal {
	int x, y;

	public Animal(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public String toString() {
		return x + " " + y;
	}
}