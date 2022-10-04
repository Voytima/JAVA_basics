import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class WaveAlgo {
    /*
    В input файле указываем в первой строке количество сеток, во второй строке W - кол-во блоков,
    S - старт, E - финиш
     */
    private static final String FILE_NAME = "Lesson_5/src/input.txt";

    private static List<Position> getNeighbour(Position p, int row, int col) {
        List<Position> neighbours = new ArrayList<>();

        Position posLeft = p.getLeft();
        if (posLeft.row >= 0
                && posLeft.row < row
                && posLeft.col >= 0
                && posLeft.col < col)
            neighbours.add(posLeft);
        Position posRight = p.getRight();
        if (posRight.row >= 0
                && posRight.row < row
                && posRight.col >= 0
                && posRight.col < col)
            neighbours.add(posRight);
        Position posUp = p.getUp();
        if (posUp.row >= 0
                && posUp.row < row
                && posUp.col >= 0
                && posUp.col < col)
            neighbours.add(posUp);
        Position posDown = p.getBottom();
        if (posDown.row >= 0
                && posDown.row < row
                && posDown.col >= 0
                && posDown.col < col)
            neighbours.add(posDown);

        return neighbours;

    }

    public static int getPath(char[][] arr, int row, int col) {
        final int[][] grid = new int[row][col];
        PriorityQueue<Position> queue = new PriorityQueue<Position>(col * row,
                new Comparator<Position>() {

                    @Override
                    public int compare(Position o1, Position o2) {
                        if (grid[o1.row][o1.col] < grid[o2.row][o2.col])
                            return -1;
                        else if (grid[o1.row][o1.col] > grid[o2.row][o2.col])
                            return 1;
                        else
                            return 0;
                    }
                });

        for (int c = 0; c < arr[0].length; c++) {
            if (arr[0][c] == 'S') {
                queue.offer(new Position(0, c));
                grid[0][c] = 0;

            }
        }
        while (!queue.isEmpty()) {

            Position current = queue.poll();
            List<Position> neighbours = getNeighbour(current, row, col);

            for (Position neighbour : neighbours) {

                if (!(arr[neighbour.row][neighbour.col] == 'W')
                        && grid[neighbour.row][neighbour.col] == 0) {

                    grid[neighbour.row][neighbour.col] = grid[current.row][current.col] + 1;
                    queue.offer(neighbour);
                }

                if (arr[neighbour.row][neighbour.col] == 'E')
                    return grid[current.row][current.col] + 1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
            String str;
            if ((str = in.readLine()) != null) {
                for (int loop = 0; loop < Integer.parseInt(str.trim()); ++loop) {
                    String[] input = in.readLine().split("\\s");
                    int row = Integer.parseInt(input[0].trim());
                    int col = Integer.parseInt(input[1].trim());
                    char[][] arr = new char[row][col];
                    for (int i = 2; i < input.length; ++i) {
                        arr[i - 2] = input[i].toCharArray();
                    }
                    System.out.println(getPath(arr, row, col));
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private static void test(char[][] arr, int row, int col) {
        // test
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }

    @SuppressWarnings("unused")
    private static void test(int[][] arr, int row, int col) {
        // test
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }
}

class Position {
    public int row;
    public int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position getLeft() {
        return new Position(row, col - 1);
    }

    public Position getRight() {
        return new Position(row, col + 1);
    }

    public Position getBottom() {
        return new Position(row + 1, col);
    }

    public Position getUp() {
        return new Position(row - 1, col);
    }

    public String toString() {
        return "row:" + row + " col:" + col;
    }
}
