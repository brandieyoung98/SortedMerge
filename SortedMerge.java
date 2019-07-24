import java.util.*;
import java.lang.*;
import java.io.*;

public class SortedMerge{
	public static void main (String[] args){
	  //change A and B to test, ensuring A contains enough empty buffer space for B
		int[] A = new int[10];
		A[0] = 1;
		A[1] = 2;
		A[2] = 5;
		A[3] = 44;
		A[4] = 999;
		int[] B = {0, 3, 66, 72, 120};
		System.out.println(Arrays.toString(sortedMerge(A,B)));
	}
	public static int[] sortedMerge(int[] A, int[] B){
	  //similar to mergesort merge step except it occurs within A so more indices are needed to keep track of...
	  int lastIndexOfB = B.length -1; // the index of the last element in B not inserted
	  int lastIndexOfA = A.length-1-B.length; //the index of the last element in A not inserted into A's sorted portion
	  int emptyIndOfA = A.length-1; //the insertion index of A (we insert right to left, so it's decreasing)
	  while(lastIndexOfB >=0 && lastIndexOfA >=0){
      //this if else statement determines which element is bigger (the last one from A or from B), aka which to insert in A's insertion index
		  if(A[lastIndexOfA] <= B[lastIndexOfB]){
			  A[emptyIndOfA] = B[lastIndexOfB];
			  lastIndexOfB--;
			  emptyIndOfA--;
		  }
		  else if(A[lastIndexOfA] > B[lastIndexOfB]){
			  A[emptyIndOfA] = A[lastIndexOfA];
			  lastIndexOfA--;
			  emptyIndOfA--;
		  }
	  }
	  //if true, this means the leftovers of B belong at the beginning of A; it's safe to just overwrite the beginning of A
	  if(lastIndexOfB >= 0){
	    for(int i = 0 ; i <= lastIndexOfB; i++){
	        A[i] = B[i];
	    }
	  }
	  return A; //A is now sorted
}

}
