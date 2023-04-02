package com.naveen.intechAdditive.Interview;

/*Java program to print the largest possible number by removing one digit from given Number*/
public class GreedyAlgo {
	/* this method is used to check all the possible outcomes and gives the maximum
	   value*/
	 
	public void printMax(String num) {
		int ans = 0;

		for (int i = 0; i < num.length(); i++) {
			String replaceFirst = num.replaceFirst(num.charAt(i) + "", "");
			int parseInt = Integer.parseInt(replaceFirst);
			if (ans < parseInt)
				ans = parseInt;
		}

		System.out.println(ans);

	}

	/* Driver method */
	public static void main(String[] args) {
		GreedyAlgo greedyAlgo = new GreedyAlgo();
		/* calling the method to check for required output */
		greedyAlgo.printMax("1234");
		greedyAlgo.printMax("2945");
		greedyAlgo.printMax("9273");
		greedyAlgo.printMax("3954");
		greedyAlgo.printMax("19374");
	}

}
