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
 * This is the class for the implementation of LinkedCart class
 * 
 * @author SaiRahulReddyKondlapudi
 * @author AnkitReddySeelam
 */
public class LinkedCart {

  private final Cart CART;
  private LinkedCart previous;
  private LinkedCart next;

  /*
   * This is the constructor for the LinkedCart which takes in a param of Cart
   * 
   * @param cart this parameter of the type Cart
   */
  public LinkedCart(Cart cart) {
    CART = cart;
    this.previous = null;
    this.next = null;
  }

  /*
   * This is the constructor for LinkedCart which takes in three parameters
   * 
   * @param cart - which is a parameter of Cart
   * 
   * @param previous - which takes in a parameter of the type LinkedCart
   * 
   * @param next - which takes in a parameter of the type LinkedCart
   */
  public LinkedCart(Cart cart, LinkedCart previous, LinkedCart next) {
    this.CART = cart;
    this.previous = previous;
    this.next = next;
  }

  /*
   * This is the method which is used to retrieve the data in the cart
   * 
   */
  public Cart getCart() {
    return this.CART;
  }

  /*
   * This is the method which is used to get the previous pointed for the node
   * 
   * 
   */
  public LinkedCart getPrevious() {
    return this.previous;
  }

  /*
   * This is the method which is used to set the previous value in the node
   * 
   */
  public void setPrevious​(LinkedCart previous) {
    this.previous = previous;
  }

  /*
   * This is the method which is used to get the next value in the node
   * 
   */
  public LinkedCart getNext() {
    return this.next;
  }

  /*
   * This is the method which is used to set the next value of the node
   */
  public void setNext​(LinkedCart next) {
    this.next = next;
  }



}