package diagramless.model;

/**
 * Represents the interface for a cell type. Allows the {@link Cell} to switch between
 * types seamlessly.
 */
public interface CellType {

  /**
   * Sets this cell's letter to the given letter.
   *
   * @param letter The capital letter ('A' - 'Z') to be contained in this cell.
   * @throws IllegalArgumentException if given invalid letter
   * @throws IllegalStateException if called on {@link FilledCell}
   */
  void setLetter(char letter) throws IllegalArgumentException;

  /**
   * Clears the letter from this cell.
   * @throws IllegalStateException if called on {@link FilledCell}
   */
  void clearLetter();

  /**
   * Sets this cell's clue number to the given integer.
   *
   * @param clue The positive integer for this cell's clue.
   * @throws IllegalArgumentException if given non-positive integer
   * @throws IllegalStateException if called on {@link FilledCell}
   */
  void setClue(int clue) throws IllegalArgumentException;

  /**
   * Clears the clue from this cell.
   * @throws IllegalStateException if called on {@link FilledCell}
   */
  void clearClue();

  /**
   * Determines if the cell has a letter.
   *
   * @return true if has letter
   */
  boolean hasLetter();

  /**
   * Returns the cell's letter.
   *
   * @throws IllegalStateException if invalid type to return letter, ie, {@link FilledCell},
   * or the cell does not have a proper letter.
   */
  char getLetter() throws IllegalStateException;

  /**
   * Determines if the cell has a clue.
   *
   * @return true if has clue
   */
  boolean hasClue();

  /**
   * Returns the cell's clue number.
   *
   * @throws IllegalStateException if invalid type to return clue number, ie, {@link FilledCell},
   * or the cell does not have a proper clue number.
   */
  int getClue() throws IllegalStateException;

  /**
   * Determines if the cell is a {@link FilledCell}.
   *
   * @return true if a filled cell.
   */
  boolean isFilled();
}
