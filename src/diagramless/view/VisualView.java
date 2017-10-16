package diagramless.view;

import java.awt.*;

import javax.swing.*;

import diagramless.model.IBoard;

/**
 * Represents a visual view using a gui and swing.
 */
public class VisualView extends JFrame {

  private final GridPanel panel;
  private IBoard grid;

  /**
   * Constructs a new visual view.
   */
  public VisualView() {
    panel = new GridPanel();
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().add(panel);
    this.pack();
  }

  /**
   * Sets this views model to the given {@link IBoard}.
   *
   * @param model Model to add to this
   */
  public void setModel(IBoard model) {
    this.grid = model;
    panel.setModel(model);
  }

  /**
   * Initializes the view
   */
  public void initialize() {
    this.setVisible(true);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1000, 1000);
  }
}
