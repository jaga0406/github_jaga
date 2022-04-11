package com.testscenarios;

public class DulpicateCharInString {

	public static void main(String[] args) {
		String abc = "jagannath";
		int count;
		char arr[] = abc.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			count = 1;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]==arr[j]&&arr[i]!=' ') {
					count++;
					arr[j] = '0';
				}
			}
			   if (count>1 && arr[i]!= '0') {
				System.out.println(arr[i]);
			} 
		}
     }
}
