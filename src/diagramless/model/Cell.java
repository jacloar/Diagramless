package diagramless.model;

/**
 * Interface representing a cell on the puzzle grid.
 */
public class Cell {

  private CellType type;

  /**
   * Constructs an empty {@link LetterCell} as the {@link CellType}.
   */
  Cell() {
    this.type = new LetterCell();
  }

  /**
   * Switches the {@link CellType}. If {@link LetterCell}, becomes {@link FilledCell}
   * and vis versa.
   */
  public void toggle() {
    if (type.isFilled()) {
      type = new LetterCell();
    } else {
      type = new FilledCell();
    }
  }

  /**
   * Sets this cell's letter to the given letter.
   *
   * @param letter The capital letter ('A' - 'Z') to be contained in this cell.
   * @throws IllegalArgumentException if given invalid letter
   */
  public void setLetter(char letter) throws IllegalArgumentException {
    type.setLetter(letter);
  }

  /**
   * Clears the letter from this cell.
   */
  public void clearLetter() {
    type.clearLetter();
  }

  /**
   * Sets this cell's clue number to the given integer.
   *
   * @param clue The positive integer for this cell's clue.
   * @throws IllegalArgumentException if given non-positive integer
   */
  public void setClue(int clue) throws IllegalArgumentException {
    type.setClue(clue);
  }

  /**
   * Clears the clue from this cell.
   */
  public void clearClue() {
    type.clearClue();
  }

  /**
   * Determines if the cell has a letter.
   *
   * @return true if the cell has a letter, false otherwise
   */
  public boolean hasLetter() {
    return type.hasLetter();
  }

  /**
   * Returns the cell's letter.
   *
   * @throws IllegalStateException if invalid type to return letter, ie, {@link FilledCell},
   * or the cell does not have a proper letter.
   */
  public char getLetter() throws IllegalStateException {
    return type.getLetter();
  }

  /**
   * Determines if the cell has a clue.
   *
   * @return true if the cell has a clue, false otherwise
   */
  public boolean hasClue() {
    return type.hasClue();
  }

  /**
   * Returns the cell's clue number.
   *
   * @throws IllegalStateException if invalid type to return clue number, ie, {@link FilledCell},
   * or the cell does not have a proper clue number.
   */
  public int getClue() throws IllegalStateException {
    return type.getClue();
  }

  /**
   * Determines if the cell is a {@link FilledCell}.
   *
   * @return true if a filled cell.
   */
  public boolean isFilled() {
    return type.isFilled();
  }
}
