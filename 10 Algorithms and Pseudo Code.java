1. Given string str = "aaabbbcccdddeeeffffggghijkkkkkhhhhmmm", find the alphabet that is repeated the most.
				        3  3  2  3  3   4  3 111  5   4   3	
	Algorithm

			Step 1: Create integer variables maxCount and count to hold the maximum count value and to count the number of repeats for each letter
			Step 2: Create a char variable letter to hold the value of the most repeated letter in the string
			Step 3: Make a for loop that iterates the length of the string minus 1 
			Step 4: Check if the letter has changed at the current index compared to the next index
			Step 5: If true increment the count for this letter
			Step 6: If false and maxCount is less than count, make maxCount equal to count and letter equal to the character in the string at the current index
			Step 7: Reset the count back to 1 
			Step 8: Get out of the for loop and create a if statement that checks count and maxCount again to account for the last run in the for loop
			Step 9: Print out the result

	Pseudo-Code

		int maxCount = 0, count = 1
		char letter = 0;

		for int i = 0; i less than str.length() minus 1; i++
			if str.charAt(i) equals str.charAt(i + 1)
				count++
			
			else 
				if maxCount less than count 
					maxCount = count
					letter = str.charAt(i)
				
				count = 1
		
		if count greater than maxCount
			maxCount = count
			letter = str.charAt(str.length() minus 1)
		
		
		System.out.println("The most repeated letter is: " + letter)			

2. How to convert a numeric String to integer in java
	Algorithm

			Step 1: Create a string that only has numbers in it called numStr
			Step 2: Create an empty integer variable strNum 
			Step 3: Make strNum equal to the parseInt of the numStr

	Pseudo-Code

			int strNum = 0
			String numStr = "101"

			strNum = Integer.parseInt(numStr)

3. Write a function to swap the value of two variables without using a third variable
	Algorithm

			Step 1: Create two int variables x and y
			Step 2: Have x equal to x plus y
			Step 3: Have y equal to x minus y
			Step 4: Have x equal to x minus y

	Pseudo-Code

			int x = 4, y = 17

			x = x + y = 21
			y = x - y = 4
			x = x - y = 17

4. Method to get a random number between a lower and upper limit number, randome number should be type float between 0 and 100
	Algorithm

			Step 1: This should accept two values of type int, lower and upper
			Step 2: Import Date class to use to make a random number
			Step 3: Create a float variable called randomNumber
			Step 4: Give value to randomNumber using the Date.getTime() as this will give you a different value every time
			Step 5: Create a while loop with conidtional statement that state if randomNumber is greater than upper limit or less than lower limit it should go into the while loop
			Step 6: If its greater than the upper limit divide the randomNumber each time by the current seconds by calendar.get(Calendar.SECONDS)
			Step 7: If is less than the lower limit multiply the randomnNumber each time by the current seconds by calendar.get(Calendar.SECONDS)

	Pseudo-Code

			import java.util.Date
			import java.util.Calendar

			public float randomNumber accept values (float lower and float upper) 
				
				Date date = new Date()
				Calendar calendar = Calendar.getInstance()
				
				float randomNumber

				randomNumber = (float) date.getTime()
				
				while randomNumber < lower || randomNumber > upper
					
					if randomNumber less than lower
						randomNumber *= calendar.get(Calendar.SECOND)
					
					if randomNumber greater than upper 
						randomNumber /= calendar.get(Calendar.SECOND)
				
			

5. Sort a list of numbers from ascending and descending order
	Algorithm

			Step 1:


	Pseudo-Code
 

6. Split a string at a whitespace "Hello my name is Johnny".
	Algorithm

			Step 1: Obtain a string 
			Step 2: Use "split" function for a string entering "\\s"
			Step 3: Use a for loop to print the results

	Pseudo-Code

			String str = "Hello my name is Johnny"

			String splitStr = str.split("\\s");

			for int i = 0; i is less than splitStr.length; i++
				System.out.println(splitStr[i])

