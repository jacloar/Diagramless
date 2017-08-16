package diagramless.model;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Testing class for {@link Cell}.
 */
public class CellTest {

  /*
  Tests that the default cell has the type of a LetterCell.
   */
  @Test
  public void testDefaultLetterCell() {
    Cell c = new Cell();
    assertFalse(c.isFilled());
  }

  /*
  Tests that toggle() called on a letter cell will make it a filled cell.
   */
  @Test
  public void testToggleLetterToFilled() {
    Cell c = new Cell();
    assertFalse(c.isFilled());

    c.toggle();

    assertTrue(c.isFilled());
  }

  /*
  Tests that toggle() called on a filled cell will make it a letter cell.
   */
  @Test
  public void testToggleFilledToLetter() {
    Cell c = new Cell();
    assertFalse(c.isFilled());

    c.toggle();

    assertTrue(c.isFilled());

    c.toggle();

    assertFalse(c.isFilled());
  }

  /*
  Tests that by default a letter cell does not have a letter
   */
  @Test(expected = IllegalStateException.class)
  public void testDefaultLetterCellNoLetter() {
    Cell c = new Cell();
    assertFalse(c.isFilled());

    c.getLetter();
  }

  /*
  Tests that by default a letter cell does not have a clue number
   */
  @Test(expected = IllegalStateException.class)
  public void testDefaultLetterCellNoClueNum() {
    Cell c = new Cell();
    assertFalse(c.isFilled());

    c.getClue();
  }

  /*
  Tests that after setting a letter, getLetter will return that letter
   */
  @Test
  public void testSetLetter() {
    Cell c = new Cell();
    c.setLetter('A');

    assertEquals('A',
            c.getLetter());
  }

  /*
  Tests that you cannot set a character outside A-Z range
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetNotLetter() {
    Cell c = new Cell();
    c.setLetter('5');
  }

  /*
  Tests that you cannot set a lower case letter
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetLowercaseLetter() {
    Cell c = new Cell();
    c.setLetter('e');
  }

  /*
  Tests that after setting a clue number, getClue will return that number
   */
  @Test
  public void testSetClue() {
    Cell c = new Cell();
    c.setClue(3);

    assertEquals(3,
            c.getClue());
  }

  /*
  Tests that you cannot set a non-positive clue number
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetClueZero() {
    Cell c = new Cell();
    c.setClue(0);
  }

  /*
  Tests that after setting a valid letter, clearLetter() will make getLetter() throw an error
   */
  @Test(expected = IllegalStateException.class)
  public void testClearLetter() {
    Cell c = new Cell();
    c.setLetter('Z');
    assertEquals('Z',
            c.getLetter());

    c.clearLetter();
    c.getLetter();
  }

  /*
  Tests that after setting a valid clue number, clearLetter() will make getLetter() throw an error
   */
  @Test(expected = IllegalStateException.class)
  public void testClearClue() {
    Cell c = new Cell();
    c.setClue(1);
    assertEquals(1,
            c.getClue());

    c.clearClue();
    c.getClue();
  }

  /*
  Tests that a setLetter throws error if called on filled cell
   */
  @Test(expected = IllegalStateException.class)
  public void testSetLetterFilled() {
    Cell c = new Cell();
    c.toggle();
    c.setLetter('C');
  }

  /*
  Tests that a clearLetter throws error if called on filled cell
   */
  @Test(expected = IllegalStateException.class)
  public void testClearLetterFilled() {
    Cell c = new Cell();
    c.toggle();
    c.clearLetter();
  }

  /*
  Tests that a setClue throws error if called on filled cell
   */
  @Test(expected = IllegalStateException.class)
  public void testSetClueFilled() {
    Cell c = new Cell();
    c.toggle();
    c.setClue(10);
  }

  /*
  Tests that a clearClue throws error if called on filled cell
   */
  @Test(expected = IllegalStateException.class)
  public void testClearClueFilled() {
    Cell c = new Cell();
    c.toggle();
    c.clearClue();
  }

  /*
  Tests that a getLetter throws error if called on filled cell
   */
  @Test(expected = IllegalStateException.class)
  public void testGetLetterFilled() {
    Cell c = new Cell();
    c.toggle();
    c.getLetter();
  }

  /*
  Tests that a getClue throws error if called on filled cell
   */
  @Test(expected = IllegalStateException.class)
  public void testGetClueFilled() {
    Cell c = new Cell();
    c.toggle();
    c.getClue();
  }
}
