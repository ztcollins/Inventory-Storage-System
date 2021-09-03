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
 * Imitation class of the LinkedList. The methods below are basic and self-explanatory
 * 
 * @author Zach C
 *
 */
public class LinkedBox {

  private Box box;
  private LinkedBox next;
  
  
  public LinkedBox(Box box, LinkedBox next) {
    this.box = box;
    this.next = next;
  }
  
  
  public LinkedBox(Box box) {
    this.box = box;
    this.next = null;
  }
  
  
  public Box getBox() {
    return this.box;
  }
  
  
  public LinkedBox getNext() {
    return this.next;
  }
  
  
  public void setNext(LinkedBox next) {
    this.next = next;
  }
  
  
  public String toString() {
     if(next != null) {
       return box.toString() + " -> ";
     } else {
       return box.toString() + " -> END";
     }
  }
  
  
}
