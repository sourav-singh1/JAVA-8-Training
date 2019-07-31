package com.yash.practice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 11, 20, 33, 4, 44, 55, 20);
		
		// collect the result of a Stream into Set
		Set<Integer> numbersToSet = numbers.stream().collect(Collectors.toSet());
		//numbersToSet.forEach(System.out::println);
		System.out.println(numbersToSet);
		
		// collect the result of a Stream into list
		List<Integer> numbersToList = numbers.stream().collect(Collectors.toList());
		//numbersToList.forEach(System.out::println);
		System.out.println(numbersToList);
		
		// create Map from the elements of Stream (first remove the duplicates)
		AtomicInteger index = new AtomicInteger();
		Map<Integer, Integer> numbersToMap = numbersToSet.stream().collect(Collectors.toMap(in -> index.getAndIncrement(), n -> n));
		System.out.println(numbersToMap);
		
		// find summary statistics from a Stream of numbers
		IntSummaryStatistics numbersToSumarize = numbers.stream().collect(Collectors.summarizingInt(n -> n));
		System.out.println(numbersToSumarize);
		
		// partition the result of Stream in two parts i.e., odd and even
		Map<Boolean, List<Integer>> numbersToOddEven = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println(numbersToOddEven);
		
		// create comma separated string from numbers
		String numberToString = numbers.stream().map(n -> n.toString()).collect(Collectors.joining(","));
		System.out.println(numberToString);
		


	}
}
