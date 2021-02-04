package SWEA1218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {

	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input1219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스별
		for (int t = 1; t <= 10; t++) {
			stack.clear(); 											//스택 클리어
			int N = Integer.parseInt(br.readLine());
			char[] st = br.readLine().toCharArray();

			int ans = 0;
			int break_temp = 0;
			for (int i = 0; i < N; i++) {
				if (break_temp == 1) {
					break;
				}
				if (st[i] == '(' || st[i] == '<' || st[i] == '[' || st[i] == '{') {
					stack.push(st[i]);
				} else {
					switch (stack.peek()) {
					case ('('):
						if (st[i] == ')')
							stack.pop();
						else {
							break_temp = 1;
						}
						break;
					case ('<'):
						if (st[i] == '>')
							stack.pop();
						else {
							break_temp = 1;
						}
						break;
					case ('['):
						if (st[i] == ']')
							stack.pop();
						else {
							break_temp = 1;
						}
						break;
					case ('{'):
						if (st[i] == '}')
							stack.pop();
						else {
							break_temp = 1;
						}
						break;
					}
				}

			}
			if (stack.empty() == true) {
				ans = 1;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
