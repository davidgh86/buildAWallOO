import Exceptions.IncorrectNumberOfBricksException;

import java.util.ArrayList;
import java.util.List;

public class RowOfBricksWithHalfBricks extends RowOfBricks {

    RowOfBricksWithHalfBricks(int numberOfBricks) throws IncorrectNumberOfBricksException {
        super(numberOfBricks);
    }

    @Override
    public void buildRow(int numberOfBricks) throws IncorrectNumberOfBricksException {
        RowOfBricks rowOfBricksWithOnlyCompleteBricks =
                new RowOfBricksWithOnlyCompleteBricks(numberOfBricks-1);
        List<Brick> listOfBricksThatAreComplete = rowOfBricksWithOnlyCompleteBricks.getBricks();
        bricks = new ArrayList<>();
        bricks.add(Brick.FIRST_HALF_BRICK);
        bricks.addAll(listOfBricksThatAreComplete);
        bricks.add(Brick.LAST_HALF_BRICK);
    }
}
