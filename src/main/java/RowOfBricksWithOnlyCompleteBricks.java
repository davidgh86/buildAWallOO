import Exceptions.IncorrectNumberOfBricksException;

import java.util.ArrayList;

public class RowOfBricksWithOnlyCompleteBricks extends RowOfBricks {

    RowOfBricksWithOnlyCompleteBricks(int numberOfBricks) throws IncorrectNumberOfBricksException {
        super(numberOfBricks);
    }

    @Override
    public void buildRow(int numberOfBricks) {
        bricks = new ArrayList<>();
        for(int i=numberOfBricks; i>1; i-- ){
            bricks.add(Brick.NORMAL_BRICK);
        }
        bricks.add(Brick.LAST_BRICK_OF_WALL);
    }
}
