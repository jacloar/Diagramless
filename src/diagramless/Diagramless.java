package diagramless;

import diagramless.model.Grid;
import diagramless.model.IBoard;
import diagramless.view.VisualView;

/**
 * Main class for running the program.
 */
public class Diagramless {

  /**
   * Main class to run the program.
   *
   * @param args Arguments for the program
   */
  public static void main(String[] args) {

    IBoard model = new Grid();
    model.moveRight();
    model.setClue(10);
    model.setLetter('A');
    model.moveDown();
    model.setLetter('B');
    model.moveDown();
    model.toggleCell();
    model.moveDown();
    model.moveDown();
    model.moveRight();
    model.setClue(31);

    VisualView view = new VisualView();
    view.setModel(model);
    view.initialize();
  }
}
