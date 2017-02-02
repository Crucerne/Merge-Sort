package com.crucerne.www.mergesort;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void test() {
		List<Integer> numbers = Arrays.asList(10, 8, 12, 6, 4, 16);
		final List<Integer> expected = Arrays.asList(4, 6, 8, 10, 12, 16);
		numbers = MergeSort.mergeSort(numbers);
		for (Integer number : numbers) {
			System.out.println(number);
		}
		assertEquals(expected, numbers);
	}

}
