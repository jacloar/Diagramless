package diagramless.model;

/**
 * Represents the filled cell type. Acts as a blank space on the grid that cannot be filled.
 */
public class FilledCell implements CellType {


  @Override
  public void setLetter(char letter) throws IllegalArgumentException {
    if (letter < 'A' || letter > 'Z') {
      throw new IllegalArgumentException("Invalid letter");
    }
  }

  @Override
  public void clearLetter() {

  }

  @Override
  public void setClue(int clue) throws IllegalArgumentException {
    if (clue <= 0) {
      throw new IllegalArgumentException("Invalid clue");
    }
  }

  @Override
  public void clearClue() {

  }
}
