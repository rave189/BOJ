package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 도현이네 반 학생들을 주어진 조건에 맞게 정렬하는 문제
 * 조건은 다음과 같다.
 * 1.국어 점수가 감소하는 순서로
 * 2.국어 점수가 같으면 영어 점수가 증가하는 순서로
 * 3.국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 * 4.모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
 *   (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
 * 정렬을 완료한 후에 학생들의 이름을 출력한다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Student> pq = new PriorityQueue<>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			pq.add(new Student(name, korean, english, math));
		}
		while (!pq.isEmpty())
			sb.append(pq.poll().name + "\n");
		System.out.print(sb);
	}
}

class Student implements Comparable<Student> {
	String name;
	int korean, math, english;

	public Student(String _name, int _korean, int _english, int _math) {
		this.name = _name;
		this.korean = _korean;
		this.english = _english;
		this.math = _math;
	}

	@Override
	public int compareTo(Student o) {
		if (korean > o.korean)
			return -1;
		else if (korean == o.korean) {
			if (english < o.english)
				return -1;
			else if (english == o.english) {
				if (math > o.math)
					return -1;
				else if (math == o.math)
					return name.compareTo(o.name);
			}
		}
		return 1;
	}
}