7. How to find largest and smallest number in array?
	Algorithm

			Step 1: Create an array can be of any type but for this case an int array will do
			Step 2: Enter values into array by using a for loop, going the length of the array
			Step 3: After assigning all values go into another for loop, going the length of array
			Step 4: Create two variables max and min, that will contain the largest and smallest number in the array
			Step 5: Have both variables initialized to the first index of the array
			Step 6: Then have two if statements that will compare max and min to each index of the array past the first index
			Step 7: If max is less than the index the max will equal the value at the index
			Step 8: If min is greater than the index the min will equal the value at the index
			Step 9: Return the max and min values

	Pseudo-Code

			int[] arr = new int[10]
			int max, min

			for int i = 0; i is less than arr.length; i++
				arr[i] = i

			max = arr[0]
			min = arr[0]

			for int j = 1; j is less than arr.length; j++
				if max is less than arr[j]
					max = arr[j]
				if min is greater than arr[j]
					min = arr[j]

			System.out.println(max)
			System.out.println(min)

8. Given two arrays: 1,2,3,4,5 and 2,3,1,0,5 find which number is not present in the second array.
	Algorithm

			Step 1: Have two int array variables arr1 and arr2 that are the same length
			Step 2: Create a for loop that will go the length of the first array
			Step 3: Have a int variable hold each value of the first array
			Step 4: Create another for loop within that for loop that goes the length of the second array
			Step 5: In this for loop compare that int variable with each index of the second array
			Step 6: If the variable is equal to any value in the second array return true
			Step 7: If the variable is not equal to any value in the second array return false
			Step 8: Once it completes the inside for loop, if the inside for loop returns false the program should break out of both for loops and return the index value at which the array was not equal and print that value
			Step 9: If the inside for loop returns true, the program should print out that both arrays contain the other arrays values

	Pseudo-Code

			int[] arr1 = {1,2,3,4,5}
			int[] arr2 = {2,3,1,0,5}
			int comapre = 0;
			int index1 = 0;
			boolean check = false;

			for int i = 0; i is less than arr1.length; i++
				compare = arr1[i]
				check = false;

				for int j = 0; j is less than arr2.length; j++
					if compare is equal to arr2[j]
						check = true;

				if !check
					index1 = i
					break

			if(!check)
				System.out.println("The number not present in array 2 but is in array 1 is: " + arr1[index1])
			else
				System.out.println("These two arrays are equal.")

9. Write a program to find all prime number up to a given numbers?
	Algorithm

			Step 1: Have the user enter the number to which the prime numbers should be displayed
			Step 2: Create a for loop that goes to the number entered by the user
			Step 3: Create another for loop inside that for loop that starts at 2 and goes till before the last number entered
			Step 4: If the out loop iteration equals the inner iteration break out of the inner loop
			Step 5: if i modulus j is equal to zero then it should return true
			Step 6: Once out of the inside for loop, there should be a if statement 
			Step 7: If false it should print out the outside for loop iteration

	Pseudo-Code

			import java.util.Scanner

			static Scanner input = new Scanner(System.in)
			int primeNumber = 0
			boolean check = false

			System.out.println("Enter the number to which you would like to see prime numbers: ")
			primeNumber = input.nextInt()

			System.out.println("\n\nThe prime numbers up to " + primeNumber + "are: ")
			for int i = 1; i is less than or equal to primeNumber; i++
				check = false

				for int j = 2; j is less than primeNumber minus 1; j++
					if i == j
						break
					if i % j == 0
						check = true
				if(!check)
					System.out.print(i + " ")

10. Write function to compute Nth Fibonacci number?
	Algorithm

			Step 1: Have the user enter the length of the sequence, called fibLength
			Step 2: Create a for loop, that goes to fibLength
			Step 3: Create a integer array called fibNum that is the length of the sequence
			Step 4: Inside the for loop have the fibNum equal to the iteration number plus the (interation plus 1)
			Step 5: Print the fibNum array

	Pseudo-Code

			import java.util.Scanner;

			static Scanner input = new Scanner

			int fibLength = 0
			Tell user to enter the length of the sequence
			fibLength = input.nextInt()

			int[] fibNum = new int[fibLength]

			for int i = 0; i < fibNum.length; i++
				if i < 2
					fibNum[i] = 1
				else
					fibNum[i] = fibNum[i - 1] + fibNum[i - 2]

			Skip a couple lines and state this is the fib sequence and skip a line	
			for int j = 0; j < fibNum.length; i++
				System.out.print(fibNum[i])