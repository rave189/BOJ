package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 길이가 N인 컨베이어 벨트가 있고 길이가 2N인 벨트가 위아래로 감싸며 돌고 있을 때
 * 로봇을 올려 반대편으로 이동시켜려고 한다.
 * 로봇을 옮기는 과정이 다음과 같을 때, 종료되는 시점이 몇 번째 단계인지 구하는 문제
 * 1.벨트가 한 칸 회전한다.
 * 2.가장 먼저 벨트에 올라간로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
 * 	-로봇이 이동하기 위해서는이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
 * 3.올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
 * 4.내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
 * 가장 처음 수행되는 단계는 1단계 이다.
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
			// 내구도가 0인 칸의 개수가 K개 이상이면 종료
			if (zeroCnt >= k)
				break;
			answer++;
		}
		System.out.println(answer);
	}

	/**
	 * 컨베이어 벨트를 시계방향으로 1번 회전한다.
	 */
	public static void Rotation() {
		conveyorBelt.add(0, conveyorBelt.remove(2 * n - 1));
		robot.add(0, robot.remove(2 * n - 1));
	}

	/**
	 * n-1부터 0번까지 로봇이 있다면 로봇을 한칸 시계 방향으로 이동시킨다. 단, 이동시키는 칸에는 로봇이 없고 내구도가 1 이상이어야 한다.
	 */
	public static void RobotMove() {
		for (int i = n - 1; i >= 0; i--) {
			if (!robot.get(i)) // 로봇이 없다면 넘어간다.
				continue;
			if (i == n - 1) // n-1번째의 로봇을 땅으로 내린다.
				robot.set(i, false);
			else if (!robot.get(i + 1) && conveyorBelt.get(i + 1) > 0) {
				robot.set(i, false);
				if (i + 1 != n - 1) // 로봇이 이동한 칸이 n-1이면 바로 로봇을 내려 true로 만들지 않는다.
					robot.set(i + 1, true);
				conveyorBelt.set(i + 1, conveyorBelt.get(i + 1) - 1); // 로봇이 이동한 칸의 내구도 1 감소
				if (conveyorBelt.get(i + 1) == 0)
					zeroCnt++;
			}
		}
	}

	/**
	 * 0번째 인덱스에 로봇이 없고 내구도가 1 이상이라면 로봇을 올린다.
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