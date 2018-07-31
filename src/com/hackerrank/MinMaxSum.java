package com.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum
 * @author dfwandarti
 *
 */
public class MinMaxSum {

    // Complete the compareTriplets function below.
    static String miniMaxSum(int[] arr) {
    	List<Integer> sorted = Arrays.stream(arr).boxed().collect(Collectors.toList());
    	sorted.sort(null);
    	
    	long min = 0;
    	for(int i = 0; i < 4; i++) {
    		min += sorted.get(i);
    	}
    	
    	long max = 0;
    	for(int i = sorted.size() - 4; i < sorted.size(); i++) {
    		max += sorted.get(i);
    	}
    	
    	String ret = Long.toString(min) + " " + Long.toString(max);
    	
    	System.out.println(ret);
    	
    	return ret;
    }

    public static void main(String[] args) throws IOException {
    	// test case 1
    	int[] a1 = {1, 2, 3, 4, 5};
    	String ret = miniMaxSum(a1);
    	checkResult("Test1", ret, "10 14");
    	
    	// test case 2
    	int[] a2 = {1, 1, 1, 1, 5};
    	ret = miniMaxSum(a2);
    	checkResult("Test2", ret, "4 8");
    	
    	// test case 3
    	int[] a3 = {6, 5, 4, 3, 1000000000};
    	ret = miniMaxSum(a3);
    	checkResult("Test3", ret, "18 1000000015");
    	
    	// test case 4
    	int[] a4 = {1, 3, 5, 7, 9};
    	ret = miniMaxSum(a4);
    	checkResult("Test3", ret, "16 24");
    	
    	// test case 5
    	int[] a5 = {6, 1000000000, 1000000000, 1000000000, 1000000000};
    	ret = miniMaxSum(a5);
    	checkResult("Test3", ret, "3000000006 4000000000");
    	

    }
    
    
    private static void checkResult(String testName, String ret, String string) {
    	System.out.println("***************");
    	if (ret.equals(string)) {
    		System.out.println("OK " + testName);
    	} else {
    		System.out.println("FALHOU " + testName);
    	}
	}
    
    private static final Scanner scanner = new Scanner(System.in);
    public static void keepThis(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
