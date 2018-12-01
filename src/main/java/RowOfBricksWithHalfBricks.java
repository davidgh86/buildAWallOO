import Exceptions.IncorrectNumberOfBricksException;

import java.util.ArrayList;
import java.util.List;

public class RowOfBricksWithHalfBricks extends RowOfBricks {

    RowOfBricksWithHalfBricks(int numberOfBricks) throws IncorrectNumberOfBricksException {
        super(numberOfBricks);
    }

    @Override
    public void buildRow(int numberOfBricks) throws IncorrectNumberOfBricksException {
        bricks = new ArrayList<>();
        bricks.add(Brick.FIRST_HALF_BRICK);
        if (numberOfBricks == 1){
            bricks.add(Brick.HALF_BRICK_WITHOUT_MORTER);
        }
        else {
            addRemainingBricks(numberOfBricks);
        }
    }

    private void addRemainingBricks(int numberOfBricks) throws IncorrectNumberOfBricksException {
        addCompleteBricks(numberOfBricks);
        bricks.add(Brick.LAST_HALF_BRICK);
    }

    private void addCompleteBricks(int numberOfBricks) throws IncorrectNumberOfBricksException {
        RowOfBricks rowOfBricksWithOnlyCompleteBricks =
                new RowOfBricksWithOnlyCompleteBricks(numberOfBricks - 1);
        List<Brick> listOfBricksThatAreComplete = rowOfBricksWithOnlyCompleteBricks.getBricks();
        bricks.addAll(listOfBricksThatAreComplete);
    }
}
