package diagramless.model;

import java.util.ArrayList;

/**
 * Represents the puzzle grid. Contains a matrix of {@link Cell}s of arbitrary size.
 */
public class Grid implements IBoard {

  private ArrayList<ArrayList<Cell>> cells;
  private int curX;
  private int curY;

  /**
   * Constructs a default grid of {@link Cell}s with size of 17x17.
   */
  public Grid() {
    this(17, 0, 0);
  }

  /**
   * Constructs a grid of {@link Cell}s with given grid size. Forms square grid, size x size.
   *
   * @param size Side length of grid
   * @param x    x coordinate of starting selected cell
   * @param y    y coordinate of starting selected cell
   */
  Grid(int size, int x, int y) {
    if (x < 0 || x >= size) {
      throw new IllegalArgumentException("Invalid x coordinate");
    }

    if (y < 0 || y >= size) {
      throw new IllegalArgumentException("Invalid y coordinate");
    }

    this.curX = x;
    this.curY = y;

    cells = new ArrayList<>();

    for (int i = 0; i < size; i += 1) {
      cells.add(new ArrayList<>());
      for (int j = 0; j < size; j += 1) {
        cells.get(i).add(new Cell());
      }
    }
  }

  @Override
  public void moveUp() {
    if (curY > 0) {
      curY = curY - 1;
    }
  }

  @Override
  public void moveDown() {
    if (curY < cells.size() - 1) {
      curY = curY + 1;
    }
  }

  @Override
  public void moveRight() {
    if (curX < cells.size() - 1) {
      curX = curX + 1;
    }
  }

  @Override
  public void moveLeft() {
    if (curX > 0) {
      curX = curX - 1;
    }
  }

  @Override
  public void toggleCell() {
    cells.get(curX).get(curY).toggle();
  }

  @Override
  public void clearCell() {
    cells.get(curX).get(curY).clearLetter();
    cells.get(curX).get(curY).clearClue();
  }

  @Override
  public void setLetter(char letter) {
    cells.get(curX).get(curY).setLetter(letter);
  }

  @Override
  public void setClue(int clue) {
    cells.get(curX).get(curY).setClue(clue);
  }

  @Override
  public int getX() {
    return curX;
  }

  @Override
  public int getY() {
    return curY;
  }

  @Override
  public int getSize() {
    return cells.size();
  }

  @Override
  public ArrayList<ArrayList<Cell>> getGrid() {
    ArrayList<ArrayList<Cell>> ret = new ArrayList<>();

    for (int i = 0; i < cells.size(); i += 1) {
      ret.add(new ArrayList<>());
      for (int j = 0; j < cells.get(i).size(); j += 1) {
        ret.get(i).add(cells.get(i).get(j));
      }
    }

    return ret;
  }
}
