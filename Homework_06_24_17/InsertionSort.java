
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
	
	public static void main(String[] args) {
		InsertionSort insert = new InsertionSort();
		int[] array = {6,65,31,86,3,-5,89,-65,0,65,9,9,3,5,88,-533,56,4};
		
		insert.sort(array);
		insert.display(array);
	}
}
