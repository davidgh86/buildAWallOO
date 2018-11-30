import Exceptions.IncorrectNumberOfBricksException;

import java.util.ArrayList;
import java.util.List;

public abstract class RowOfBricks {

    RowOfBricks(int numberOfBricks) throws IncorrectNumberOfBricksException {
        checkNumberOfBricks(numberOfBricks);
        bricks = new ArrayList<>();
        buildRow(numberOfBricks);
    }

    private void checkNumberOfBricks(int numberOfBricks) throws IncorrectNumberOfBricksException {
        if (numberOfBricks <1){
            throw new IncorrectNumberOfBricksException();
        }
    }

    List<Brick> bricks;

    public List<Brick> getBricks(){
        return this.bricks;
    }

    public abstract void buildRow(int numberOfBricks) throws IncorrectNumberOfBricksException;

    @Override
    public String toString() {
        String result = "";
        for(Brick brick : bricks ){
            result += brick.toString();
        }
        return result;
    }
}
