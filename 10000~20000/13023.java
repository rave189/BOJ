import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static RelationShip[] relationship;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		relationship = new RelationShip[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++)
			relationship[i] = new RelationShip();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int friend_1 = Integer.parseInt(st.nextToken());
			int friend_2 = Integer.parseInt(st.nextToken());
			relationship[friend_1].add(friend_2);
			relationship[friend_2].add(friend_1);
		}
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			BFS(i, 1);
			visited[i] = false;
		}
		System.out.println(0);
	}

	public static void BFS(int next, int visitCnt) {
		if (visitCnt == 5) {
			System.out.println(1);
			System.exit(0);
		}
		LinkedList<Integer> check = relationship[next].friends;
		for (int nextFriend : check)
			if (!visited[nextFriend]) {
				visited[nextFriend] = true;
				BFS(nextFriend, visitCnt + 1);
				visited[nextFriend] = false;
			}
	}
}

class RelationShip {
	LinkedList<Integer> friends;

	public RelationShip() {
		friends = new LinkedList<Integer>();
	}

	public void add(int friend) {
		friends.add(friend);
	}
}
