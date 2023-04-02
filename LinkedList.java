package com.naveen.intechAdditive.Interview;

/* Linked List implementation with some basic methods and 
 * it also consists a method to find Kth to the last element in the List  
 */
public class LinkedList {
	Node head;
	int size;
	Node last;
	
	/* an inner class for Node which indicates each node in the list */

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
		Node(int d, Node n) {
			data = d;
			next = n;
		}
	}
  /*
   * Method to find the Kth to the last element in the list 
   */
	void printKthToLast(int K) {
		Node cur = head;

		for (int i = 1; i < K; i++) {
			if (cur == null)
				break;
			cur = cur.next;
		}

		for (int i = K; i <= size; i++) {
			System.out.print(cur.data + " ");
			if (cur != null)
				cur = cur.next;
		}
		System.out.println();
	}
    /*
     * method to print the nth element in the list 
     */
	Integer printNthFromLast(int N) {
		Node cur = head;

		for (int i = 1; i < N; i++) {
			if (cur == null)
				break;
			cur = cur.next;
		}
		if (cur == null) {
			System.out.println("value of N is not more than length of linked list");
		} else {
			return cur.data;
		}
		return null;
	}
	
   /* method to push an element into the Linked L:ist */
	
	public void push(int new_data) {
		if (head == null) {
			head = new Node(new_data);
			last = head;
			size++;
			return;
		}

		last.next = new Node(new_data, null);

		last = last.next;
		size++;
	}

	/* Drivers method to test the functionalities of the list  */
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.push(35);
		llist.push(15);
		llist.push(4);
		llist.push(20);
		System.out.println("the element at Nth position is " + llist.printNthFromLast(3));
		llist.printKthToLast(3);
	}
}
