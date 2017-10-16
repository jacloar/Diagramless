package diagramless.model;

/**
 * Represents the letter cell type. Does not necessarily have a letter, but can contain one
 * and/or a clue number. A {@code clue} can be any non-negative number, with 0 representing
 * a cell without a clue number. A {@code letter} can be any capital alphabetic character
 * ('A' - 'Z') or space (' ') which represents a non-lettered cell.
 */
public class LetterCell implements CellType {

  private int clue;
  private char letter;

  /**
   * Creates a blank letter cell with no letter and no clue number.
   */
  LetterCell() {
    this.clue = 0;
    this.letter = ' ';
  }

  @Override
  public void setLetter(char letter) throws IllegalArgumentException {
    if (letter < 'A' || letter > 'Z') {
      throw new IllegalArgumentException("Invalid letter");
    }

    this.letter = letter;
  }

  @Override
  public void clearLetter() {
    this.letter = ' ';
  }

  @Override
  public void setClue(int clue) throws IllegalArgumentException {
    if (clue <= 0) {
      throw new IllegalArgumentException("Invalid clue");
    }

    this.clue = clue;
  }

  @Override
  public void clearClue() {
    this.clue = 0;
  }

  @Override
  public boolean hasLetter() {
    return this.letter != ' ';
  }

  @Override
  public char getLetter() throws IllegalStateException {
    if (!this.hasLetter()) {
      throw new IllegalStateException("Cell does not contain a letter");
    }

    return letter;
  }

  @Override
  public boolean hasClue() {
    return this.clue != 0;
  }

  @Override
  public int getClue() throws IllegalStateException {
    if (!this.hasClue()) {
      throw new IllegalStateException("Cell deos not contain a clue number");
    }

    return clue;
  }

  @Override
  public boolean isFilled() {
    return false;
  }
}
