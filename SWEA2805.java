package SWEA2805;

import java.util.Scanner;
import java.io.FileInputStream;

class SWEA2805 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("input2805.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;

			int size = sc.nextInt(); // 농장의 크기를 입력 받음, size는 홀수
			int[][] map = new int[size][size];
			sc.nextLine();
			for (int i = 0; i < size; i++) { // 농장의 수익 입력받음
				char[] temp = sc.nextLine().toCharArray();
				for (int j = 0; j < size; j++) {
					map[i][j] = temp[j] - 48;
				}
			}
			// 마름모만 가능

			int x = size / 2; // 인덱스는 0 부터라서 +1을 하지 않음 
			int temp_y_size = size; //
			int y_lower = 0;
			for (int level = 0; level < size / 2 + 1; level++) {
				int x_temp = x - level;

				for (int y = y_lower; y < temp_y_size; y++) {
					ans += map[x_temp][y];
				}
				if (level != 0) { //가운데 줄은 1번만 시행
					x_temp = x + level;
					for (int y = y_lower; y < temp_y_size; y++) {
						ans += map[x_temp][y];
					}
				}
				temp_y_size--;
				y_lower++;
			}

			System.out.println("#" + test_case + " " + ans);// 결과 출력
		}
		sc.close();
	}
}
