//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P07 Inventory Storage System
// Course:   CS 300 Spring 2021
//
// Author:   Zachary Collins
// Email:    ztcollins@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         -
// Online Sources:  -
//
///////////////////////////////////////////////////////////////////////////////
/**
 * The main Class of the P07 Inventory Storage System Project
 * 
 * @author Zach C
 *
 */
public class InventoryList {

  private LinkedBox head;
  private LinkedBox tail;
  private int size;
  private int yellowCount;
  private int blueCount;
  private int brownCount;
  
  
  /**
   * Returns the size of this list
   * 
   * @return size
   */
  public int size() {
    return this.size;
  }
  
  /**
   * Checks whether this LinkedBoxList is empty
   * 
   * @return boolean - true if empty and false otherwise
   */
  public boolean isEmpty() {
    if(size <= 0) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
    yellowCount = 0;
    blueCount = 0;
    brownCount = 0;
  }
  
  
  /**
   * Adds a brown box at the end of this inventory list
   * 
   * @param brownBox - new brown box to be added to this list
   */
  public void addBrown(Box brownBox) {
    if(brownBox.getColor() != Color.BROWN) {
      throw new IllegalArgumentException("ERROR: COLOR SHOULD BE BROWN");
    }
    LinkedBox newBrown;
    if(this.isEmpty()) {
      newBrown = new LinkedBox(brownBox, null);
      head = newBrown;
      tail = newBrown;
    } else {
      newBrown = new LinkedBox(brownBox, null);
      tail.setNext(newBrown);
      tail = newBrown;
    }
    brownCount++;
    size++;
  }
  
  
  /**
   * Adds a new blue box at the top of blue boxes if the list contains any blue box.
   * Blue boxes must be added at the buttom of yellow boxes and at the top of all the brown boxes
   * if any. This means that a new blue box must be added at index yellowCount.
   * 
   * @param blueBox - new box to be added to this list
   */
  public void addBlue(Box blueBox) {
    if(blueBox.getColor() != Color.BLUE) {
      throw new IllegalArgumentException("ERROR: COLOR SHOULD BE BLUE");
    }
    LinkedBox newBlue = new LinkedBox(blueBox);
    if(isEmpty()) {
      head = newBlue;
      tail = newBlue;
      newBlue.setNext(null);
    } else {
      if(yellowCount == 0) {
        newBlue.setNext(head);
        head = newBlue;
      }
      else if (yellowCount == 1) {
        tail = newBlue;
        newBlue.setNext(null);
        head.setNext(newBlue);
      }
      else {
        LinkedBox newNode = new LinkedBox(blueBox);
        LinkedBox current = head;
        LinkedBox previous = null;
        
        int inx = 0;
        
        while(inx < yellowCount) {
          previous = current;
          current = current.getNext();
          inx++;
        }
        
        newNode.setNext(current);
        previous.setNext(newNode);
      }
    }
    blueCount++;
    size++;
  }
  
  
  /**
   * Adds a new yellow box at the head of this list
   * 
   * @param yellowBox - new box to be added to this list
   */
  public void addYellow(Box yellowBox) {
    if(yellowBox.getColor() != Color.YELLOW) {
      throw new IllegalArgumentException("ERROR: COLOR SHOULD BE YELLOW");
    }
    
    LinkedBox newYellow;
    if(this.isEmpty()) {
      newYellow = new LinkedBox(yellowBox, null);
      head = newYellow;
      tail = newYellow;
    } else {
      newYellow = new LinkedBox(yellowBox, head);
      head = newYellow;    
    }
    yellowCount++;
    size++;
  }
  
  
  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index - position within this list
   * @return Box - the box stored at position index of this list
   */
  public Box get(int index) {
    LinkedBox currentBox = head;
    int iterate = 1;
    while(iterate < index) {
      currentBox = currentBox.getNext();
      iterate++;
    }
    return currentBox.getBox();
  }
  
  
  /**
   * Removes and returns the box at the head of this list if its color is yellow
   * 
   * @return a reference to the removed box
   */
  public Box removeYellow() {
    Box removeBox = head.getBox();
    if(head.getBox().getColor() == Color.YELLOW) {
      head = head.getNext();
      size--;
      yellowCount--;
      return removeBox;
    }
    else {
      return null;
    }
  }
  
  
  /**
   * Removes and returns the element at the tail of this list if it has a brown color
   * 
   * @return a reference to the removed element
   */
  public Box removeBrown() {
    Box removeBox = tail.getBox();
    if(tail.getBox().getColor() == Color.BROWN) {
      if(size == 1) {
        head = null;
        tail = null;
        size--;
        brownCount--;
        return removeBox;
      }
      
      LinkedBox current = head;
      LinkedBox previous = null;
      
      int inx = 0;
      
      while(inx < size) {
        if(current.getNext() == null) {
          tail = previous;
          previous.setNext(null);
          break;
        }
        previous = current;
        current = current.getNext();
        inx++;
      }
      size--;
      brownCount--;
      return removeBox;
    }
    else {
      return null;
    }
  }
  
  
  /**
   * Removes and returns a box given its inventory number from this list
   * 
   * @param inventoryNumber - inventory number of the box to be removed from this list
   * @return a reference to the removed element
   */
  public Box removeBox(int inventoryNumber) {
    LinkedBox current = head;
    LinkedBox previous = null;
    if(size == 1) {
      head = null;
      tail = null;
      size--;
      if(current.getBox().getColor()==Color.BLUE) {
        blueCount--;
      }
      if(current.getBox().getColor()==Color.YELLOW) {
        yellowCount--;
      }
      if(current.getBox().getColor()==Color.BROWN) {
        brownCount--;
      }
      return current.getBox();
      
    }
    int iterate = 0;
    while(iterate < size+1) {
      if(current.getBox().getInventoryNumber() == inventoryNumber) {
        if(current.getBox().getColor()==Color.BLUE) {
          blueCount--;
        }
        if(current.getBox().getColor()==Color.YELLOW) {
          yellowCount--;
        }
        if(current.getBox().getColor()==Color.BROWN) {
          brownCount--;
        }
        if(current.getNext()== null) {
          tail = previous;
          previous.setNext(null);
          break;
        }
        if(current == head) {
          head = current.getNext();
          size--;
          return current.getBox();
        }
        previous.setNext(current.getNext());
        break;
      }
      previous = current;
      current = current.getNext();
      iterate++;
    }
    size--;
    return current.getBox();
  }
  
  
  /**
   * Returns the number of brown boxes stored in this list
   * 
   * @return the brownCount
   */
  public int getBrownCount() {
    return brownCount;
  }
  
  
  /**
   * Returns the number of yellow boxes stored in this list
   * 
   * @return the yellowCount
   */
  public int getYellowCount() {
    return yellowCount;
  }
  
  
  /**
   * Returns the number of blue boxes stored in this list
   * 
   * @return the blueCount
   */
  public int getBlueCount() {
    return blueCount;
  }

  
  /**
   * Returns a String representation of the contents of this list
   */
  public String toString() {
    if(this.isEmpty() == true) {
      return "";
    }
    else {
      String combined = "";
      int iterate = 0;
      LinkedBox current = new LinkedBox(head.getBox(), head.getNext());
      while(iterate < size) {
        if(current != null) {
          combined = combined + current.toString();
          current = current.getNext();
          //System.out.println(iterate + " " + combined);
        }
        iterate++;
      }
      return combined;
    }
  }
}
