
public class InsertionSort {
	private int value, i, j;
	
	public InsertionSort() {
		value = 0;
		i = 1;
		j = 0;
	}
	
	private void insertValue(int[] arr) {
		j = i - 1;
		
		while(j >= 0 && value < arr[j]) {
			arr[j + 1] = arr[j];
			j--;
		}
	}
	
	private void outerLoop(int[] arr) {
		while(i < arr.length) {
			value = arr[i];
			
			insertValue(arr);
			
			arr[j + 1] = value;
			i++;
		}
	}
	
	public void sort(int[] arr) {
		outerLoop(arr);
	}
	
	public void display(int[] arr) {
		System.out.println("Insertion Sort");
		for(int c : arr) {
			System.out.print(c + " ");
		}
	}
}
