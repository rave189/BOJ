package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Ʈ���� ������ũ�� ������ ���� 1km���µ� 1L�� ���ᰡ �ʿ��ϴ�.
 * ���������� �������� �����Ҹ� �ּҷ� �湮�Ϸ��� �� ��, ������ �湮Ƚ���� ���ϴ� ����
 * ���������� ���� ���ϸ� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���α׷��ӽ��� Ʈ��������� ����� ����
	 * �� ���� ������?
	 * �з������� ������
	 * �°� �ѰŰ����� ��� Ʋ�Ƚ��ϴ� �����淡 �����þ��µ� while�� ���ǿ� <=���� �����ְ� <�� ���༭ Ʋ�� �ſ���.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<FuelStation> pq = new PriorityQueue<>((v1, v2) -> v1.p - v2.p);
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int location = Integer.parseInt(st.nextToken());
			int fuel = Integer.parseInt(st.nextToken());
			pq.add(new FuelStation(location, fuel));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int destination = Integer.parseInt(st.nextToken());
		int stdFuel = Integer.parseInt(st.nextToken());
		int answer = 0;
		Queue<FuelStation> maxFuelStation = new PriorityQueue<>((v1, v2) -> v2.fuel - v1.fuel);
		while (stdFuel < destination) {
			while (!pq.isEmpty() && pq.peek().p <= stdFuel)
				maxFuelStation.add(pq.poll());
			if (maxFuelStation.isEmpty())
				break;
			FuelStation maxStation = maxFuelStation.poll();
			stdFuel += maxStation.fuel;
			answer++;
		}
		System.out.println(stdFuel >= destination ? answer : -1);
	}
}

class FuelStation {
	int p, fuel;

	public FuelStation(int p, int fuel) {
		this.p = p;
		this.fuel = fuel;
	}
}