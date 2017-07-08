package com.example;

import java.util.Comparator;

public class SampleComparator<T> implements Comparator<T> {

	public int compare(T o1, T o2) {
		return o1.equals(o2) ? 0 : -1;
		
	}

}
