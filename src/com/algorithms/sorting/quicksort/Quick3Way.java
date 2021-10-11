package com.algorithms.sorting.quicksort;

import java.util.Comparator;

import com.algorithms.sorting.insertion.Insertion;
import com.algorithms.sorting.insertion.InsertionImpl;

public class Quick3Way<T extends Comparable<? super T>> implements QuickSort<T> {
	private static final int CUTOFF = 10;

	@Override
	public void sort(T[] array) {
		sort(array, null, 0, array.length - 1);

	}

	@Override
	public void sort(T[] array, Comparator<? super T> comparator) {
		sort(array, comparator, 0, array.length - 1);

	}

	private void sort(T[] array, Comparator<? super T> comparator, int low, int high) {
//		if (high <= low)
//			return;

		if (high <= low + CUTOFF) {

			Insertion<T> Insertion = new InsertionImpl<T>();
			Insertion.sort(array, low, high, comparator);
			return;
		}
		int left = low;
		int right = high;
		int current = low + 1;
		T pivot = array[low];
		while (current <= right) {
			int compare = compare(array[current], pivot, comparator);
			if (compare < 0)
				swap(array, left++, current++);
			else if (compare > 0)
				swap(array, current, right--);
			else {
				current++;
			}
		}
		sort(array, comparator, low, left - 1);
		sort(array, comparator, right + 1, high);
	}

	private void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		temp = null;

	}

	private int compare(T current, T pivot, Comparator<? super T> comparator) {
		if (comparator == null) {
			return current.compareTo(pivot);
		} else {
			return comparator.compare(current, pivot);
		}
	}

	@Override
	public void reverseSort(T[] array) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reverseSort(T[] array, Comparator<? super T> comparator) {
		// TODO Auto-generated method stub

	}

}
