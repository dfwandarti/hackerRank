

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 * @author dfwandarti
 *
 */
public class CompareTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	List<Integer> ret = new ArrayList<Integer>(Arrays.asList(0, 0));
    	
    	for(int i = 0; i < a.size(); i++) {
    		if (a.get(i) > b.get(i)) {
    			ret.set(0,  ret.get(0) + 1);
    		} else {
    			if (a.get(i) < b.get(i)) {
        			ret.set(1,  ret.get(1) + 1);
        		}
    		}
		}
    	
    	return ret;
    }

    public static void main(String[] args) throws IOException {
    	// test case 1
    	List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
    	List<Integer> b = new ArrayList<Integer>(Arrays.asList(3, 2, 1));
    	List<Integer> ret = compareTriplets(a, b);
    	checkResult("Test1", ret, new ArrayList<Integer>(Arrays.asList(1, 1)));
    	
    	// test case 2
    	a = new ArrayList<Integer>(Arrays.asList(17, 28, 30));
    	b = new ArrayList<Integer>(Arrays.asList(99, 16, 8));
    	ret = compareTriplets(a, b);
    	checkResult("Test2", ret, new ArrayList<Integer>(Arrays.asList(2, 1)));
    }
    
    
    private static void checkResult(String testName, List<Integer> ret, ArrayList<Integer> expected) {
    	System.out.println("***************");
    	if (ret.size() != expected.size()) {
    		System.out.println("FALHOU " + testName + ": wrong list size - " + ret.size() + ", " + expected.size());
    		return;
    	}
    	for(int i = 0; i < ret.size(); i++) {
    		if (ret.get(i) != expected.get(i)) {
    			System.out.println("FALHOU " + testName + ": wrong value idx " + i + " - " + ret.get(i) + ", " + expected.get(i));
    			return;
    		}
		}
    	System.out.println("OK " + testName);
	}

	public void keepThisMethod() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
