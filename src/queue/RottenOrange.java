package queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
	public final static int R = 3;
	public final static int C = 5;

	// structure for storing coordinates of the cell
	static class Ele {
		int x = 0;
		int y = 0;

		Ele(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean isDelim(Ele t) {
		return (t.x == -1 && t.y == -1);
	}

	public static boolean checkFill(int arr[][]) {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int ans = rotoranges(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("Time required for all oranges to rot = " + ans);
	}

	private static int rotoranges(int[][] arr) {

		Queue<Ele> que = new LinkedList();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 2) {
					que.add(new Ele(i, j));
				}
			}
		}
		que.add(new Ele(-1, -1));

		boolean flag = false;
		int ans = 0;

		while (!que.isEmpty()) {
			flag = false;
			while (!isDelim(que.peek())) {
				Ele temp = que.peek();

				// Left checking
				if ((temp.x - 1) >= 0 && arr[temp.x - 1][temp.y] != 2) {
					arr[temp.x-1][temp.y ] = 2;
					if (!flag) {

						ans++;
						que.add(new Ele(temp.x - 1, temp.y));
					}
				}
				// right
				if ((temp.x + 1) < R && arr[temp.x + 1][temp.y] != 2) {
					arr[temp.x+1][temp.y ] = 2;
					if (!flag) {
						flag = true;
						ans++;
						que.add(new Ele(temp.x + 1, temp.y));
					}

				}
				// up
				if ((temp.y - 1) >= 0 && arr[temp.x][temp.y - 1] != 2) {
					arr[temp.x][temp.y - 1] = 2;
					if (!flag) {
						flag = true;
						ans++;
						que.add(new Ele(temp.x, temp.y - 1));
					}
				}
				// down
				if ((temp.y + 1) < C && arr[temp.x][temp.y + 1] != 2) {
					arr[temp.x][temp.y + 1] = 2;
					if (!flag) {
						flag = true;
						ans++;
						que.add(new Ele(temp.x, temp.y + 1));
					}
				}
				que.remove();
			}
			que.remove();

			if (!que.isEmpty())
				que.add(new Ele(-1, -1));

		}
		return checkFill(arr) ? -1 : ans;

	}
}
