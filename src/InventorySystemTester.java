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
import java.util.NoSuchElementException;
/**
 * This class includes all of the tester methods and the demos
 * 
 * @author Zach C
 *
 */
public class InventorySystemTester {

  public static void main(String[] args) {
    System.out.println("Tests: " + runAllTests());
    //demo();
    //demo2();

  }


  public static boolean testLinkedBox() {
    Box.restartNextInventoryNumber();

    LinkedBox box1 = new LinkedBox(new Box(Color.BROWN));
    LinkedBox box2 = new LinkedBox(new Box(Color.YELLOW), box1);

    // System.out.println(box1.toString());
    // System.out.println(box2.toString());
    box2.setNext(box1);
    // System.out.println(box1.getNext());
    // System.out.println(box2.toString());

    if (!box1.toString().equals("BROWN 1 -> END")) {
      System.out.println("TESTER: box1.toString() should equal BROWN 1 -> END");
      return false;
    }

    if (!box2.toString().equals("YELLOW 2 -> ")) {
      System.out.println("TESTER: box2.toString() should equal YELLOW 2 -> ");
      return false;
    }

    if (box1.getNext() != null) {
      System.out.println("TESTER: box1.getNext() should equal null");
      return false;
    }

    if (box2.getNext() != box1) {
      System.out.println("TESTER: box2.getNext() should equal box 1");
      return false;
    }

    return true;

  }


  // checks for the correctness of the InventoryList.clear() method
  public static boolean testClear() {
    Box.restartNextInventoryNumber();
    Box box1 = new Box(Color.BROWN);
    InventoryList list = new InventoryList();
    list.addBrown(box1);
    list.clear();
    if(list.size() > 0) {
      return false;
    }
    
    return true;

  }

  // checks for the correctness of the InventoryList.addYellow(),
  // InventoryList.addBlue(), and InventoryList.addBrown() methods
  public static boolean testAddBoxes() {
    Box.restartNextInventoryNumber();
    Box box1 = new Box(Color.BROWN);
    Box box2 = new Box(Color.BLUE);
    Box box3 = new Box(Color.YELLOW);
    InventoryList list = new InventoryList();
    list.addBrown(box1);
    list.addBlue(box2);
    list.addYellow(box3);
    if(list.size() != 3) {
      return false;
    }
    return true;

  }

  // checks for the correctness of the InventoryList.removeBox()
  // InventoryList.removeYellow(), and InventoryList.remove Brown()
  // methods
  public static boolean testRemoveBoxes() {
    Box.restartNextInventoryNumber();
    Box box1 = new Box(Color.BROWN);
    Box box2 = new Box(Color.BLUE);
    Box box3 = new Box(Color.YELLOW);
    InventoryList list = new InventoryList();
    list.addBrown(box1);
    list.addBlue(box2);
    list.addYellow(box3);
    list.removeBrown();
    list.removeYellow();
    list.removeBox(2);
    if(list.size() != 0) {
      return false;
    }
    return true;

  }

  // checks for the correctness of the InventoryList.get() method
  public static boolean testGetBoxes() {
    Box.restartNextInventoryNumber();
    Box box1 = new Box(Color.BROWN);
    Box box2 = new Box(Color.BLUE);
    Box box3 = new Box(Color.YELLOW);
    InventoryList list = new InventoryList();
    list.addBrown(box1);
    list.addBlue(box2);
    list.addYellow(box3);
    if(list.get(1) != box3) {
      return false;
    }
    return true;

  }

  // a test suite method to run all your test methods
  public static boolean runAllTests() {
    if(testLinkedBox() == false) {
      return false;
    }
    if(testClear() == false) {
      return false;
    }
    if(testAddBoxes() == false) {
      return false;
    }
    if(testRemoveBoxes() == false) {
      return false;
    }
    if(testGetBoxes() == false) {
      return false;
    }
    return true;
  }
  
  
  public static void demo2() {
    InventoryList list = new InventoryList();
    //(-5.0): This test creates an empty InventoryList list. Then, it calls the following methods in order.
    list.addBrown(new Box(Color.BROWN)); // BROWN 1 must be added at the head of the list. 
    //Then, cleared the list. So, list must be empty again. Then, called 
    list.clear();
   list.addBlue(new Box(Color.BLUE)); // BLUE 2 must be added to the head of the list. 
   //Then again cleared the list, and called the following methods in order: 
   list.clear();
   list.addYellow(new Box(Color.YELLOW)); // must add YELLOW 3 to the head of the list. 
   list.addBlue(new Box(Color.BLUE)); // must add BLUE 4 at the tail of the list. 
   list.addYellow((new Box(Color.YELLOW))); // must add YELLOW 5 to the head of the list. 
   list.addBrown((new Box(Color.BROWN))); // must add BROWN 6 to the tail of the list. 
   list.addBlue((new Box(Color.BLUE))); // must add BLUE 7 at the position 2 of the list. 
   list.addBrown((new Box(Color.BROWN))); // must add BROWN 8 to the tail of the list.
   //Lastly, this test checks whether the contents of your list is as follows, 
   //and that all the count fields and the size of the list are correct.
   //Calling list.toString() at the end of this scenario must return: YELLOW 5 -> YELLOW 3 
   //-> BLUE 7 -> BLUE 4 -> BROWN 6 -> BROWN 8 -> END
   System.out.println(list.toString());
    
  }


  private static void displaySizeCounts(InventoryList list) {
    System.out.println(" Size: " + list.size() + ", yellowCount: " + list.getYellowCount()
        + ", blueCount: " + list.getBlueCount() + ", brownCount: " + list.getBrownCount());
  }

  /**
   * Demo method showing how to use the implemented classes in P07 Inventory Storage System
   * 
   * @param args input arguments
   */
  public static void demo() {
    // Create a new empty InventoryList object
    InventoryList list = new InventoryList();
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    // Add a blue box to an empty list
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 1
    System.out.println(list); // prints lists content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 2 at the head of the list
    System.out.println(list); // prints lists content
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 3
    System.out.println(list); // prints lists content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 4
    System.out.println(list); // prints lists content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 5 at the head of the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    // Add more boxes to list and display its contents
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 6 at the end of the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 7 at the end of the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    // System.out.println("MEME "+list.get(6).);
    list.removeBrown(); // removes BROWN 7 from the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 8
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.removeBrown(); // removes BROWN 6 from the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.removeYellow(); // removes YELLOW 5
    System.out.println(list); // prints lists content
    list.removeBox(3); // removes BLUE 3 from the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    try {
      list.removeBox(25); // tries to remove box #25
    } catch (NullPointerException e) {
      System.out.println("Error to remove box. Box #25 not found!");
    }
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    // remove all yellow boxes
    while (list.getYellowCount() > 0) {
      list.removeYellow();
    }
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.removeBox(1); // removes BLUE 1 from the list -> empty list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 9 to the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.removeBox(8); // removes BLUE 8 from the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.removeBrown(); // removes BROWN 9 from the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 10 to the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
    list.removeBox(10); // removes YELLOW 10 from the list
    System.out.println(list); // prints lists content
    displaySizeCounts(list); // displays lists size and counts
  }

}
