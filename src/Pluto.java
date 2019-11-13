import java.util.Arrays;

public class Pluto {

  private PlutoObstacles[][] grid;
  private int height;
  private int width;

  public Pluto(int height, int width) {
    this.grid = new PlutoObstacles[height][width];
    this.height = height;
    this.width = width;
    for(PlutoObstacles[] row : grid) {
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
    if(inBounds(x,y)) {
      this.grid[y][x] = obstacles;
    } else {
      throw new IllegalArgumentException("Cannot place obstacle out of bounds!");
    }
  }

  private boolean inBounds(int x, int y) {
    return x >= 0 && x < width && y >= 0 && y < height;
  }

  public PlutoObstacles getLocation(int x, int y) {
      return this.grid[y % height][x % height];
  }
}
