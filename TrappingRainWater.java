package com.naveen.intechAdditive.Interview;

/*Java program to determine the amount of water will be trapped on the roof after heavy rainfall*/

public class TrappingRainWater {
	public static int maxWater(int[] input, int n) {
		/* initially result will be zero */
		int result = 0;

		/* traversing from 1st portion */
		for (int i = 1; i < n - 1; i++) {
			/* initially left side portion is same as current portion */
			int left = input[i];
			for (int j = 0; j < i; j++) {
				/* finding highest portion at left side */
				left = Math.max(left, input[j]);
			}

			int right = input[i];
			for (int j = i + 1; j < n; j++) {
				/* finding highest portion at right side */
				right = Math.max(right, input[j]);
			}

			/* calculating water value and finally adding to the result */
			result += Math.min(left, right) - input[i];
		}
		return result;
	}

	/* Driver method */
	public static void main(String[] args) {
		int[] input = { 2, 1, 3, 0, 1, 2, 3 };
		int n = input.length;
		/* calling a method and storeing the result in one variable */
		int max = maxWater(input, n);
		System.out.print(max + " units of water will be trapped");

	}
}
