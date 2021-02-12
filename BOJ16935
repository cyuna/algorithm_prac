import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력을 위한 것들

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());// 행렬 사이즈 입력 받음 N*M
		int K = Integer.parseInt(st.nextToken());// 연산 수 입력 받음
		//int K = 1;
		map = new int[N][M]; // 행렬 변수 선언
		Queue<Integer> Order = new LinkedList<>();
		for (int i = 0; i < N; i++) { // 행렬의 값들을 입력 받음
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {// 해야하는 연산을 입력 받음
			Order.offer(Integer.parseInt((st.nextToken())));
		}

		while (!Order.isEmpty()) { // 입력받은 연산만큼 진행
			int orderTemp = Order.poll();
			switch (orderTemp) {
			case (1): // 상하반전
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M; j++) {
						int temp = 0;
						temp = map[i][j];
						map[i][j] = map[N - i - 1][j];
						map[N - i - 1][j] = temp;
					}
				}
				break;
			case (2): // 좌우반전
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M / 2; j++) {
						int temp = 0;
						temp = map[i][j];
						map[i][j] = map[i][M - j - 1];
						map[i][M - j - 1] = temp;
					}
				}
				break;
			case (3):
				int[][] temp = new int[M][N]; // 오른쪽으로 90도 회전
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						temp[j][N - i - 1] = map[i][j];
					}
				}
				int temp_n = N;
				N = M;
				M = temp_n;
				map = new int[N][M];
				map = temp;
				break;
			case (4):
				temp = new int[M][N]; // 왼쪽으로 90도 회전
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						temp[M - j - 1][i] = map[i][j];
					}
				}
				temp_n = N; // map 의 사이즈가 변하기 때문에 M,N 을 바꿔주고 새로 map을 만들어줌
				N = M;
				M = temp_n;
				map = new int[N][M];
				map = temp;
				break;
			case (5):
				temp = new int[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (i < N / 2 && j < M / 2) { // 1->2
							temp[i][j + M / 2] = map[i][j];
						} else if (i < N / 2 && j >= M / 2) { // 2->3
							temp[i + N / 2][j] = map[i][j];
						} else if (i >= N / 2 && j >= M / 2) { // 3->4
							temp[i][j - M / 2] = map[i][j];
						} else if (i >= N / 2 && j < M / 2) { // 4->1
							temp[i - N / 2][j] = map[i][j];
						}
					}
				}
				map = temp;
				break;
			case (6):
				temp = new int[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (i < N / 2 && j < M / 2) { // 1->4
							temp[i + N / 2][j] = map[i][j];
						} else if (i < N / 2 && j >= M / 2) { // 2->1
							temp[i][-M / 2 + j ] = map[i][j];
						} else if (i >= N / 2 && j >= M / 2) { // 3->2
							temp[-N / 2 + i][j] = map[i][j];
						} else if (i >= N / 2 && j < M / 2) { // 4->3
							temp[i][j + M / 2] = map[i][j];
						}
					}
				}
				map = temp;
				break;
			}
		}

		for (int i = 0; i < N; i++) { // 결과를 출력
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
