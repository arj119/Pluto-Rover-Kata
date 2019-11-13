import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class RoverTest {

  private Pluto pluto = new Pluto(5, 5);
  private Rover rover = new Rover(pluto);

  @Test
  public void plutoHasHeightAndWidthInitialisedTo() {
    Pluto pluto2 = new Pluto(2, 3);
    assertEquals(pluto2.getHeight(), 2);
    assertEquals(pluto2.getWidth(), 3);
  }

  @Test
  public void roverIsInitiallyFacingNorthAtOrigin() {
    assertEquals(rover.getPosition(), new Coordinate(0, 0));
    assertEquals(rover.getBearing(), Bearing.NORTH);
  }

  @Test
  public void roverRotatesWellWithCommand() {
    rover.executeCommand("R");
    assertEquals(rover.getBearing(), Bearing.EAST);
    rover.executeCommand("R");
    assertEquals(rover.getBearing(), Bearing.SOUTH);
    rover.executeCommand("R");
    assertEquals(rover.getBearing(), Bearing.WEST);
    rover.executeCommand("R");
    assertEquals(rover.getBearing(), Bearing.NORTH);
    rover.executeCommand("L");
    assertEquals(rover.getBearing(), Bearing.WEST);
    rover.executeCommand("L");
    assertEquals(rover.getBearing(), Bearing.SOUTH);
    rover.executeCommand("L");
    assertEquals(rover.getBearing(), Bearing.EAST);
    rover.executeCommand("L");
    assertEquals(rover.getBearing(), Bearing.NORTH);
  }

  @Test
  public void roverMovesForwardWithBearingCorrectly() {
    rover.executeCommand("FFR");
    assertEquals(rover.getPosition(), new Coordinate(0, 2));
    rover.executeCommand("FFR");
    assertEquals(rover.getPosition(), new Coordinate(2, 2));
    rover.executeCommand("FR");
    assertEquals(rover.getPosition(), new Coordinate(2, 1));
    rover.executeCommand("FR");
    assertEquals(rover.getPosition(), new Coordinate(1, 1));
  }

  @Test
  public void roverWrapsAroundGrid() {
    rover.executeCommand("FF");
    assertEquals(rover.getPosition(), new Coordinate(0, 2));
    for(int i = 0; i < pluto.getHeight(); ++i) {
      rover.executeCommand("F");
    }
    assertEquals(rover.getPosition(), new Coordinate(0, 2));
    rover.executeCommand("R");
    for(int j = 0; j < pluto.getWidth(); ++j) {
      rover.executeCommand("F");
    }
    assertEquals(rover.getPosition(), new Coordinate(0, 2));

  }


}
