package misha.Test;

public class Tack {
    public static void main(String[] args) {
        int[][] mass = {{0, 0, 1},
                        {0, 0, 0},
                        {1, 0, 1},
                        {1, 0, 1}};

        int [] mass2 = {1,1,1,1,0,1,0,0,1,1,0};
        Tack tack = new Tack();
        System.out.println(tack.findeMax(mass2));
       // System.out.println(massforTest(mass));
    }

    public static int massforTest(int[][] grid) {

     int cout = 0;
     int rows = grid.length;
     int cols = grid[0].length;


        for (int i = 0; i<rows; i++) {
            for (int j = 0; j <cols ; j++) {
                if(grid[i][j]==1){
                dfs(grid, i, j);
                cout++;
                }
            }
        }
    return cout;
    }
    public static void dfs(int grid[][], int row, int col){
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1) {
            return;
        }

        // Помечаем текущую ячейку, чтобы не посещать ее снова
        grid[row][col] = -1;

        // Рекурсивно запускаем DFS для соседних ячеек
        dfs(grid, row - 1, col); // Верхняя ячейка
        dfs(grid, row + 1, col); // Нижняя ячейка
        dfs(grid, row, col - 1); // Левая ячейка
        dfs(grid, row, col + 1); // Правая ячейка
        dfs(grid, row - 1, col-1);
        dfs(grid, row - 1, col+1);
        dfs(grid, row + 1, col-1);
        dfs(grid, row + 1, col+1);
    }

    public int findeMax(int mass[]){
        int count = 0;
        int max = 0;


        for (int i = 0; i <mass.length; i++) {
            if (mass[i]==1){
                count++;

            }else{
                count =0;
                System.out.println("fuck");

            }
            max = Math.max(count, max);
        }
        return max;
    }
}
