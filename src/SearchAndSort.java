import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchAndSort {
	
	/**
	 * Program execution starts here.
	 * 
	 * @param args
	 */
	
	static ArrayList<String> stringList;
	static String[] stringArray;
	static ArrayList<Integer> intList;
	static int[] intArray;
	
	public static int type;
	
	public static void main(String[] args) throws Exception {
		boolean done = false;
		do {
			//initialize static variables
			stringList = new ArrayList<String>();
			intList = new ArrayList<Integer>();
			
			Scanner in = new Scanner(System.in);
			
			//variable to hold user input
			String algorithm;
			String dataFormat;
			String storageMethod;
			String[] data;
			
			//user input types
			String[] algorithmTypes = {"bubble", "selection", "insertion", "merge", "linear", "binary", "quit"};
			String[] dataTypes = {"integers", "strings"};
			String[] storageTypes = {"list", "array"};
			
			//correct user input?
			boolean valid = false;
			
			//prompt for algorithm type
			do {
				//get and check algorithm type
				System.out.println("What algorithm would you like to execute? Acceptable responses: bubble, selection, insertion, merge, linear, binary, quit (all case-insensitive).");
				algorithm = in.next().toLowerCase();
				for(int i = 0; i < algorithmTypes.length - 1; i++) {
					if(algorithm.equals(algorithmTypes[i])) {
						valid = true;
					}
					if(algorithm.equals("quit")) {
						System.out.println("Ok, bye!");
						done = true;
						in.close();
						return;
					}
				}
				if(!valid) {
					System.out.println("Incorrect input. Try again.");
				}
			}while(!valid);
			
			valid = false;
			
			//prompt for data type
			do {
				System.out.println("What type of data? Acceptable responses: integers, strings.");
				dataFormat = in.next().toLowerCase();
				for(int i = 0; i < dataTypes.length; i++) {
					if(dataFormat.equals(dataTypes[i])) {
						valid = true;
					}
					if(algorithm.equals("quit")) {
						System.out.println("Ok, bye!");
						done = true;
						in.close();
						return;
					}
				}
				if(!valid) {
					System.out.println("Incorrect input. Try again.");
				}
			}while(!valid);
			
			valid = false;
			
			//prompt for storage type
			do {
				System.out.println("How is it stored? Acceptable responses: array, list.");
				storageMethod = in.next().toLowerCase();
				for(int i = 0; i < storageTypes.length; i++) {
					if(storageMethod.equals(storageTypes[i])) {
						valid = true;
					}
					if(storageMethod.equals("quit")) {
						System.out.println("Ok, bye!");
						done = true;
						in.close();
						return;
					}
				}
				if(!valid) {
					System.out.println("Incorrect input. Try again.");
				}
			}while(!valid);
			
			valid = true;
			
			int[] tempArray = null;
			
			//prompt for data type
			do {
				System.out.println("Enter data. Acceptable responses: a commma-delimited list of data (i.e. 1,2,3,4,5).");
				data = in.next().split(",");
				if(dataFormat.equals("integers")) {
					try {
						tempArray = new int[data.length];
						for(int i = 0; i < tempArray.length; i++) {
							tempArray[i] = Integer.parseInt(data[i]);
						}
						valid = true;
					}
					catch(NumberFormatException ex){
						System.out.println("Incorrect input. Try again.");
						valid = false;
					}				
				}
			}while(!valid);
			
			//set data into correct data type
			if(dataFormat.equals("strings") && storageMethod.equals("array")) {
				stringArray = data;
				type = 1;
			}
			else if(dataFormat.equals("integers") && storageMethod.equals("array")) {
				intArray = tempArray;
				type = 2;
			}
			else if(dataFormat.equals("strings") && storageMethod.equals("list")) {
				for(int i = 0; i < data.length; i++) {
					stringList.add(i, data[i]);
				}
				type = 3;
			}
			else if(dataFormat.equals("integers") && storageMethod.equals("list")) {
				for(int i = 0; i < tempArray.length; i++) {
					intList.add(i, tempArray[i]);
				}
				type = 4;
			}
			
			//call different algorithms
			switch(algorithm){
				case "bubble":
					//stringArray
					if(type == 1) {
						bubble(stringArray);
						System.out.print("bubble: [ ");
						for(int i = 0; i < stringArray.length - 1; i++) {
							System.out.print(stringArray[i] + ", ");
						}
						System.out.print(stringArray[stringArray.length - 1] + "]");					
						stringArray = null;
					}
					else if(type == 2) {
						bubble(intArray);
						System.out.print("bubble: [ ");
						for(int i = 0; i < intArray.length - 1; i++) {
							System.out.print(intArray[i] + ", ");
						}
						System.out.print(intArray[intArray.length - 1] + "]");
						intArray = null;
					}
					else if(type == 3) {
						bubble(3);
						System.out.print("bubble: [ ");
						for(int i = 0; i < stringList.size() - 1; i++) {
							System.out.print(stringList.get(i) + ", ");
						}
						System.out.print(stringList.get(stringList.size() - 1) + "]");
						stringList = null;
					}
					else {
						bubble(4);
						System.out.print("bubble: [ ");
						for(int i = 0; i < intList.size() - 1; i++) {
							System.out.print(intList.get(i) + ", ");
						}
						System.out.print(intList.get(intList.size() - 1) + "]");
						intList = null;
					}
					break;
				case "selection":
					//stringArray
					if(type == 1) {
						selection(stringArray);
						System.out.print("selection: [ ");
						for(int i = 0; i < stringArray.length - 1; i++) {
							System.out.print(stringArray[i] + ", ");
						}
						System.out.print(stringArray[stringArray.length - 1] + "]");
						stringArray = null;
					}
					else if(type == 2) {
						selection(intArray);
						System.out.print("selection: [ ");
						for(int i = 0; i < intArray.length - 1; i++) {
							System.out.print(intArray[i] + ", ");
						}
						System.out.print(intArray[intArray.length - 1] + "]");
						intArray = null;
					}
					else if(type == 3) {
						selection(3);
						System.out.print("selection: [ ");
						for(int i = 0; i < stringList.size() - 1; i++) {
							System.out.print(stringList.get(i) + ", ");
						}
						System.out.print(stringList.get(stringList.size() - 1) + "]");
						stringList = null;
					}
					else {
						selection(4);
						System.out.print("selection: [ ");
						for(int i = 0; i < intList.size() - 1; i++) {
							System.out.print(intList.get(i) + ", ");
						}
						System.out.print(intList.get(intList.size() - 1) + "]");
						intList = null;
					}
					break;
				case "insertion":
					if(type == 1) {
						insertion(stringArray);
						System.out.print("insertion: [ ");
						for(int i = 0; i < stringArray.length - 1; i++) {
							System.out.print(stringArray[i] + ", ");
						}
						System.out.print(stringArray[stringArray.length - 1] + "]");					
						stringArray = null;
					}
					else if(type == 2) {
						insertion(intArray);
						System.out.print("insertion: [ ");
						for(int i = 0; i < intArray.length - 1; i++) {
							System.out.print(intArray[i] + ", ");
						}
						System.out.print(intArray[intArray.length - 1] + "]");
						intArray = null;
					}
					else if(type == 3) {
						insertion(3);
						System.out.print("insertion: [ ");
						for(int i = 0; i < stringList.size() - 1; i++) {
							System.out.print(stringList.get(i) + ", ");
						}
						System.out.print(stringList.get(stringList.size() - 1) + "]");
						stringList = null;
					}
					else {
						insertion(4);
						System.out.print("insertion: [ ");
						for(int i = 0; i < intList.size() - 1; i++) {
							System.out.print(intList.get(i) + ", ");
						}
						System.out.print(intList.get(intList.size() - 1) + "]");
						intList = null;
					}
					break;
				case "merge":
					if(type == 1) {
						splitForMerge(stringArray, stringArray.length);
						System.out.print("merge: [ ");
						for(int i = 0; i < stringArray.length - 1; i++) {
							System.out.print(stringArray[i] + ", ");
						}
						System.out.print(stringArray[stringArray.length - 1] + "]");					
						stringArray = null;
					}
					else if(type == 2) {
						splitForMerge( intArray, intArray.length);
						System.out.print("merge: [ ");
						for(int i = 0; i < intArray.length - 1; i++) {
							System.out.print(intArray[i] + ", ");
						}
						System.out.print(intArray[intArray.length - 1] + "]");
						intArray = null;
					}
					else if(type == 3) {
						stringArray = new String[stringList.size()];
						for(int i = 0; i < stringList.size(); i++) {
							stringArray[i] = stringList.get(i);
						}
						splitForMerge(stringArray, stringArray.length);
						for(int i = 0; i < stringArray.length; i++) {
							stringList.set(i, stringArray[i]);
						}
						stringArray = null;
						System.out.print("merge: [ ");
						for(int i = 0; i < stringList.size() - 1; i++) {
							System.out.print(stringList.get(i) + ", ");
						}
						System.out.print(stringList.get(stringList.size() - 1) + "]");
						stringList = null;
					}
					else {
						splitForMerge(intList, intList.size());
						System.out.print("merge: [ ");
						for(int i = 0; i < intList.size() - 1; i++) {
							System.out.print(intList.get(i) + ", ");
						}
						System.out.print(intList.get(intList.size() - 1) + "]");
						intList = null;
					}
					break;
				case "linear":
					if(type == 1) {
						System.out.println("What string are you looking for?");
						String key = in.next();
						int index = linear(stringArray, key);
						if(index > -1) {
							System.out.println("The string \"" + key +"\" was found at index " + index + ".");
						}
						else {
							System.out.println("The string \"" + key +"\" was not found in the array provided.");
						}				
						stringArray = null;
					}
					else if(type == 2) {
						valid = true;
						int key = 0;
						do {
							valid = true;
							System.out.println("What integer are you looking for?");
							try {
								key = Integer.parseInt(in.next());
							}catch(NumberFormatException e) {
								System.out.println("Invalid input. Try again.");
								valid = false;
							}
						}while(!valid);
						int index = linear(intArray, key);
						if(index > -1) {
							System.out.println("The integer \"" + key +"\" was found at index " + index + ".");
						}
						else {
							System.out.println("The integer \"" + key +"\" was not found in the array provided.");
						}				
						intArray = null;
					}
					else if(type == 3) {
						System.out.println("What string are you looking for?");
						String key = in.next();
						stringArray = new String[stringList.size()];
						for(int i = 0; i < stringList.size(); i++) {
							stringArray[i] = stringList.get(i);
						}
						int index = linear(stringArray, key);
						if(index > -1) {
							System.out.println("The string \"" + key +"\" was found at index " + index + ".");
						}
						else {
							System.out.println("The string \"" + key +"\" was not found in the list provided.");
						}			
						stringArray = null;
						stringList = null;
					}
					else {
						valid = true;
						int key = 0;
						do {
							valid = true;
							System.out.println("What integer are you looking for?");
							try {
								key = Integer.parseInt(in.next());
							}catch(NumberFormatException e) {
								System.out.println("Invalid input. Try again.");
								valid = false;
							}
						}while(!valid);
						intArray = new int[intList.size()];
						for(int i = 0; i < intList.size(); i++) {
							intArray[i] = intList.get(i);
						}
						int index = linear(intArray, key);
						if(index > -1) {
							System.out.println("The integer \"" + key +"\" was found at index " + index + ".");
						}
						else {
							System.out.println("The integer \"" + key +"\" was not found in the array provided.");
						}				
						intArray = null;
						intList = null;
					}
					break;
				case "binary":
					if(type == 1) {
						bubble(stringArray);
						System.out.println("What string are you looking for?");
						String key = in.next();
						int index = binary(stringArray, 0, stringArray.length - 1, key);
						if(index > -1) {
							System.out.println("The string \"" + key +"\" was found in the sorted array at index " + index + ".");
						}
						else {
							System.out.println("The string \"" + key +"\" was not found in the array provided.");
						}				
						stringArray = null;
					}
					else if(type == 2) {
						bubble(intArray);
						valid = true;
						int key = 0;
						do {
							valid = true;
							System.out.println("What integer are you looking for?");
							try {
								key = Integer.parseInt(in.next());
							}catch(NumberFormatException e) {
								System.out.println("Invalid input. Try again.");
								valid = false;
							}
						}while(!valid);
						int index = binary(intArray, 0, intArray.length - 1, key);
						if(index > -1) {
							System.out.println("The integer \"" + key +"\" was found in the sorted array at index " + index + ".");
						}
						else {
							System.out.println("The integer \"" + key +"\" was not found in the array provided.");
						}				
						intArray = null;
					}
					else if(type == 3) {
						bubble(3);
						System.out.println("What string are you looking for?");
						String key = in.next();
						stringArray = new String[stringList.size()];
						for(int i = 0; i < stringList.size(); i++) {
							stringArray[i] = stringList.get(i);
						}
						int index = binary(stringArray, 0, stringArray.length - 1, key);
						if(index > -1) {
							System.out.println("The string \"" + key +"\" was found int the sorted array at index " + index + ".");
						}
						else {
							System.out.println("The string \"" + key +"\" was not found in the list provided.");
						}			
						stringArray = null;
						stringList = null;
					}
					else {
						bubble(4);
						valid = true;
						int key = 0;
						do {
							valid = true;
							System.out.println("What integer are you looking for?");
							try {
								key = Integer.parseInt(in.next());
							}catch(NumberFormatException e) {
								System.out.println("Invalid input. Try again.");
								valid = false;
							}
						}while(!valid);
						intArray = new int[intList.size()];
						for(int i = 0; i < intList.size(); i++) {
							intArray[i] = intList.get(i);
						}
						int index = binary(intArray, 0, intArray.length - 1, key);
						if(index > -1) {
							System.out.println("The integer \"" + key +"\" was found in the sorted array at index " + index + ".");
						}
						else {
							System.out.println("The integer \"" + key +"\" was not found in the array provided.");
						}				
						intArray = null;
						intList = null;
					}
					break;
				default:
					System.out.println("Error! Check algorithm switch case!");
					break;
			}	
			System.out.println("\n\n");
		}while(!done);
	}
	
	//bubble sort for string array
	public static void bubble(String[] array) {
		boolean sorted = false;
		do {
			sorted = true;
			for(int i = 1; i < array.length; i++) {
				if(array[i].compareTo(array[i - 1]) < 0) {
					sorted = false;
					String temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
				}
			}
		}while(!sorted);
	}
	
	//bubble sort for int array
	public static void bubble(int[] array) {
		boolean sorted = false;
		do {
			sorted = true;
			for(int i = 1; i < array.length; i++) {
				if(array[i] < array[i-1]) {
					sorted = false;
					int temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
				}
			}
		}while(!sorted);
	}
	
	//bubble sort for lists
	public static void bubble(int type){
		boolean sorted = false;
		if(type == 3) {
			do {
				sorted = true;
				for(int i = 1; i < stringList.size(); i++) {
					if(stringList.get(i).compareTo(stringList.get(i - 1)) < 0) {
						sorted = false;
						String temp = stringList.get(i);
						stringList.set(i, stringList.get(i-1));
						stringList.set(i - 1, temp);
					}
				}
			}while(!sorted);
		}
		else {
			do {
				sorted = true;
				for(int i = 1; i < intList.size(); i++) {
					if(intList.get(i) < intList.get(i - 1)) {
						sorted = false;
						int temp = intList.get(i);
						intList.set(i, intList.get(i-1));
						intList.set(i - 1, temp);
					}
				}
			}while(!sorted);
		}
	}
	
	//selection sort for string array
	public static void selection(String[] stringArray) {
		for(int i = 0; i < stringArray.length - 1; i++) {
			int minIndex = i;
			String min = stringArray[i];
			for(int j = i + 1; j < stringArray.length; j++) {
				if(min.compareTo(stringArray[j]) > 0) {
					min = stringArray[j];
					minIndex = j;
				}
			}
			for(int k = minIndex; k > i; k--) {
				stringArray[k] = stringArray[k-1];
			}
			stringArray[i] = min;
		}
	}
	
	//selection sort for int array
	public static void selection(int[] intArray) {
		for(int i = 0; i < intArray.length - 1; i++) {
			int minIndex = i;
			int min = intArray[i];
			for(int j = i + 1; j < intArray.length; j++) {
				if(min > intArray[j]) {
					min = intArray[j];
					minIndex = j;
				}
			}
			for(int k = minIndex; k > i; k--) {
				intArray[k] = intArray[k-1];
			}
			intArray[i] = min;
		}
	}
	
	//selection sort for lists
	public static void selection(int type) {
		//sort for stringList
		if(type == 3) {
			for(int i = 0; i < stringList.size() - 1; i++) {
				int minIndex = i;
				String min = stringList.get(i);
				for(int j = i + 1; j < stringList.size(); j++) {
					if(min.compareTo(stringList.get(j)) > 0) {
						min = stringList.get(j);
						minIndex = j;
					}
				}
				for(int k = minIndex; k > i; k--) {
					stringList.set(k, stringList.get(k-1));
				}
				stringList.set(i, min);
			}
		}
		//sort for intList
		else {
			for(int i = 0; i < intList.size() - 1; i++) {
				int minIndex = i;
				int min = intList.get(i);
				for(int j = i + 1; j < intList.size(); j++) {
					if(min > intList.get(j)) {
						min = intList.get(j);
						minIndex = j;
					}
				}
				for(int k = minIndex; k > i; k--) {
					intList.set(k, intList.get(k-1));
				}
				intList.set(i, min);
			}
		}
	}
	
	//insertion sort for stringArray
	public static void insertion(String[] array) {
		for(int i = 1; i < array.length; ++i) {
			int counter = i - 1;
			String temp = array[i];
			while(counter >= 0 && array[counter].compareTo(temp) > 0) {
				array[counter + 1] = array[counter];
				counter--;
			}
			array[counter + 1] = temp;
		}
	}
	
	//insertion sort for intArray
	public static void insertion(int[] array) {
		for(int i = 1; i < array.length; ++i) {
			int counter = i - 1;
			int temp = array[i];
			while(counter >= 0 && array[counter] > temp) {
				array[counter + 1] = array[counter];
				counter--;
			}
			array[counter + 1] = temp;
		}
	}
	
	//insertion sort for lists
	public static void insertion(int type) {
		//sort for stringList
		if(type == 3) {
			for(int i = 1; i < stringList.size(); ++i) {
				int counter = i - 1;
				String temp = stringList.get(i);
				while(counter >= 0 && stringList.get(counter).compareTo(temp) > 0) {
					stringList.set(counter + 1, stringList.get(counter));
					counter--;
				}
				stringList.set(counter + 1, temp);
			}
		}
		//sort for intList
		else {
			for(int i = 1; i < intList.size(); ++i) {
				int counter = i - 1;
				int temp = intList.get(i);
				while(counter >= 0 && intList.get(counter) > temp) {
					intList.set(counter + 1, intList.get(counter));
					counter--;
				}
				intList.set(counter + 1, temp);
			}
		}
	}
	
	//merge sort for stringArray
	public static void splitForMerge(String[] stringArray, int length) {
		if(length < 2) {
			return;
		}
		
		int midPoint = length / 2;
		
		String[] array1 = new String[midPoint];
		String[] array2 = new String[length - midPoint];
		
		//set values for temp arrays
		for(int i = 0; i < midPoint; i++) {
			array1[i] = stringArray[i];
		}
		for(int i = midPoint; i < length; i++) {
			array2[i - (midPoint)] = stringArray[i];
		}
		
		splitForMerge(array1, midPoint);
		splitForMerge(array2, length - midPoint);
		
		merge(stringArray, array1, array2, midPoint, length - midPoint);
		
	}
	
	public static void merge(String[] stringArray, String[] array1, String[] array2, int length1, int length2) {
		int counter1 = 0;
		int counter2 = 0;
		int arrayCounter = 0;
		while(counter1 < length1 && counter2 < length2) {
			if(array1[counter1].compareTo(array2[counter2]) <= 0) {
				stringArray[arrayCounter] = array1[counter1];
				arrayCounter++;
				counter1++;
			}
			else {
				stringArray[arrayCounter] = array2[counter2];
				arrayCounter++;
				counter2++;
			}
		}
		//leftovers in either array
		while(counter1 < length1) {
			stringArray[arrayCounter] = array1[counter1];
			arrayCounter++;
			counter1++;
		}
		while(counter2 < length2) {
			stringArray[arrayCounter] = array2[counter2];
			arrayCounter++;
			counter2++;
		}
	}
	
	//merge sort for intArray
	public static void splitForMerge(int[] intArray, int length) {
		if(length < 2) {
			return;
		}
		
		int midPoint = length / 2;
		
		int[] array1 = new int[midPoint];
		int[] array2 = new int[length - midPoint];
		
		//set values for temp arrays
		for(int i = 0; i < midPoint; i++) {
			array1[i] = intArray[i];
		}
		for(int i = midPoint; i < length; i++) {
			array2[i - (midPoint)] = intArray[i];
		}
		
		
		splitForMerge(array1, midPoint);
		splitForMerge(array2, length - midPoint);
		
		merge(intArray, array1, array2, midPoint, length - midPoint);
	}

	public static void merge(int[] intArray, int[] array1, int[] array2, int length1, int length2) {
		int counter1 = 0;
		int counter2 = 0;
		int arrayCounter = 0;
		while(counter1 < length1 && counter2 < length2) {
			if(array1[counter1] <= array2[counter2]) {
				intArray[arrayCounter] = array1[counter1];
				arrayCounter++;
				counter1++;
			}
			else {
				intArray[arrayCounter] = array2[counter2];
				arrayCounter++;
				counter2++;
			}
		}
		//leftovers in either array
		while(counter1 < length1) {
			intArray[arrayCounter] = array1[counter1];
			arrayCounter++;
			counter1++;
		}
		while(counter2 < length2) {
			intArray[arrayCounter] = array2[counter2];
			arrayCounter++;
			counter2++;
		}
	}
	
	public static void splitForMerge(ArrayList<Integer> intList, int length) {
		if(length < 2) {
			return;
		}
		
		int midPoint = length / 2;
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		//set values for temp arrays
		for(int i = 0; i < midPoint; i++) {
			list1.add(i, intList.get(i));
		}
		for(int i = midPoint; i < length; i++) {
			list2.add(i - midPoint, intList.get(i));
		}
		
		
		splitForMerge(list1, midPoint);
		splitForMerge(list2, length - midPoint);
		
		merge(intList, list1, list2, midPoint, length - midPoint);
	}
	
	public static void merge(ArrayList<Integer> intList, ArrayList<Integer> list1, ArrayList<Integer> list2, int length1, int length2) {
		int counter1 = 0;
		int counter2 = 0;
		int listCounter = 0;
		while(counter1 < length1 && counter2 < length2) {
			if(list1.get(counter1) < list2.get(counter2)) {
				intList.set(listCounter, list1.get(counter1));
				listCounter++;
				counter1++;
			}
			else {
				intList.set(listCounter, list2.get(counter2));
				listCounter++;
				counter2++;
			}
		}
		//leftovers in either array
		while(counter1 < length1) {
			intList.set(listCounter, list1.get(counter1));
			listCounter++;
			counter1++;
		}
		while(counter2 < length2) {
			intList.set(listCounter, list2.get(counter2));
			listCounter++;
			counter2++;
		}
	}
	
	public static int linear(String[] stringArray, String key) {
		int index = -1;
		for(int i = 0; i < stringArray.length; i++) {
			if(stringArray[i].compareTo(key) == 0) {
				index = i;
			}
		}
		return index;
	}
	
	public static int linear(int[] intArray, int key) {
		int index = -1;
		for(int i = 0; i < intArray.length; i++) {
			if(intArray[i] == key) {
				index = i;
			}
		}
		return index;
	}
	
	public static int binary(String[] stringArray, int lower, int upper, String key) {
		int midPoint = (int)(lower + (upper - lower) / 2);;
		if(upper > 0 && midPoint <= upper) {
			midPoint = (int)(lower + (upper - lower) / 2);
			if(stringArray[midPoint].compareTo(key) == 0) {
				return midPoint;
			}
			if(stringArray[midPoint].compareTo(key) > 0) {
				return binary(stringArray, lower, midPoint - 1, key);
			}
			return binary(stringArray, midPoint + 1, upper, key);
		}
		
		return -1;
	}
	
	public static int binary(int[] intArray, int lower, int upper, int key) {
		int midPoint = (int)(lower + (upper - lower) / 2);;
		if(upper > 0 && midPoint <= upper) {
			midPoint = (int)(lower + (upper - lower) / 2);
			if(intArray[midPoint] == key) {
				return midPoint;
			}
			if(intArray[midPoint] > key) {
				return binary(intArray, lower, midPoint - 1, key);
			}
			return binary(intArray, midPoint + 1, upper, key);
		}
		return -1;
	}
}