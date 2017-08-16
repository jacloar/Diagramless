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
    if (type instanceof LetterCell) {
      type = new FilledCell();
    } else {
      type = new LetterCell();
    }
  }

  /**
   * Sets this cell's letter to the given letter.
   *
   * @param letter The capital letter ('A' - 'Z') to be contained in this cell.
   * @throws IllegalArgumentException if given invalid letter
   */
  void setLetter(char letter) throws IllegalArgumentException {
    type.setLetter(letter);
  }

  /**
   * Clears the letter from this cell.
   */
  void clearLetter() {
    type.clearLetter();
  }

  /**
   * Sets this cell's clue number to the given integer.
   *
   * @param clue The positive integer for this cell's clue.
   * @throws IllegalArgumentException if given non-positive integer
   */
  void setClue(int clue) throws IllegalArgumentException {
    type.setClue(clue);
  }

  /**
   * Clears the clue from this cell.
   */
  void clearClue() {
    type.clearClue();
  }
}
