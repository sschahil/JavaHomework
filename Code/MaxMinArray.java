
public class MaxMinArray {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		int max, min;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 10;
			System.out.print(arr[i] + " ");
		}
		
		max = arr[0];
		min = arr[0];
		
		for (int j = 1; j < arr.length; j++) {
			if (max < arr[j])
				max = arr[j];
			if (min > arr[j])
				min = arr[j];
		}
		
		System.out.println("\nThe max value in the array is: " + max);
		System.out.println("The min value in the array is: " + min);
		
	}
	
}
