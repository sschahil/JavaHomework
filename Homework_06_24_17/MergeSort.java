
public class MergeSort {
	private int size1, size2;
	private int[] temp1, temp2;
	
	public MergeSort() {
		size1 = 0;
		size2 = 0;
	}
	
	private int getSize1(int[] arr) {
		if(arr.length % 2 == 0) {
			size1 = arr.length / 2;
		}
		else {
			size1 = (arr.length / 2) + 1;
		}
		
		return size1;
	}
	
	private int getSize2(int[] arr) {
		if(arr.length % 2 == 0) {
			size2 = size1;
		}
		else {
			size2 = size1 - 1;
		}
		
		return size2;
	}
	
	private int[] fillTemp1(int[] arr) {
		int i = 0;
		temp1 = new int[getSize1(arr)];
		
		while(i < size1) {
			temp1[i] = arr[i];
			i++;
		}
		
		return arr;
	}
	
	private int[] fillTemp2(int[] arr) {
		int i = 0;
		temp2 = new int[getSize2(arr)];
		
		if(arr.length % 2 == 0) {
			while(i < size2) {
				temp2[i] = arr[size2 + i];
				i++;
			}
		}
		else {
			while(i < size2) {
				temp2[i] = arr[size2 + i + 1];
				i++;
			}
		}
		
		return arr;
	}
	
	private void sortTemp(int[] arr) {
		fillTemp1(arr);
		fillTemp2(arr);
		
		InsertionSort insert = new InsertionSort();
		InsertionSort insert2 = new InsertionSort();
		
		insert.sort(temp1);
		insert2.sort(temp2);
		
		for(int c : temp1) {
			System.out.print(c + " ");
		}
		System.out.println();
		for(int c : temp2) {
			System.out.print(c + " ");
		}
		System.out.println();
		
	}
	
	public void sort(int[] arr) {
		int i = 0, j = 0, k = 0;
		sortTemp(arr);
		
		while(i < size1 && j < size2) {
			
			if (temp1[i] <= temp2[j]) {
				arr[k] = temp1[i];
	                i++;
	        }
	        else {
	            arr[k] = temp2[j];
	            j++;
	        }
			k++;
	    }
		while(i < size1) {
			arr[k] = temp1[i];
			i++;
			k++;
		}
		while(j < size2) {
			arr[k] = temp2[j];
			j++;
			k++;
		}
	}
	
	public void display(int[] arr) {
		System.out.println("Merge Sort");
		for(int c : arr) {
			System.out.print(c + " ");
		}
	}
}
