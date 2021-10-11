package com.algorithms.sorting.mergesort;

import java.util.Comparator;

public interface MergeSort<T> {

	public void sort(T[] array);
	public void sort(T[] array, Comparator<? super T> comparator);
}
