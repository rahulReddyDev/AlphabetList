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
 * 
 * @author SaiRahulReddyKondlapudi
 * @author AnkitReddySeelam
 * @Description This is the implementation of AlphabetList class.
 *
 */
public class AlphabetList implements SortedListADT<Cart> {

  private static final Cart MIN_CART = new Cart("A");
  private static final Cart MAX_CART = new Cart("Z");
  private LinkedCart head;
  private LinkedCart tail;
  private int size;
  private int capacity;

  /*
   * This constructor creates an empty doubly linked list of carts with the capacity equal to 26.
   */
  public AlphabetList() {
    this.capacity = 26;
  }

  /*
   * Creates an empty doubly linked list of carts with a given capacity
   * 
   * @param capacity - maximum number of carts to be connected in this list of carts
   * 
   * @throws java.lang.IllegalArgumentException - with the following error message
   * "The capacity of this list must be a non-zero a positive integer." if capacity is zero or
   * negative
   */
  public AlphabetList(int capacity) throws java.lang.IllegalArgumentException {

    if (capacity > 0) {
      this.capacity = capacity;
    } else {
      throw new java.lang.IllegalArgumentException(
              "The capacity of this list" + " must be a non-zero a positive integer.");
    }
  }

  /*
   * The method isEmpty() Checks whether this list is empty or not.
   * 
   * @return Returns: true if the list is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (this.size != 0) {
      return false;
    }
    if (this.head != null) {
      return false;
    }
    if (this.tail != null) {
      return false;
    }
    return true;
  }

  /*
   * The method is used to returns the size of this list.
   * 
   * @return the number of carts linked in this list
   */
  @Override
  public int size() {
    return this.size;
  }

  /*
   * Returns a String representation of this list. Note that the implementation details of this
   * method is provided in the assignment's specification.
   * 
   * return a String representation of this list
   */
  public java.lang.String toString() {
    String string = "This list contains " + size + " cart(s)";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    LinkedCart currentCart = head;
    while (currentCart != null) {
      string += currentCart.getCart().toString() + " ";
      currentCart = currentCart.getNext();
    }
    string += "]";
    return string;
  }

  /*
   * Returns the capacity of this list in terms of maximum number of carts which can be stored in
   * it.
   * 
   * @return the capacity of this list.
   */
  public int capacity() {
    return capacity;
  }

