package diagramless.model;

/**
 * Represents the filled cell type. Acts as a blank space on the grid that cannot be filled.
 */
public class FilledCell implements CellType {


  @Override
  public void setLetter(char letter) {
    throw new IllegalStateException("Cannot set letter of filled cell");
  }

  @Override
  public void clearLetter() {
    throw new IllegalStateException("Cannot clear letter of filled cell");
  }

  @Override
  public void setClue(int clue) {
    throw new IllegalStateException("Cannot set clue of filled cell");
  }

  @Override
  public void clearClue() {
    throw new IllegalStateException("Cannot clear clue of filled cell");
  }

  @Override
  public boolean hasLetter() {
    return false;
  }

  @Override
  public char getLetter() throws IllegalStateException {
    throw new IllegalStateException("Cannot get letter of filled cell");
  }

  @Override
  public boolean hasClue() {
    return false;
  }

  @Override
  public int getClue() throws IllegalStateException {
    throw new IllegalStateException("Cannot get clue number of filled cell");
  }

  @Override
  public boolean isFilled() {
    return true;
  }
}
