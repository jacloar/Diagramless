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
   */
  void setLetter(char letter) throws IllegalArgumentException;

  /**
   * Clears the letter from this cell.
   */
  void clearLetter();

  /**
   * Sets this cell's clue number to the given integer.
   *
   * @param clue The positive integer for this cell's clue.
   * @throws IllegalArgumentException if given non-positive integer
   */
  void setClue(int clue) throws IllegalArgumentException;

  /**
   * Clears the clue from this cell.
   */
  void clearClue();
}
