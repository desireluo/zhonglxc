import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {


    static int n;
    static int m;

    static int p;
    static int q;

    static int minStep = -1;

    static int[][] map;

    static boolean[][] used;

    static int[][] waypoint = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入图的行和列");

        n = scanner.nextInt();
        m = scanner.nextInt();

        System.out.println("输入开始点的坐标");

        int startx = scanner.nextInt();

        int starty = scanner.nextInt();


        System.out.println("输入终点的坐标");

        p = scanner.nextInt();

        q = scanner.nextInt();

        System.out.println("输入图数据");


        map = new int[n][m];
        used = new boolean[n][m];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                map[i][j] = scanner.nextInt();

            }

        }

        used[startx][starty] = true;


        dfsMap(startx, starty, 0);

        System.out.println(Arrays.deepToString(map));
        System.out.println(minStep);

    }


    static void dfsMap(int x, int y, int step) {

        if (x == p && y == q) {

            minStep = Math.max(minStep, step);

        } else {

            for (int loop = 0; loop < 4; loop++) {

                int gx = x + waypoint[loop][0];
                int gy = y + waypoint[loop][1];

                if(gx < 0 || gy < 0 || gx>=n || gy >= m) {
                    continue;
                }

                if(map[gx][gy] == 1 || used[gx][gy]) {
                    continue;
                }

                used[gx][gy] = true;
                dfsMap(gx, gy, step + 1);

                used[gx][gy] = false;
            }

        }


    }
}
