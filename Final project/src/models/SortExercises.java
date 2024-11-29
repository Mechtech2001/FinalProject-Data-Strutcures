package models;

import java.util.ArrayList;
import java.util.List;

public class SortExercises {

	public List<Exercise> mergeSort(List<Exercise> list) {
		if (list.size() <= 1) {
			return list;
		}

		// Split the list into two halves
		int mid = list.size() / 2;
		List<Exercise> left = new ArrayList<>(list.subList(0, mid));
		List<Exercise> right = new ArrayList<>(list.subList(mid, list.size()));

		// Recursively sort each half
		left = mergeSort(left);
		right = mergeSort(right);

		// Merge the sorted halves
		return merge(left, right);
	}

	private List<Exercise> merge(List<Exercise> left, List<Exercise> right) {
		List<Exercise> merged = new ArrayList<>();
		int leftIndex = 0, rightIndex = 0;

		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(leftIndex).getWeight() <= right.get(rightIndex).getWeight()) {
				merged.add(left.get(leftIndex++));
			} else {
				merged.add(right.get(rightIndex++));
			}
		}

		// Add remaining elements
		while (leftIndex < left.size()) {
			merged.add(left.get(leftIndex++));
		}

		while (rightIndex < right.size()) {
			merged.add(right.get(rightIndex++));
		}

		return merged;
	}
}
