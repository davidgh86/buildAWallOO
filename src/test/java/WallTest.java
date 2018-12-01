import Exceptions.IncorrectNumberOfBricksException;
import Exceptions.IncorrectNumberOfRowsException;
import Exceptions.MaximumNumberOfBricksExceded;
import org.junit.Test;

public class WallTest {


    public static final String EXPECTED_RESULT_10_7 =
            "■|■■|■■|■■|■■|■■|■■|■\n" +
            "■■|■■|■■|■■|■■|■■|■■\n" +
            "■|■■|■■|■■|■■|■■|■■|■\n" +
            "■■|■■|■■|■■|■■|■■|■■\n" +
            "■|■■|■■|■■|■■|■■|■■|■\n" +
            "■■|■■|■■|■■|■■|■■|■■\n" +
            "■|■■|■■|■■|■■|■■|■■|■\n" +
            "■■|■■|■■|■■|■■|■■|■■\n" +
            "■|■■|■■|■■|■■|■■|■■|■\n" +
            "■■|■■|■■|■■|■■|■■|■■";

    public static final String EXPECTED_RESULT_10_1 =
            "■|■\n" +
            "■■\n" +
            "■|■\n" +
            "■■\n" +
            "■|■\n" +
            "■■\n" +
            "■|■\n" +
            "■■\n" +
            "■|■\n" +
            "■■";

    @Test(expected = IncorrectNumberOfRowsException.class)
    public void WallCreationWrongNumberOfRows() throws IncorrectNumberOfBricksException, IncorrectNumberOfRowsException,
            MaximumNumberOfBricksExceded {
        new Wall(-1, 5);
    }

    @Test(expected = IncorrectNumberOfBricksException.class)
    public void WallCreationWrongNumberOfBricksPerRows() throws IncorrectNumberOfBricksException,
            IncorrectNumberOfRowsException, MaximumNumberOfBricksExceded {
        new Wall(6, 0);
    }

    @Test
    public void WallCreationCorrectWall() throws IncorrectNumberOfBricksException, IncorrectNumberOfRowsException,
            MaximumNumberOfBricksExceded {
        Wall wall = new Wall(10, 7);
        String stringResult = wall.toString();
        assert (EXPECTED_RESULT_10_7.equals(stringResult));
    }

    @Test
    public void WallCreationCorrectWallOneBrickPerWall() throws IncorrectNumberOfBricksException, IncorrectNumberOfRowsException,
            MaximumNumberOfBricksExceded {
        Wall wall = new Wall(10, 1);
        String stringResult = wall.toString();
        assert (EXPECTED_RESULT_10_1.equals(stringResult));
    }

    @Test(expected = MaximumNumberOfBricksExceded.class)
    public void WallCreationMaximumNumberOfBricksExceded()
            throws IncorrectNumberOfBricksException, IncorrectNumberOfRowsException, MaximumNumberOfBricksExceded {
        new Wall(1000, 7);
    }

}
