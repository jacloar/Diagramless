package diagramless.view;

import java.awt.event.KeyListener;

import diagramless.model.IBoard;

/**
 * View interface to display the model.
 */
public interface IView {
  /**
   * Sets this views model to the given {@link IBoard}.
   *
   * @param model Model to add to this
   */
  void setModel(IBoard model);

  /**
   * Initializes the view
   */
  void initialize();

  /**
   * Updates the view
   */
  void update();

  /**
   * Adds a key listener to the view
   */
  void addKeyListener(KeyListener listener);
}
