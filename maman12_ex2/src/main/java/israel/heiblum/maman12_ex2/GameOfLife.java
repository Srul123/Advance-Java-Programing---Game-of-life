package israel.heiblum.maman12_ex2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;


/**
 * @ Maman 12 - EX2
 * @author Israel Heiblum 301823555
 */


public class GameOfLife {
    private final int rows;
    private final int cols;
    private final double width;
    private final double height;
    private int[][] grid;
    private Random random = new Random();
    private final GraphicsContext graphics;

    public GameOfLife(int rows, int cols, GraphicsContext graphics) {
        this.rows = rows;
        this.cols = cols;
        this.width = graphics.getCanvas().getWidth();
        this.height = graphics.getCanvas().getHeight();
        this.graphics = graphics;
        grid = new int[rows][cols];
    }

    public void init() {
        // init the board with random values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextInt(2);
            }
        }
        draw();
    }

    private void draw() {
        // draw the current state board
        int cellSize = (int) (height/10);
        graphics.setFill(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    graphics.setFill(Color.gray(0.5, 0.5));
                    graphics.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    graphics.setFill(Color.GRAY);
                    graphics.fillRect((i * cellSize) + 1, (j * cellSize) + 1, cellSize - 2, cellSize - 2);
                } else {
                    graphics.setFill(Color.gray(0.5, 0.5));
                    graphics.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    graphics.setFill(Color.WHITE);
                    graphics.fillRect((i * cellSize) + 1, (j * cellSize) + 1, cellSize - 2, cellSize - 2);
                }
            }
        }
    }

    public void nextStep() {
        // calculate the next generation
        int[][] next = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = countAliveNeighbors(i, j);

                if (neighbors == 3) {
                    next[i][j] = 1;
                } else if (neighbors < 2 || neighbors > 3) {
                    next[i][j] = 0;
                } else {
                    next[i][j] = grid[i][j];
                }
            }
        }
        grid = next;
        draw();
    }

    private int countAliveNeighbors(int i, int j) {
        // count for a cell how many lives neighbors exist
        int sum = 0;
        int iStart = i == 0 ? 0 : -1;
        int iEndInclusive = i == grid.length - 1 ? 0 : 1;
        int jStart = j == 0 ? 0 : -1;
        int jEndInclusive = j == grid[0].length - 1 ? 0 : 1;

        for (int k = iStart; k <= iEndInclusive; k++) {
            for (int l = jStart; l <= jEndInclusive; l++) {
                sum += grid[i + k][l + j];
            }
        }
        sum -= grid[i][j];

        return sum;
    }
}
