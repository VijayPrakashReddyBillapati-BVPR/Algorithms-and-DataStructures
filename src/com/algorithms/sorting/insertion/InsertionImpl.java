package com.algorithms.sorting.insertion;

import java.util.Comparator;

public class InsertionImpl<T extends Comparable<? super T>> implements Insertion<T> {

	@SuppressWarnings("rawtypes")
	private void exchange(Comparable[] a, int Index_1, int Index_2) {
		Comparable temp = a[Index_1];
		a[Index_1]=a[Index_2];
		a[Index_2] = temp;
		
	}

	@Override
	public void sort(T[] array) {
		sort(array, null);
		
	}

	@Override
	public void sort(T[] a, Comparator<? super T> comparator) {
		if(a.length <1 || a == null) {
			return;
		}
		
		for(int i=0;i<a.length;i++) {
			for(int j=i;j>0;j--) {
				if(compare(a[j], a[j-1], comparator)<0) {
					exchange(a,j,j-1);
				}
				else break;
			}
		}		
	}

	private int compare(T object1, T object2, Comparator<? super T> comparator) {
		if(comparator== null)
		{
			return object1.compareTo(object2);
		}
		return comparator.compare(object1, object2);
	}

	@Override
	public void sort(T[] a, int low, int high, Comparator<? super T> comparator) {
		if(a.length <1 || a == null) {
			return;
		}
		
		for(int i=low;i<=high;i++) {
			for(int j=i;j>0;j--) {
				if(compare(a[j], a[j-1], comparator)<0) {
					exchange(a,j,j-1);
				}
				else break;
			}
		}	
		
	}
}
