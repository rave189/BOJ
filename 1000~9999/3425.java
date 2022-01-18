package BOJ.Day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 새로운 스택인 고스택을 개발하는 문제
 * 고스택은 다음과 같은 기능이 있다.
 * NUM X: X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 109)
 * POP: 스택 가장 위의 숫자를 제거한다.
 * INV: 첫 번째 수의 부호를 바꾼다. (42 -> -42)
 * DUP: 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
 * SWP: 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
 * ADD: 첫 번째 숫자와 두 번째 숫자를 더한다.
 * SUB: 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
 * MUL: 첫 번째 숫자와 두 번째 숫자를 곱한다.
 * DIV: 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
 * MOD: 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
 * 연산을 수행할 때에는 숫자가 부족해서 연산을 수행할 수 없을 때, 0으로 나눴을 때 (DIV, MOD), 연산 결과의 절댓값이 109를 넘어갈 때는 모두 프로그램 에러이다.
 * 음수 나눗셈에 대한 모호함을 피하기 위해 다음과 같이 계산한다.
 * 나눗셈의 피연산자에 음수가 있을 때는, 그 수를 절댓값을 씌운 뒤 계산한다.
 * 그리고 나서 몫과 나머지의 부호는 다음과 같이 결정한다.
 * 피연산자중 음수가 한 개일때는 몫의 부호가 음수이다.
 * 이 경우를 제외하면 몫의 부호는 항상 양수이다.
 * 나머지의 부호는 피제수의 부호와 같다.
 * 따라서, 13 div -4 = -3, -13 mod 4 = -1, -13 mod -4 = -1이다.
 * 프로그램 에러가 발생했을 경우에는, 현재 프로그램의 수행을 멈추고, 그 다음 어떤 명령도 수행하지 않는다.
 */
public class Main {
    static GoStack st = new GoStack();
    static List<String> commandList = new ArrayList<>();

    /**
     * 만드는 건 거의 다 했는데 swap을 잘못만들어서 뭐때문에 틀렸는지 한참 찾음..
     * 결국 대회에서 제공되는 테스트 케이스 보고 잘못된 부분 찾음..
     * 문제 잘 구현해보자...
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while (true) {
            while (true) {
                String command = br.readLine();
                if (command.equals("END"))
                    break;
                else if (command.equals("QUIT")) {
                    System.out.print(answer);
                    return;
                }
                commandList.add(command);
            }
            int testCase = Integer.parseInt(br.readLine());
            while (testCase-- > 0) {
                int n = Integer.parseInt(br.readLine());
                st.clear();
                st.push(n);
                boolean isCompleted = true;
                for (String command : commandList) {
                    try {
                        execute(command);
                    } catch (Exception e) {
                        isCompleted = false;
                        break;
                    }
                }
                isCompleted = isCompleted && st.size() == 1;
                answer.append(isCompleted ? st.pop() : "ERROR").append('\n');
            }
            br.readLine();
            answer.append('\n');
            commandList.clear();
        }
    }

    public static void execute(String command) {
        if (command.contains("NUM"))
            st.push(Integer.parseInt(command.split(" ")[1]));
        else if (command.equals("POP"))
            st.pop();
        else if (command.equals("INV"))
            st.inv();
        else if (command.equals("DUP"))
            st.dup();
        else if (command.equals("SWP"))
            st.swp();
        else if (command.equals("ADD"))
            st.add();
        else if (command.equals("SUB"))
            st.sub();
        else if (command.equals("MUL"))
            st.mul();
        else if (command.equals("DIV"))
            st.div();
        else if (command.equals("MOD"))
            st.mod();
    }
}

class GoStack {
    Stack<Long> st = new Stack<>();
    final int MAX_VALUE = 1000000000;

    void push(long n) {
        st.push(n);
    }

    long pop() {
        return st.pop();
    }

    void inv() {
        st.push(-st.pop());
    }

    void dup() {
        st.push(st.peek());
    }

    void swp() {
        long left = st.pop(), right = st.pop();
        st.push(left);
        st.push(right);
    }

    void add() {
        long left = st.pop(), right = st.pop();
        long result = left + right;
        if (Math.abs(result) > MAX_VALUE)
            throw new RuntimeException();
        st.push(result);
    }

    void sub() {
        long left = st.pop(), right = st.pop();
        long result = right - left;
        if (Math.abs(result) > MAX_VALUE)
            throw new RuntimeException();
        st.push(result);
    }

    void mul() {
        long left = st.pop(), right = st.pop();
        long result = left * right;
        if (Math.abs(result) > MAX_VALUE)
            throw new RuntimeException();
        st.push(result);
    }

    void div() {
        long left = st.pop(), right = st.pop();
        long result = Math.abs(right) / Math.abs(left);
        if ((left < 0 && right > 0) || (left > 0 && right < 0))
            st.push(-result);
        else
            st.push(result);
    }

    void mod() {
        long left = st.pop();
        long right = st.pop();
        long result = Math.abs(right) % Math.abs(left);
        if (right < 0)
            st.push(-result);
        else
            st.push(result);
    }

    int size() {
        return st.size();
    }

    void clear() {
        st.clear();
    }
}
