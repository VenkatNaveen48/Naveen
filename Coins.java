package com.naveen.intechAdditive.Interview;

/*Java program to find the most optimum way to tender the exact change to the customers */

/*Importing utility classes*/
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Coins {
	public void exchangeMoney(int[] a, int amt) {
		/*
		 * by using Arrays.sort() we can sort the coins given in an array ,in the way
		 * the coins to be arranged or sorted
		 */
		Arrays.sort(a);
		/*
		 * i preferred PriorityQueue because the coins will arranged based on the
		 * Priority
		 */
		PriorityQueue<Integer> get = new PriorityQueue<Integer>();
		for (int i = a.length - 1; i >= 0; i--) {
			int sum = amt / a[i];
			amt %= a[i];
			for (int j = 1; j <= sum; j++) {
				/* adding the coin into the PriorityQueue by using the add() */
				get.add(a[i]);
			}
		}
		/* printing the coins from the PriorityQueue */
		System.out.println("the change to be given " + get);
	}
    /*Drivers method*/
	public static void main(String[] args) {
		/* to read the data using Scanner class */
		Scanner scn = new Scanner(System.in);
		System.out.println("enter the amout to be exchanged");
		/* amt variable represents the amount to be exchanged */
		int amt = scn.nextInt();
		/* list of available coins stored in an Array */
		int[] a = { 1, 2, 5, 8, 10 };
		Coins c = new Coins();
		/* calling the method */
		c.exchangeMoney(a, amt);
		scn.close();
	}
}
