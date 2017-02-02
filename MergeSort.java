package com.crucerne.www.mergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	/*
	 * The method takes a list collection of integers as argument and sorts them
	 * via merge sort. The algorithm involves partitioning the original list
	 * into 2 parts: half of all the numbers to the left and half of all the
	 * numbers to the right. The 2 partitions recursively calls the same method
	 * until only 1 element is in each partition. After the partition phase, the
	 * method calls the "merge" method to add and sort all the partitions.
	 */
	public static List<Integer> mergeSort(List<Integer> numbers) {
		// Returns the original list if the number of elements in the list is 1
		// or empty.
		if (numbers.size() < 2) {
			return numbers;
		}

		// Partitions the list into 2: left half and right half.
		List<Integer> leftNumbers = numbers.subList(0, numbers.size() / 2);
		List<Integer> rightNumbers = numbers.subList(numbers.size() / 2, numbers.size());

		// Recursively calls itself with the two partitions and call upon the
		// "merge" method, which will sort and merge all the partitions back
		// into a single list to return.
		return merge(mergeSort(leftNumbers), mergeSort(rightNumbers));
	}

	/*
	 * The method takes two list collections as arguments (left and right),
	 * creates a new sorted list container to hold all the arguments' elements,
	 * and return the sorted container. The process includes having a pointer to
	 * reference the elements in the left list and a pointer to reference the
	 * elements in the right list. The sorted list will keep adding elements
	 * from both arguments until both the left and right pointers signify there
	 * are no remaining elements to be added. 3 conditions will be checked: 1)
	 * If there are still elements remaining in the left and right containers,
	 * then check to see if the left or right element is the lower value. The
	 * lower value will be added to the sorted container and pointer of the
	 * lower value's container will be incremented. 2) Only the left and right
	 * containers have elements remaining. If the left container has any
	 * elements remaining, add all the remaining elements sequentially to the
	 * sorted container. 3) If only the right container has any elements
	 * remaining, add all the remaining elements sequentially to the sorted
	 * container.
	 */
	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		// Pointers to reference the elements in the left and right containers.
		int left_pointer = 0;
		int right_pointer = 0;

		// New sorted container equivalent to the size of the left plus right
		// containers.
		List<Integer> merged = new ArrayList<>(left.size() + right.size());

		// While both containers still contain elements. The lowest value of the
		// first elements from the left and right containers will be added to
		// the sorted container.
		while (left_pointer < left.size() && right_pointer < right.size()) {
			if (left.get(left_pointer) < right.get(right_pointer)) {
				merged.add(left.get(left_pointer));
				left_pointer++;
			}
		}

		// While only 1 container from the left and right containers have any or
		// no element(s). If the left pointer references any elements remaining,
		// add those elements to the sorted container.
		while (left_pointer < left.size()) {
			merged.add(left.get(left_pointer));
			left_pointer++;
		}

		// While the right container have any or no element(s). If the right
		// pointer references any elements remaining, add those elements to the
		// sorted container.
		while (right_pointer < right.size()) {
			merged.add(right.get(right_pointer));
			right_pointer++;
		}

		return merged;
	}

}
