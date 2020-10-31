//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Linked Cart
// Files: AlphabetList.java, AlphabetListTester.java, LinkedCart.java,
// SortedListADT.java, Cart.java
// Course: ( CS 300, Spring, and 2020)
//
// Author: Sai Rahul Reddy Kondlapudi
// Email: kondlapudi@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Ankit Reddy Seelam
// Partner Email: aseelam@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understood the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class implements unit test methods to check the correctness of LinkedCart and AlphabetList
 * classes defined in the CS300 Spring 2020 - P06 Alphabet Train programming assignment.
 *
 * @author SaiRahulReddyKondlapudi
 * @author AnkitReddySeelam
 */

public class AlphabetListTester {
  /**
   * This method should test and make use of at least the LinkedCart constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedCart() {
    LinkedCart testCart = new LinkedCart(new Cart("A"));
    if (testCart.getNext() != null) {
      return false;
    }
    if (!(testCart.getCart().toString().equals("A"))) {
      return false;
    }
    // adds b to test cart a
    testCart.setNext​(new LinkedCart(new Cart("B")));
    if (!(testCart.getNext().getCart().toString().equals("B"))) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of both AlphabetList constructors and the instance
   * method isEmpty() when called on an empty alphabet list object.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorIsEmpty() {
    AlphabetList testerList = new AlphabetList();
    if (testerList.capacity() != 26) {
      return false;
    }
    if (!(testerList.isEmpty())) {
      return false;
    }
    AlphabetList testingList = new AlphabetList(2);
    if (testingList.capacity() != 2) {
      return false;
    }
    if (!(testingList.isEmpty())) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList(int) constructor when passed a
   * negative int value.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorBadInput() {
    try {
      AlphabetList testerList = new AlphabetList(-1);
      System.out.println("An exception was expected to be thrown.");
      return false;
    } catch (IllegalArgumentException iae) {
    } catch (Exception e) {
      System.out.println("An unexpected exception was thrown.");
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList.add() method when it is passed bad
   * inputs. This method must consider at least the test scenarios provided in the detailed
   * description of these javadocs. (1) Try adding a null to the list; (2) Try adding a cart which
   * carries a non upper-case alphabet letter, for instance "Hello" or "1" or "a". (3) Try adding a
   * duplicate cart to the list.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAddBadInput() {
    {
      try {
        AlphabetList testerList = new AlphabetList();
        testerList.add(new Cart("AB"));
        System.out.println("An error was expected to be thrown.");
        return false;
      } catch (IllegalArgumentException iae) {
        if (!(iae.getMessage().contains("one upper-case"))) {
          System.out.println("Error message is wrong.");
          return false;
        }
      } catch (Exception e) {
        System.out.println("Unexpected exception thrown." + e.getMessage());
        return false;
      }
    }
    {
      try {
        AlphabetList testerList = new AlphabetList();
        testerList.add(new Cart("A"));
        testerList.add(new Cart("A"));
        System.out.println("An error was expected to be thrown.");
        return false;
      } catch (IllegalArgumentException iae) {
        if (!(iae.getMessage().contains("duplicate letters"))) {
          System.out.println("Error message is wrong.");
          return false;
        }
      } catch (Exception e) {
        System.out.println("Unexpected exception thrown.");
        e.printStackTrace();
        return false;
      }
    }
    {
      try {
        AlphabetList testerList = new AlphabetList(1);
        testerList.add(new Cart("A"));
        testerList.add(new Cart("B"));
        System.out.println("An error was expected to be thrown.");
        return false;
      } catch (IllegalStateException ise) {
        if (!(ise.getMessage().contains("list is full"))) {
          System.out.println("Error message is wrong.");
          return false;
        }
      } catch (Exception e) {
        System.out.println("Unexpected exception thrown.");
        e.printStackTrace();
        return false;
      }
    }
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList.add() considering at least the test
   * scenarios provided in the detailed description of these javadocs. (1) Try adding a cart to an
   * empty list; (2) Try adding a cart which is expected to be added at the head of a non-empty
   * alphabet list; (3) Try adding a cart which is expected to be added at the end of a non-empty
   * alphabet list; (4) Try adding a cart which is expected to be added at the middle of a non-empty
   * alphabet list. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions. You can
   * also check the correctness of AlphabetList.get(int), AlphabetList.indexOf(Cart), and
   * AlphabetList.size() in this test method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAdd() {

    AlphabetList testerList = new AlphabetList();
    testerList.add(new Cart("A"));
    if (testerList.size() != 1 && testerList.toString() != "A") {
      return false;
    }

    AlphabetList testerList2 = new AlphabetList();
    testerList2.add(new Cart("B"));
    testerList2.add(new Cart("C"));
    testerList2.add(new Cart("A"));
    if (testerList2.get(0).getCargo() != "A") {
      return false;
    }

    AlphabetList testerList3 = new AlphabetList();
    testerList3.add(new Cart("B"));
    testerList3.add(new Cart("Z"));
    testerList3.add(new Cart("A"));
    if (testerList3.get(testerList3.size() - 1).getCargo() != "Z") {
      return false;
    }

    AlphabetList testerList4 = new AlphabetList();
    testerList4.add(new Cart("A"));
    testerList4.add(new Cart("Z"));
    testerList4.add(new Cart("B"));
    if (testerList4.get(1).getCargo() != "B") {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList.remove() considering at least the
   * test scenarios provided in the detailed description of these javadocs. (1) Try removing a cart
   * from an empty list or pass a negative index to AlphabetList.remove() method; (2) Try removing a
   * cart (at position index 0) from a list which contains only one cart; (3) Try to remove a cart
   * (position index 0) from a list which contains at least 2 carts; (4) Try to remove a cart from
   * the middle of a non-empty list containing at least 3 carts; (5) Try to remove the cart at the
   * end of a list containing at least two carts. (6) Try to remove a cart from a list containing
   * only one cart. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListRemove() {
    // Test 1 remove cart by passing a negative index
    try {
      AlphabetList test1 = new AlphabetList();
      test1.remove(-1);
    } catch (IndexOutOfBoundsException outOfBounds) {
      if (!(outOfBounds.getMessage().contains("Invalid index"))) {
        System.out.println("Error message is wrong. (Test 1)");
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unexpected exception thrown. (Test 3)");
      e.printStackTrace();
      return false;
    }
    // Test 2 remove cart from index 0 in a list with only 1 cart
    AlphabetList test2 = new AlphabetList(1);
    test2.add(new Cart("C"));
    test2.remove(0);
    if (test2.size() != 0 && test2.get(0) != null) {
      return false;
    }
    // Test 3 remove a cart from index 0 from list with at least 2 carts
    AlphabetList test3 = new AlphabetList(4);
    test3.add(new Cart("B"));
    test3.add(new Cart("C"));
    test3.add(new Cart("D"));
    test3.remove(0);
    if (test3.size() != 3 && test3.get(0).getCargo() != "C") {
      return false;
    }
    // Test 4 remove a cart from the middle of a list containing at least 3 carts
    AlphabetList test4 = new AlphabetList(5);
    test4.add(new Cart("C"));
    test4.add(new Cart("K"));
    test4.add(new Cart("N"));
    test4.add(new Cart("O"));
    test4.add(new Cart("R"));
    test4.remove(test4.size() / 2);
    if (test4.size() != 4 && test4.readForward() != "C K O R") {
      return false;
    }
    // Test 5 remove cart at the end of a list containing at least 2 carts
    AlphabetList test5 = new AlphabetList(3);
    test5.add(new Cart("E"));
    test5.add(new Cart("H"));
    test5.add(new Cart("M"));
    test5.remove(test5.size() - 1);
    if (test5.size() != 2 && test5.get(test5.size() - 1).getCargo() != "H") {
      return false;
    }
    return true;
  }


  /**
   * This method calls all the test methods defined and implemented in your AlphabetListTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {

    if (testLinkedCart() && testAlphabetListConstructorIsEmpty()
            && testAlphabetListConstructorBadInput() && testAlphabetListAddBadInput()
            && testAlphabetListAdd() && testAlphabetListRemove()) {
      return true;
    }
    return false;
  }

  /**
   * Driver method defined in this AlphabetListTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println("runAllTests: " + runAllTests());

  }
}
