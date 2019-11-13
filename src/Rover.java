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
    int newX = currentLocation.x;
    int newY = currentLocation.y;
    switch (this.bearing) {
      case NORTH:
        newY = (currentLocation.y + steps) % plutoHeight;
        break;
      case EAST:
        newX = (currentLocation.x + steps) % plutoWidth;
        break;
      case SOUTH:
        newY = (currentLocation.y - steps) % plutoHeight;
        break;
      case WEST:
        newX = (currentLocation.x - steps) % plutoWidth;
        break;
    }

    PlutoObstacles obstacle = pluto.getLocation(newX, newY);
    if (obstacle != PlutoObstacles.EMPTY) {
      obstacleEncountered(obstacle);
    } else {
      this.currentLocation.x = newX;
      this.currentLocation.y = newY;
    }
  }

  private void rotate90(int direction) {
    Bearing[] values = Bearing.values();
    int bearingIndex = this.bearing.ordinal();
    int newIndex = (bearingIndex + direction + values.length) % values.length;
    this.bearing = values[newIndex];
  }

  private void obstacleEncountered(PlutoObstacles obstacle) {
    System.out.println("Encountered " + obstacle + " cannot move " + bearing + " "
        + "from my position " + currentLocation.toString());
  }
}
