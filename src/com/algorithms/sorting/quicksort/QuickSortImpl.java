package com.algorithms.sorting.quicksort;

import java.util.Comparator;

import com.algorithms.sorting.insertion.Insertion;
import com.algorithms.sorting.insertion.InsertionImpl;

public class QuickSortImpl<T extends Comparable<? super T>> implements QuickSort<T> {

	private static final int CUTOFF = 10;

	@Override
	public void sort(T[] array) {
		sort(array,null, 0, array.length-1);
		
	}

	@Override
	public void sort(T[] array, Comparator<? super T> comparator) {
		sort(array, comparator, 0, array.length-1);
		
	}

	private void sort(T[] array, Comparator<? super T> comparator, int low, int high) {
//		if(high<=low)
//		{
//			return;
//		}
		if (high <= low + CUTOFF) { 
			
			Insertion<T> Insertion = new InsertionImpl<T>();
			Insertion.sort(array, low, high,comparator);
			return; 
			}
		int pivot = partition(array, comparator, low, high);
		sort(array, comparator, low, pivot-1);
		sort(array, comparator, pivot+1, high);
		
	}

	private int partition(T[] array, Comparator<? super T> comparator, int low, int high) {
		int left =  low;
		int right = high+1;
		T pivot =  array[low];
		
		while(true)
		{
			while(compare(array[++left], pivot, comparator))
			{
				if(left==high)
					break;
			}
			while(compare(pivot, array[--right], comparator))
			{
				if(right==low)
					break;
			}
			
			if(left>=right)
				break;
			
			swap(array, left, right);
				
		}
		swap(array, low, right);// Put pivot = a[right] into position i.e swap with partitioning item
		return right;
	}

	private boolean compare(T valueAtIndex, T pivot, Comparator<? super T> comparator) {
		if(valueAtIndex.compareTo(pivot)<0)
			return true;
		return false;
	}

	private void swap(T[] array, int left, int right) {
		T temp  =  array[left];
		array[left]= array[right];
		array[right] = temp;
		
	}

	@Override
	public void reverseSort(T[] array) {
		reverseSort(array, null);
	}

	@Override
	public void reverseSort(T[] array, Comparator<? super T> comparator) {
		sort(array, comparator, 0, array.length);
		
	}

}
