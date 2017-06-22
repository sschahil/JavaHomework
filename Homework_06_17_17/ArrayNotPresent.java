
public class ArrayNotPresent {

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {2,3,1,0,5};
		int compare = 0;
		int index1 = 0;
		boolean check = false;

		for (int i = 0; i < arr1.length; i++) {
			compare = arr1[i];
			check = false;
			
			for (int j = 0; j < arr2.length; j++) {
				if (compare == arr2[j])
					check = true;
			}
			
			if (!check) {
				index1 = i;
				break;
			}
		}
		if(!check) {
			System.out.println("The number not present in array 2 but is in array 1 is: " + arr1[index1]);
		} else
			System.out.println("These two arrays are equal.");
		
	}
	
}
