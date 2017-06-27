
public class BubbleSort {
	
	private int outsideI, insideI;
	
	public BubbleSort() {
		outsideI = 0;
		insideI = 0;
	}
	
	public void sort(int[] arr) {
		if(outsideI < arr.length) {
			compare(arr);
		}
	}
	
	private void compare(int[] arr) {
		insideI = 1;
		
		while(insideI < arr.length) {
			swap(arr);
			insideI++;
		}
		
		outsideI++;
		sort(arr);
	}
	
	private void swap(int[] arr) {
		int temp;
		if(arr[insideI - 1] > arr[insideI]) {
			temp = arr[insideI];
			arr[insideI] = arr[insideI - 1];
			arr[insideI - 1] = temp;
		}
	}
	
	public void displaySort(int[] arr) {
		System.out.println("Sorted Array");
		for(int c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BubbleSort bubble = new BubbleSort();
		int[] array = {15,65165,512,-54,654,0,6,6,8136,85,20};
		
		bubble.sort(array);
		bubble.displaySort(array);
	}
}
