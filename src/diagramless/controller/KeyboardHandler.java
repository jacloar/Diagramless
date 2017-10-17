package diagramless.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import diagramless.model.IBoard;
import diagramless.view.IView;

/**
 * Class to set up the {@link KeyListener} so the controller has a way of talking
 * to the keyboard. Sets up with keyTyped and keyPressed, and calls the
 * appropriate one when a {@link KeyEvent} occurs.
 */
public class KeyboardHandler implements KeyListener {
  private Map<Character, Runnable> keyTypedMap;
  private Map<Integer, Runnable> keyPressedMap;

  private boolean addToClue;
  private int currentClue;

  private IBoard model;
  private IView view;

  /**
   * Constructor to make a KeyboardHandler.
   */
  public KeyboardHandler(IBoard model, IView view) {
    this.model = model;
    this.view = view;

    this.addToClue = false;
    this.currentClue = 0;
  }

  /**
   * Sets this handler's keyTypedMap to the given map.
   *
   * @param map map to set keyTypedMap to
   */
  public void setKeyTypedMap(Map<Character, Runnable> map) {
    keyTypedMap = map;
  }

  /**
   * Sets this handler's keyPressedMap to the given map.
   *
   * @param map map to set keyPressedMap to
   */
  public void setKeyPressedMap(Map<Integer, Runnable> map) {
    keyPressedMap = map;
  }


  @Override
  public void keyTyped(KeyEvent e) {
    if (addToClue) {
      if ('0' <= e.getKeyChar() && e.getKeyChar() <= '9') {
        this.currentClue *= 10;
        this.currentClue += (int) e.getKeyChar() - 48;
      }
    }
    if (keyTypedMap.containsKey(e.getKeyChar())) {
      keyTypedMap.get(e.getKeyChar()).run();
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {

      if (addToClue) {
        if (currentClue != 0) {
          model.setClue(currentClue);
          this.currentClue = 0;
          view.update();
        }
      }

      this.addToClue = !this.addToClue;
    }

    if (keyPressedMap.containsKey(e.getKeyCode())) {
      keyPressedMap.get(e.getKeyCode()).run();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
      if (currentClue != 0) {
        model.setClue(currentClue);
        this.currentClue = 0;
      }
      this.addToClue = false;
    }
  }
}
