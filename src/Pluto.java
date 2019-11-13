public class Pluto {

  private int[][] grid;
  private int height;
  private int width;

  public Pluto(int height, int width) {
    this.grid = new int[height][width];
    this.height = height;
    this.width = width;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }
}
