import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] timeSave = new int[1001];
		Arrays.fill(timeSave, Integer.MAX_VALUE);
		Queue<Emoticon> q = new LinkedList<>();
		q.add(new Emoticon(0, 0, 1));
		while (!q.isEmpty()) {
			Emoticon cur = q.poll();
			timeSave[cur.emoCnt] = Math.min(timeSave[cur.emoCnt], cur.time);

			if (cur.clipBoard + cur.emoCnt < timeSave.length)
				if (cur.time + 1 < timeSave[cur.clipBoard + cur.emoCnt])
					q.add(new Emoticon(cur.time + 1, cur.clipBoard, cur.clipBoard + cur.emoCnt));

			if (cur.clipBoard != cur.emoCnt)
				q.add(new Emoticon(cur.time + 1, cur.emoCnt, cur.emoCnt));

			if (cur.emoCnt > 1)
				if (cur.time + 1 < timeSave[cur.emoCnt - 1])
					q.add(new Emoticon(cur.time + 1, cur.clipBoard, cur.emoCnt - 1));
		}
		System.out.println(timeSave[n]);
	}
}

class Emoticon {
	int time, clipBoard, emoCnt;

	public Emoticon(int _time, int _clipBoard, int _emoCnt) {
		this.time = _time;
		this.clipBoard = _clipBoard;
		this.emoCnt = _emoCnt;
	}
}
