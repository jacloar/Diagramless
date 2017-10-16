package diagramless.model;

import java.util.ArrayList;

/**
 * Interface to represent the diagramless board. Allows functionality for moving selected cell,
 * toggling its type, and writing to it.
 */
public interface IBoard {
  /**
   * Moves the selected cell up 1 if possible.
   */
  void moveUp();

  /**
   * Moves the selected cell down 1 if possible.
   */
  void moveDown();

  /**
   * Moves the selected cell right 1 if possible.
   */
  void moveRight();

  /**
   * Moves the selected cell left 1 if possible.
   */
  void moveLeft();

  /**
   * Toggles the selected cell
   */
  void toggleCell();

  /**
   * Clears the selected cell
   */
  void clearCell();

  /**
   * Sets the character of the selected cell
   *
   * @param letter  Letter to set
   */
  void setLetter(char letter);

  /**
   * Sets the clue of the selected cell
   *
   * @param clue  Clue to set
   */
  void setClue(int clue);

  /**
   * Accessor method for x coordinate of selected cell
   *
   * @return x coordinate
   */
  int getX();

  /**
   * Accessor method for y coordinate of selected cell
   *
   * @return y coordinate
   */
  int getY();

  /**
   * Accessor method for the grid of cells
   *
   * @return 2d {@link java.util.ArrayList} of {@link Cell}
   */
  ArrayList<ArrayList<Cell>> getGrid();
}
