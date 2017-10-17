package diagramless;

import diagramless.controller.DiagramlessController;
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

    VisualView view = new VisualView();
    view.setModel(model);

    DiagramlessController controller = new DiagramlessController(model, view);
    controller.initialize();
  }
}
