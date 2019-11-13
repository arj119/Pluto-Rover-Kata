public class Main {

  public static void main(String[] args) {
    Pluto pluto = new Pluto(100, 100);
    Rover rover = new Rover(pluto);
    pluto.randomObstacleAddition();

    rover.executeCommand(args[0]);
  }
}
