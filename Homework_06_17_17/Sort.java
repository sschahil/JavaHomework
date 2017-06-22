
public class Sort {

	public static void main(String[] args) {
		
		int[] arr = {2,1,3,8,9,6,5,4,0};
		int minIndex;
		
		for(int i = 0; i < arr.length - 1; i++) {
			
			minIndex = i;
			
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[minIndex] > arr[j])
					minIndex = j;
			}
			
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
	}
	
}
