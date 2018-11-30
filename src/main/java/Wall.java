import Exceptions.IncorrectNumberOfBricksException;
import Exceptions.IncorrectNumberOfRowsException;
import Exceptions.MaximumNumberOfBricksExceded;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    public static final int MAXIMUM_NUMBER_OF_BRICKS = 1000;
    private List<RowOfBricks> rowsOfBricks;

    Wall(int rows, int bricksPerRow) throws IncorrectNumberOfBricksException,
            IncorrectNumberOfRowsException, MaximumNumberOfBricksExceded {
        checkInput(rows, bricksPerRow);
        buildWall(rows, bricksPerRow);
    }

    private void buildWall(int rows, int bricksPerRow) throws IncorrectNumberOfBricksException {
        rowsOfBricks = new ArrayList<>();
        RowOfBricks rowOfBricksComplete = new RowOfBricksWithOnlyCompleteBricks(bricksPerRow);
        RowOfBricks rowOfBricksWithHalfBricks = new RowOfBricksWithHalfBricks(bricksPerRow);
        zipRowsOfBricks(rows, rowOfBricksComplete, rowOfBricksWithHalfBricks);
    }

    private void checkInput(int rows, int bricksPerRow) throws IncorrectNumberOfRowsException, MaximumNumberOfBricksExceded {
        checkNumberOfRows(rows);
        checkNumberOfBricks(rows, bricksPerRow);
    }

    private void zipRowsOfBricks(int rows, RowOfBricks rowOfBricksComplete, RowOfBricks rowOfBricksWithHalfBricks) {
        RowOfBricks rowOfBricks;
        for (int i = rows; i>0; i--){
            if (isOdd(i)){
                rowOfBricks = rowOfBricksComplete;
            }
            else {
                rowOfBricks = rowOfBricksWithHalfBricks;
            }
            rowsOfBricks.add(rowOfBricks);
        }
    }

    private void checkNumberOfRows(int rows) throws IncorrectNumberOfRowsException {
        if (rows < 1)
            throw new IncorrectNumberOfRowsException();
    }

    private void checkNumberOfBricks(int rows, int bricksPerRow) throws MaximumNumberOfBricksExceded {
        if (rows * bricksPerRow > MAXIMUM_NUMBER_OF_BRICKS)
            throw new MaximumNumberOfBricksExceded();
    }

    private static boolean isOdd(int number) {
        return ((number%2)==1);
    }

    @Override
    public String toString() {
        String result = "";
        for (RowOfBricks rowOfBricks : this.rowsOfBricks){
            if (!result.equals("")){
                result += "\n";
            }
            result += rowOfBricks.toString();
        }
        return result;
    }
}
