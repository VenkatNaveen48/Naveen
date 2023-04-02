package com.naveen.intechAdditive.Interview;

/*Java program to implement methods to perform String compression*/

/*Importing utility classes*/
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCompression {

	/* this method is written by using regular expression by using Pattern and
	    Matcher classes from java.util.regex*/

	public String compress1(String s) {
		/* compile is a Static method of Pattern class which takes String type regular
		   expression as an parameter and returns the Pattern type */
		
		Pattern p = Pattern.compile("([a-zA-Z])\\1*");
		/* matcher is a non-static method of pattern class */
		Matcher m = p.matcher(s);
		String s1 = "";
		while (m.find()) {
			s1 += m.group().charAt(0) + "" + m.group().length();

		}
		return s1;
	}

	/* this method is written by using regular expression by using Pattern and
	   Matcher classes from java.util.regex*/
	 
	public String compress2(String str) {
		Pattern p = Pattern.compile("[a-zA-Z][0-9]+");
		Matcher m = p.matcher(str);
		String s1 = "";

		LinkedList<String> list = new java.util.LinkedList<String>();

		while (m.find()) {
			list.add(m.group());
		}

		for (int i = 0; i < list.size(); i++) {
			int c = 0;

			String num1 = list.get(i).replace(list.get(i).charAt(0) + "", "");
			/* by using parseInt() we are converting String type to int type */
			int n = Integer.parseInt(num1);

			for (int j = i + 1; j < list.size(); j++) {
				String num2 = list.get(j).replace(list.get(j).charAt(0) + "", "");

				if (num1.equals(num2)) {
					c++;
				} else {
					break;
				}

			}

			StringBuilder ans = new StringBuilder("");

			for (int k = i; k <= i + c; k++) {
				String num = list.get(k);
				char ch = num.charAt(0);
				ans.append(ch);
			}
			/* append is a method used to add a value to the current sequence */
			ans.append(n);
			s1 += ans.toString();
			i += c;

		}
		return s1;

	}

	/* this method is written by using regular expression by using Pattern and
	   Matcher classes from java.util.regex*/
	 
	public String decompress(String s) {
		Pattern p = Pattern.compile("[a-zA-Z]+[0-9]+");
		Matcher m = p.matcher(s);
		String s1 = "";
		while (m.find()) {
			String n = m.group();

			String n1 = n.replaceAll("[a-zA-Z]+", "");

			String temp = n.replaceAll("[0-9]+", "");

			int num = Integer.parseInt(n1);

			StringBuilder ans = new StringBuilder("");

			for (int i = 0; i < temp.length(); i++) {
				int z = num;
				char ch = temp.charAt(i);
				while (z > 0) {
					ans.append(ch);
					z--;
				}

			}

			s1 += ans;

		}
		return s1;

	}

	/* Driver method */
	public static void main(String[] args) {
		StringCompression s = new StringCompression();
		/* to read the data using Scanner class */
		Scanner scn = new Scanner(System.in);
		System.out.println("enter the String");
		String s1 = scn.next();
		String s2 = s.compress1(s1);
		System.out.println(s2);
		String s3 = s.compress2(s2);
		System.out.println(s3);
		String s4 = s.decompress(s3);
		System.out.println(s4);
		scn.close();
	}

}
