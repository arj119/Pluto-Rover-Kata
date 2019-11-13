public class Coordinate {

  public int x;
  public int y;


  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Coordinate)  {
      Coordinate other = (Coordinate) obj;
      return this.y == other.y && this.x == other.x;
    }
    return false;
  }
}
