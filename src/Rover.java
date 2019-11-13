public class Rover {

  private Coordinate currentLocation;
  private Pluto pluto;
  private Bearing bearing;

  public Rover(Pluto pluto) {
    this.pluto = pluto;
    this.currentLocation = new Coordinate(0, 0);
    this.bearing = Bearing.NORTH;
  }

  public Coordinate getPosition() {
    return this.currentLocation;
  }

  public Bearing getBearing() {
    return this.bearing;
  }

  public void executeCommand(String command) {
    for (char c : command.toCharArray()) {
      switch (c) {
        case 'F':
          move(1);
          break;
        case 'B':
          move(-1);
          break;
        case 'L':
          rotate90(-1);
          break;
        case 'R':
          rotate90(1);
          break;
      }
    }
  }

  private void move(int steps) {
    int plutoHeight = pluto.getHeight();
    int plutoWidth = pluto.getWidth();
    switch(this.bearing) {
      case NORTH:
        currentLocation.y = (currentLocation.y + steps) % plutoHeight;
        break;
      case EAST:
        currentLocation.x = (currentLocation.x + steps) % plutoWidth;
        break;
      case SOUTH:
        currentLocation.y = (currentLocation.y - steps) % plutoHeight;
        break;
      case WEST:
        currentLocation.x = (currentLocation.x - steps) % plutoWidth;
        break;
    }
  }

  private void rotate90(int direction) {
    Bearing[] values = Bearing.values();
    int bearingIndex = this.bearing.ordinal();
    int newIndex = (bearingIndex + direction + values.length) % values.length;
    this.bearing = values[newIndex];
  }
}
