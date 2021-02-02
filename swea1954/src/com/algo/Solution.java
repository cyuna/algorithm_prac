package com.algo;

import java.io.FileInputStream;
import java.util.Scanner;

//swea 1954 달팽이 숫자
public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트케이스 개수 입력
		for (int t = 1; t <= T; t++) {
			int size = sc.nextInt(); // 달팽이의 크기를 입력
			int[][] map = new int[size][size];

			// 달팽이 알고리즘 구현
			int dir = 1;
			int x = 0;
			int y = 0;
			for (int k = 1; k <= size * size; k++) {
				map[y][x] = k; //배열에 숫자 입력(k를 이용하여 카운트함)
				
				switch (dir) { //dir 1 오른쪽 / 2 아래 / 3 위 / 4 왼쪽
				case (1):
					x = x + 1;//오른쪽으로 이동
					if (x + 1 >= size || map[y][x + 1] != 0) { //다음 오른쪽 칸의 유효성과 다른 숫자와 충돌을 확인함 오른쪽이 막히면 아래로 방향을 튼다.
						dir = 2;
					}
					break;
				case (2): 
					y = y + 1;//아래로 한칸 이동
					if (y + 1 >= size || map[y + 1][x] != 0) {
						dir = 4;
					}				
					break;
				case (3):
					y = y - 1;
					if (y - 1 <0 || map[y - 1][x] != 0) {
						dir = 1;
					}	
					break;
				case (4):
					x = x - 1;
					if (x - 1 < 0 || map[y][x - 1] != 0) {
						dir = 3;
					}
					break;
				}
				

			
			}

			System.out.println("#" + t); // 정답 출력
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
