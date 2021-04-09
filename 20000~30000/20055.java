package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * ���̰� N�� �����̾� ��Ʈ�� �ְ� ���̰� 2N�� ��Ʈ�� ���Ʒ��� ���θ� ���� ���� ��
 * �κ��� �÷� �ݴ������� �̵����ѷ��� �Ѵ�.
 * �κ��� �ű�� ������ ������ ���� ��, ����Ǵ� ������ �� ��° �ܰ����� ���ϴ� ����
 * 1.��Ʈ�� �� ĭ ȸ���Ѵ�.
 * 2.���� ���� ��Ʈ�� �ö󰣷κ�����, ��Ʈ�� ȸ���ϴ� �������� �� ĭ �̵��� �� �ִٸ� �̵��Ѵ�. ���� �̵��� �� ���ٸ� ������ �ִ´�.
 * 	-�κ��� �̵��ϱ� ���ؼ����̵��Ϸ��� ĭ�� �κ��� ������, �� ĭ�� �������� 1 �̻� ���� �־�� �Ѵ�.
 * 3.�ö󰡴� ��ġ�� �κ��� ���ٸ� �κ��� �ϳ� �ø���.
 * 4.�������� 0�� ĭ�� ������ K�� �̻��̶�� ������ �����Ѵ�. �׷��� �ʴٸ� 1������ ���ư���.
 * ���� ó�� ����Ǵ� �ܰ�� 1�ܰ� �̴�.
 * @author Rave
 */
public class Main {

	static ArrayList<Integer> conveyorBelt = new ArrayList<Integer>();
	static ArrayList<Boolean> robot = new ArrayList<Boolean>();
	static int n;
	static int answer = 1;
	static int zeroCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * n; i++) {
			conveyorBelt.add(Integer.parseInt(st.nextToken()));
			robot.add(false);
		}
		while (true) {
			Rotation();
			RobotMove();
			RaiseRobot();
			// �������� 0�� ĭ�� ������ K�� �̻��̸� ����
			if (zeroCnt >= k)
				break;
			answer++;
		}
		System.out.println(answer);
	}

	/**
	 * �����̾� ��Ʈ�� �ð�������� 1�� ȸ���Ѵ�.
	 */
	public static void Rotation() {
		conveyorBelt.add(0, conveyorBelt.remove(2 * n - 1));
		robot.add(0, robot.remove(2 * n - 1));
	}

	/**
	 * n-1���� 0������ �κ��� �ִٸ� �κ��� ��ĭ �ð� �������� �̵���Ų��. ��, �̵���Ű�� ĭ���� �κ��� ���� �������� 1 �̻��̾�� �Ѵ�.
	 */
	public static void RobotMove() {
		for (int i = n - 1; i >= 0; i--) {
			if (!robot.get(i)) // �κ��� ���ٸ� �Ѿ��.
				continue;
			if (i == n - 1) // n-1��°�� �κ��� ������ ������.
				robot.set(i, false);
			else if (!robot.get(i + 1) && conveyorBelt.get(i + 1) > 0) {
				robot.set(i, false);
				if (i + 1 != n - 1) // �κ��� �̵��� ĭ�� n-1�̸� �ٷ� �κ��� ���� true�� ������ �ʴ´�.
					robot.set(i + 1, true);
				conveyorBelt.set(i + 1, conveyorBelt.get(i + 1) - 1); // �κ��� �̵��� ĭ�� ������ 1 ����
				if (conveyorBelt.get(i + 1) == 0)
					zeroCnt++;
			}
		}
	}

	/**
	 * 0��° �ε����� �κ��� ���� �������� 1 �̻��̶�� �κ��� �ø���.
	 */
	public static void RaiseRobot() {
		if (!robot.get(0) && conveyorBelt.get(0) > 0) {
			robot.set(0, true);
			conveyorBelt.set(0, conveyorBelt.get(0) - 1);
			if (conveyorBelt.get(0) == 0)
				zeroCnt++;
		}
	}
}