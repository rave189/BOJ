package BOJ.Day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N개의 보석이 있다.
 * 각 보석은 M의 무게와 V의 가격를 지닌다.
 * 도둑은 K개의 가방을 가지고 있으며, 각 가방은 C만큼의 무게를 담을 수 있다.
 * 가방에는 보석을 한 개만 넣을 수 있다.
 * 도둑이 가져갈 수 있는 보석의 최대 가격을 구하는 문제
 */
public class Main {

    /**
     * 가방과 보석들을 무게를 기준으로 오름차순으로 정렬한다.
     * 이후 가방의 무게를 보며 가방의 무게보다 적은 보석들을 모두 가격을 기준으로 내림차순 정렬되는 우선순위 큐에 넣는다.
     * 각 가방의 무게보다 적은 보석을 모두 넣었다면 우선순위 큐에서 한 개를 빼 가방에 넣는다.
     * 이를 반복하여 최댓값을 구할 수 있다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Jewel[] jewelries = new Jewel[n];
        int[] bags = new int[k];
        PriorityQueue<Jewel> pq = new PriorityQueue<>((v1, v2) -> v2.value - v1.value);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewel(weight, value);
        }
        for (int i = 0; i < k; i++)
            bags[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bags);
        Arrays.sort(jewelries, Comparator.comparingInt(v -> v.weight));
        long answer = 0;
        for (int i = 0, j = 0; i < k; i++) {
            while (j < n && jewelries[j].weight <= bags[i])
                pq.add(jewelries[j++]);
            if (!pq.isEmpty())
                answer += pq.poll().value;
        }
        System.out.println(answer);
    }
}

class Jewel {
    int weight, value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}