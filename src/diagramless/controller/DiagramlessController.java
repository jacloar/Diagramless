package diagramless.controller;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import diagramless.model.IBoard;
import diagramless.view.IView;

/**
 * Represents a {@code controller} for the diagramless. Coordinates keyboard input between
 * model and view.
 */
public class DiagramlessController {
  private IBoard model;
  private IView view;

  /**
   * Constructs a controller for coordinating input between model and view
   *
   * @param model {@code Model} to store information
   * @param view {@code View} to appropriately display model
   */
  public DiagramlessController(IBoard model, IView view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }

    this.model = model;
    this.view = view;

    this.view.setModel(model);
  }

  public void initialize() {
    this.configureKeyboardHandler();

    view.initialize();
  }

  private void configureKeyboardHandler() {
    Map<Integer, Runnable> keyPresses = new HashMap<>();
    Map<Character, Runnable> keyTypes = new HashMap<>();

    keyPresses.put(KeyEvent.VK_UP, () -> {
      model.moveUp();
      view.update();
    });

    keyPresses.put(KeyEvent.VK_DOWN, () -> {
      model.moveDown();
      view.update();
    });

    keyPresses.put(KeyEvent.VK_LEFT, () -> {
      model.moveLeft();
      view.update();
    });

    keyPresses.put(KeyEvent.VK_RIGHT, () -> {
      model.moveRight();
      view.update();
    });

    keyPresses.put(KeyEvent.VK_ENTER, () -> {
      model.toggleCell();
      view.update();
    });

    keyPresses.put(KeyEvent.VK_BACK_SPACE, () -> {
      model.clearCell();
      view.update();
    });

    for (char let = 'a'; let <= 'z'; let += 1) {
      char c = let;
      keyTypes.put(let, () -> {
        model.setLetter((char) (c - 32));
        view.update();
      });
    }

    KeyboardHandler kbd = new KeyboardHandler(this.model, this.view);
    kbd.setKeyPressedMap(keyPresses);
    kbd.setKeyTypedMap(keyTypes);

    view.addKeyListener(kbd);
  }
}
