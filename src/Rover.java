public class Rover {

  private Coordinate currentLocation;
  private Pluto pluto;
  private Bearing bearing;

  public Rover(Pluto pluto) {
    this.pluto = pluto;
    this.currentLocation = new Coordinate(0,0);
    this.bearing = Bearing.NORTH;
  }

  public Coordinate getPosition() {
    return this.currentLocation;
  }

  public Bearing getBearing() {
    return this.bearing;
  }
}

