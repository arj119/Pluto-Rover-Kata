import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class RoverTest {

  @Test
  public void roverIsInitiallyFacingNorthAtOrigin() {
    Pluto pluto = new Pluto(5, 5);
    Rover rover = new Rover(pluto);

    assertEquals(rover.getPosition(), new Coordinate(0, 0));
    assertEquals(rover.getBearing(), Bearing.NORTH);
  }
}
