package com.algorithms.searching;

public class demo {

	public static void main(String[] args) {
		int[] magic = {3,2,5,4};
		int dist[] = {2,3,4,2};
		int n= magic.length;
		
		int total =0;
		int distance = -1;
		
		for(int i=0; i<n; i++)
		{
			total = total+ magic[i];
			if(distance >=0 && distance<n)
			{
				total-= dist[distance];
			}
			distance++;
		}
		total-=dist[n-1];
		
System.out.print(total);
	}

}
