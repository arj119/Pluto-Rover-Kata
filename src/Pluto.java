import java.util.Arrays;
import java.util.Random;

public class Pluto {

  private final Random generator = new Random();

  private PlutoObstacles[][] grid;
  private int height;
  private int width;

  public Pluto(int height, int width) {
    this.grid = new PlutoObstacles[height][width];
    this.height = height;
    this.width = width;
    for (PlutoObstacles[] row : grid) {
      Arrays.fill(row, PlutoObstacles.EMPTY);
    }
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public void addObstacle(int x, int y, PlutoObstacles obstacles) {
      this.grid[Math.abs((y + height) % height)][Math.abs((x + width) % width)] =
          obstacles;
  }

  private boolean inBounds(int x, int y) {
    return x >= 0 && x < width && y >= 0 && y < height;
  }

  public PlutoObstacles getLocation(int x, int y) {
    return this.grid[(y + height) % height][(x + height) % height];
  }

  public void randomObstacleAddition() {
    int numObstacles = generator.nextInt(height * width);
    for (int i = 0; i < numObstacles; ++i) {
      int x = generator.nextInt(width - 1);
      int y = generator.nextInt(height - 1);
      addObstacle(x, y, getRandomObstacle());
    }
  }

  private PlutoObstacles getRandomObstacle() {
    PlutoObstacles[] values = PlutoObstacles.values();
    return values[Math.abs(generator.nextInt()) % values.length];
  }
}
