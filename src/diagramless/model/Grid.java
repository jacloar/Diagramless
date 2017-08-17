package diagramless.model;

import java.util.ArrayList;

/**
 * Represents the puzzle grid. Contains a matrix of {@link Cell}s of arbitrary size.
 */
public class Grid {

  private ArrayList<ArrayList<Cell>> cells;

  /**
   * Constructs a default grid of {@link Cell}s with size of 17x17.
   */
  Grid() {
    this(17);
  }

  /**
   * Constructs a grid of {@link Cell}s with given grid size. Forms square grid, size x size.
   *
   * @param size Side length of grid
   */
  Grid(int size) {
    cells = new ArrayList<>();

    for (int i = 0; i < size; i += 1) {
      cells.add(new ArrayList<>());
      for (int j = 0; j < size; j += 1) {
        cells.get(i).add(new Cell());
      }
    }
  }
}
