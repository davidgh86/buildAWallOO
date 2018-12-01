import Exceptions.IncorrectNumberOfBricksException;
import Exceptions.IncorrectNumberOfRowsException;
import Exceptions.MaximumNumberOfBricksExceded;

public class Main {

    public static final String TOO_MUCH_BRICKS_MESSAGE = "Naah, too much...here's my resignation.";
    public static final String THE_PARAMETES_MUST_BE_NUMBERS = "The parameters must be numbers";

    public static void main(String[] args) {
        try {
            int numberOfRows = Integer.valueOf(args[0]);
            int numberOfBricksPerRow = Integer.valueOf(args[1]);
            String wallString = buildAWall(numberOfRows, numberOfBricksPerRow);
            System.out.println(wallString);
        }catch (Exception e){
            System.out.println(THE_PARAMETES_MUST_BE_NUMBERS);
        }

    }

    public static String buildAWall(int numberOfRows, int numberOfBricksPerRow){

        try {
            Wall wall = getWall(numberOfRows, numberOfBricksPerRow);
            return wall.toString();
        } catch (MaximumNumberOfBricksExceded maximumNumberOfBricksExceded) {
            return TOO_MUCH_BRICKS_MESSAGE;
        }
    }

    private static Wall getWall(int numberOfRows, int numberOfBricksPerRow) throws MaximumNumberOfBricksExceded {
        Wall wall;
        try {
            wall = new Wall(numberOfRows, numberOfBricksPerRow);
        } catch (IncorrectNumberOfBricksException e) {
            return null;
        } catch (IncorrectNumberOfRowsException e) {
            return null;
        }
        return wall;
    }
}
