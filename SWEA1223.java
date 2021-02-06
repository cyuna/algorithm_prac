
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10; // 테스트 케이스

		for (int t = 1; t <= T; t++) {
			save.clear(); // 후위표기식을 저장할 스택 초기화
			int Size = Integer.parseInt(br.readLine()); // 테스트 케이스의 길이
			String str = br.readLine(); // 수식을 입력 받음

			String postfix = new String(); // 후위표기식을 저장할 스트링
			Stack<Character> stack = new Stack<Character>(); // 후위표기식 생성에서 +,*를 잠시 저장할 스택
			for (int i = 0; i < Size; i++) { // 후위 표기식
				char temp = str.charAt(i); // 수식을 앞에서부터 읽어옴( 0-9사이의 정수)
				if (temp == '+') { // +면 스택에 있는 것들을 전부 후위 표기식에 추가해주고 temp를 스택에 push함
					while (!stack.isEmpty()) {
						postfix += stack.pop();
					}
					stack.push(temp);
				} else if (temp == '*') { // *면 덧셈보다 우선순위가 높기 때문에 stack에 push함
					stack.push(temp);
				} else { // 숫자면 표기식에 바로 추가
					postfix += temp;
				}
			}
			while (!stack.isEmpty()) { // 마지막에 남은 수식을 전부 후위표기식에 pop해줌
				postfix += stack.pop();
			}

			// System.out.println(postfix); //후위 표기식 확인

			// 후위표기식 계산
			Stack<Integer> cal = new Stack<Integer>(); // 계산 과정에서 사용될 stack
			for (int i = 0; i < Size; i++) {
				char temp = postfix.charAt(i);
				if (temp == '+') // +일 경우
				{
					cal.push(cal.pop() + cal.pop());
				} else if (temp == '*') { // *인 경우
					cal.push(cal.pop() * cal.pop());
				} else {
					cal.push(temp - '0');
				} // 숫자인 경우
			}
			System.out.println("#" + t + " " + cal.peek());
		}
	}
}
