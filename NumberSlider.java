package Project2;

import java.util.ArrayList;

public interface NumberSlider {
    /**
     * Reset the game logic to handle a board of a given dimension
     *
     * @param height the number of rows in the board
     * @param width the number of columns in the board
     * @param winningValue the value that must appear on the board to
     *                     win the game
     * @throws IllegalArgumentException when the winning value is not power of two
     *  or is negative
     */
    public void resizeBoard(int height, int width, int winningValue);


    /**
     * Remove all numbered tiles from the board and place
     * TWO non-zero values at random location
     */
    public void reset();

    /**
     * Set the game board to the desired values given in the 2D array.
     * This method should use nested loops to copy each element from the
     * provided array to your own internal array. Do not just assign the
     * entire array object to your internal array object. Otherwise, your
     * internal array may get corrupted by the array used in the JUnit
     * test file. This method is mainly used by the JUnit tester.
     * @param ref
     */
    public void setValues(final int[][] ref);

    /**
     * Insert one random tile into an empty spot on the board.
     *
     * @return a Cell object with its row, column, and value attributes
     *  initialized properly
     *
     * @throws IllegalStateException when the board has no empty cell
     */
    public Cell placeRandomValue();

    /**
     * Slide all the tiles in the board in the requested direction
     * The value should be the number 2 or 4 (random)
     * @param dir move direction of the tiles
     *
     * @return true when the board changes
     */
    public boolean slide(SlideDirection dir);

    /**
     *
     * @return an arraylist of Cells. Each cell holds the (row,column) and
     * value of a tile
     */
    public ArrayList<Cell> getNonEmptyTiles();

    /**
     * Return the current state of the game
     * @return one of the possible values of GameStatus enum
     */
    public GameStatus getStatus();

    /**
     * Undo the most recent action, i.e. restore the board to its previous
     * state. Calling this method multiple times will ultimately restore
     * the game to the very first initial state of the board holding two
     * random values. Further attempt to undo beyond this state will throw
     * an IllegalStateException.
     *
     * @throws IllegalStateException when undo is not possible
     */
    public void undo();
}