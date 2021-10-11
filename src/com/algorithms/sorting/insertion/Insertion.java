package com.algorithms.sorting.insertion;

import java.util.Comparator;

public interface Insertion<T> {
	public void sort(T[] array);
	public void sort(T[] array, Comparator<? super T> comparator);
	public void sort(T[] array, int low, int high, Comparator<? super T> comparator);

	
}