  /*
   * Removes all the carts from this list. This list must be empty after this method returns.
   * 
   */
  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }


  /*
   * Adds a new cart to this sorted list.
   * 
   * @param newCart - to add to this list
   * 
   * @throws Throws: java.lang.IllegalArgumentException - with a descriptive error message if
   * newCart does not carry one upper-case letter in the range "A" .. "Z" or if this list contains
   * already a cart carrying the same letter. The descriptive error messages for these two cases can
   * be respectively "Can only add carts carrying one upper-case alphabetic letter in the range A ..
   * Z.", and "Cannot duplicate letters or carts in this list." java.lang.IllegalStateException -
   * with the following error message "This list is full. Cannot add another cart." if this list
   * reached its capacity.
   */
  @Override
  public void add(Cart newCart) throws IllegalArgumentException, IllegalStateException {

    char charOfCart = newCart.toString().charAt(0);
    if (newCart.toString().length() > 1) {
      charOfCart = 'e';
    }

    if (charOfCart < 'A' || charOfCart > 'Z') {
      throw new IllegalArgumentException(
              "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
    } else {
      if (this.indexOf(newCart) != -1) {
        throw new IllegalArgumentException("Cannot duplicate letters or carts in this list.");
      }
    }
    // check if the list has reached its capacity
    if (size >= capacity) {
      throw new IllegalStateException("This list is full. Cannot add another cart.");
    }
    // Adds cart to list
    LinkedCart cartToAdd = new LinkedCart(newCart);
    // adds cart when list is empty
    if (head == null) {
      head = new LinkedCart(newCart, null, null);
      tail = head;
      ++size;
      return;
    }
    // checks if new cart should be the head
    if (head.getCart().toString().charAt(0) > charOfCart) {
      head.setPrevious​(cartToAdd);
      cartToAdd.setNext​(head);
      head = cartToAdd;
      ++size;
      return;
    }
    // checks if the new cart should be the tail
    if (tail.getCart().toString().charAt(0) < charOfCart) {
      tail.setNext​(cartToAdd);
      cartToAdd.setPrevious​(tail);
      tail = cartToAdd;
      ++size;
      return;
    }
    // Puts new cart in the middle
    LinkedCart currCart = head;
    do {
      if (currCart.getCart().toString().charAt(0) < charOfCart
              && currCart.getNext().getCart().toString().charAt(0) > charOfCart) {
        // adds cart and updates links between carts
        LinkedCart endCart = currCart.getNext();
        endCart.setPrevious​(cartToAdd);
        currCart.setNext​(cartToAdd);
        cartToAdd.setPrevious​(currCart);
        cartToAdd.setNext​(endCart);
        ++size;
        return;
      }
      currCart = currCart.getNext();
    } while (currCart != null);
  }


  /*
   * Returns the cart at position index of this list without removing it
   * 
   * @param index - of the cart to return
   * 
   * @throws java.lang.IndexOutOfBoundsException - with the following error message "Invalid index."
   * if index is less than 0 or index is greater or equal to size()
   * 
   * @return the cart of this sorted list at the given index
   * 
   * 
   */
  @Override
  public Cart get(int index) throws IndexOutOfBoundsException {
    // checks index
    if (index < 0 || index >= this.size()) {
      throw new IndexOutOfBoundsException("Invalid index.");
    }
    LinkedCart currCart = head;
    // goes to index and returns cart
    for (int i = 0; i < index; ++i) {
      currCart = currCart.getNext();
    }
    return currCart.getCart();
  }

  /*
   * Returns the index of the cart carrying data within this list
   * 
   * @param findCart - cart to find in this list
   * 
   * @return the index of findCart within this list or -1 if this list does not contain that cart.
   */
  @Override
  public int indexOf(Cart findCart) {
    if (head == null) {
      return -1;
    }
    LinkedCart currCart = head;
    for (int i = 0; i < capacity; ++i) {
      if (currCart.getCart().toString().equals(findCart.toString())) {
        return i;
      }
      currCart = currCart.getNext();
      // check if it reached the end of the list
      if (currCart == null) {
        break;
      }
    }
    return -1;
  }

  /*
   * Reads the contents of this list in the forward direction starting from its head.
   * 
   * @return a String representation of the contents of this list read in the forward direction or
   * an empty string if this list is empty. For instance, if the list contains the following letters
   * "A", "B", "D", "M", and "O". This method MUST return the following string "ABDMO".
   */
  public String readForward() {
    String ret = "";
    LinkedCart currCart = head;
    while (currCart != null) {
      ret += currCart.getCart().toString();
      currCart = currCart.getNext();
    }
    return ret;
  }

  /*
   * Reads the contents of this list in the backward direction starting from its tail
   * 
   * @return a String representation of the contents of this list read in the backward direction or
   * an empty string if this list is empty. For instance, if the list contains the following letters
   * "A", "B", "D", "M", and "O". This method MUST return the following string "OMDBA".
   */
  public String readBackward() {
    String ret = "";
    LinkedCart currCart = tail;
    while (currCart != null) {
      ret += currCart.getCart().toString();
      currCart = currCart.getPrevious();
    }
    return ret;
  }

  /*
   * Returns and removes the cart from this sorted list at the given index position
   * 
   * @param index - of the cart to be removed
   * 
   * @throws java.lang.IndexOutOfBoundsException - with the following error message "Invalid index."
   * if index is less than 0 or index is larger or equal to size()
   * 
   * @return the removed cart
   */
  @Override
  public Cart remove(int index) {
    if (index < 0 || index >= size) {
      throw new java.lang.IndexOutOfBoundsException("Invalid index");
    }
    LinkedCart temp = head;
    int count = 0;
    while (temp != null) {
      if (count == index) { // Remove the cart
        LinkedCart current = temp;
        if (temp.getNext() != null) {
          temp.getNext().setPrevious​(current.getPrevious());
        }
        if (temp.getPrevious() != null) {
          temp.getPrevious().setNext​(current.getNext());
        }
        if (current == head) {
          head = current.getNext();
        }
        if (current == tail) {
          tail = current.getPrevious();
        }
        size--;
        return temp.getCart();
      }
      temp = temp.getNext();
      count++;
    }
    return null;
  }
}

