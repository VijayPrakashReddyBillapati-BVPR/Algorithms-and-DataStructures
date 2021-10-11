package com.algorithms.sorting.mergesort;

import java.util.Comparator;

public class MergeSortImpl<T extends Comparable<? super T>> implements MergeSort<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void sort(T[] array) {
		T[] helper = (T[]) new Object[array.length];
		sort(array,helper, null,0,array.length);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort(T[] array, Comparator<? super T> comparator) {
		T[] helper = (T[]) new Object[array.length];
		sort(array,helper, comparator, 0, array.length-1);
		
	}

	private void sort(T[] array,T[] helper, Comparator<? super T> comparator, int low, int high) {
		if(high<=low)
			return;
		int mid = low + (high -  low)/2;
		sort(array, helper,comparator, low, mid);
		sort(array, helper,comparator, mid+1, high);
		merge(array, helper, low, mid, high,comparator);
	}

	private void merge(T[] array, T[] helper, int low, int mid, int high, Comparator<? super T> comparator) {
		for(int i=0; i<array.length; i++)
		{
			helper[i] = array[i];
		}
		int left = low;
		int right = mid+1;
		int current = low;
		while(left<=mid && right<=high)
		{
			if(compare(array[left], array[right], comparator)<0)
			{
				array[current++] = array[left];
				left++;
			}else {
				array[current++] = array[right];
				right++;
			}
			current++;
			
			int remaining = mid -  left;
			for(int i=0; i<=remaining;i++)
			{
				array[current+i] = helper[left+i];
			}
		}
	}

	private int compare(T object1, T object2, Comparator<? super T> comparator) {
		if(comparator==null)
			return object1.compareTo(object2);
		return comparator.compare(object1, object2);
	}

}
