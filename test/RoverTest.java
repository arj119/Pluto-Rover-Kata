import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class RoverTest {

  @Test
  public void plutoHasHeightAndWidthInitialisedTo() {
    Pluto pluto = new Pluto(2,3);
    assertEquals(pluto.getHeight(), 2);
    assertEquals(pluto.getWidth(), 3);
  }
  @Test
  public void roverIsInitiallyFacingNorthAtOrigin() {
    Pluto pluto = new Pluto(5, 5);
    Rover rover = new Rover(pluto);

    assertEquals(rover.getPosition(), new Coordinate(0, 0));
    assertEquals(rover.getBearing(), Bearing.NORTH);
  }


}
