package diagramless.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import diagramless.model.Cell;
import diagramless.model.IBoard;

/**
 * Represents the panel of the frame containing the grid.
 */
public class GridPanel extends JPanel {

  private IBoard model;
  private static int cellSize = 40;

  @Override
  public void paintComponent(Graphics g) {
    if (model == null) {
      throw new IllegalStateException("Model cannot be null");
    }

    this.drawBoarder(g);
    ArrayList<ArrayList<Cell>> grid = model.getGrid();

    for (int i = 0; i < grid.size(); i += 1) {
      for (int j = 0; j < grid.size(); j += 1) {
        this.drawCell(g, grid.get(i).get(j), i, j);
      }
    }
  }

  private void drawBoarder(Graphics g) {
    g.setColor(Color.BLACK);
    g.drawRect(0, 0, model.getSize() * cellSize, model.getSize() * cellSize);
  }

  private void drawCell(Graphics g, Cell c, int x, int y) {
    Color backgroud;

    if (x == model.getX() && y == model.getY()) {
      backgroud = Color.YELLOW;
    } else {
      backgroud = Color.WHITE;
    }

    if (c.isFilled()) {
      g.setColor(Color.BLACK);
      g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
    } else {
      g.setColor(backgroud);
      g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
      g.setColor(Color.BLACK);
      g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);

      if (c.hasClue()) {
        g.setFont(new Font("Ariel", Font.PLAIN, 10));
        g.drawString(String.valueOf(c.getClue()),
                x * cellSize, (int) ((y + 0.2) * cellSize));
      }

      if (c.hasLetter()) {
        g.setFont(new Font("Ariel", Font.PLAIN, cellSize));
        g.drawString(String.valueOf(c.getLetter()),
                (int) ((x + 0.2) * cellSize), (int) ((y + 0.9) * cellSize));
      }
    }

  }

  public void setModel(IBoard model) {
    this.model = model;
  }

  /**
   * Updates the panel
   */
  public void update() {
    this.repaint();
    this.revalidate();
  }

}
