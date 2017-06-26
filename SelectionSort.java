
public class SelectionSort {

	private int minIndex;
	private int index;
	
	public SelectionSort() {
		minIndex = 0;
		index = 0;
	}
	
	private void swap(int[] arr, int i){
		int temp = 0;
		
		temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;
	}
	
	private void setMinIndex(int[] arr) {
		int iterator = index;
		minIndex = index;
		
		while(iterator < arr.length) {
			minIndex = getMinIndex(arr, iterator);
			iterator++;
		}
	}
	
	private int getMinIndex(int[] arr, int i) {
		if(arr[i] < arr[minIndex]) {
			minIndex = i;
		}
		return minIndex;
	}
	
	public int[] sort(int[] arr) {
		index = 0;
		
		while(index < arr.length - 1) {
			setMinIndex(arr);
			
			swap(arr, index);
			
			index++;
		}
		
		return arr;
	}
	
	public void display(int[] arr) {
		System.out.println("Selection Sort");
		for(int c : arr) {
			System.out.print(c + " ");
		}
	}
	
	public static void main(String[] args) {
		SelectionSort selection = new SelectionSort();
		int[] array = {2,3,6,9,5,3,65,28,5,-65,-6,0,659};
		
		selection.sort(array);
		selection.display(array);
	}
}
