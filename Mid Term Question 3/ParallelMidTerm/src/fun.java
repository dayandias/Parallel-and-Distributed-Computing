import java.util.ArrayList;
import java.util.Random;

public class fun {

	public static void main(String[] args) {
		
//		Random rand = new Random();
//	    int size = rand.nextInt(50) + 1;
//	      
//	    ArrayList<Integer> arr = new ArrayList<Integer>(size);
//	      	
//	      for(int i = 0; i < size; i++)
//	        arr.add(rand.nextInt(100) + 10);
//
//	      System.out.println(size);
//	      System.out.println("");
//	      System.out.println(arr);
	      
	      int [] row = {63, 45, 39, 30, 57, 25, 20, 53, 59, 12, 46, 55, 32, 15, 16, 41, 28, 78, 14, 86, 40, 93, 35, 91, 85, 89, 43, 21, 106, 64, 42, 68, 98, 17, 106, 100, 89, 47, 107, 63, 45, 39, 12};
	      int [] row1 = {81, 54, 74, 89, 62, 35, 44, 101, 59, 100, 64, 34, 79, 80, 25, 31, 47, 19, 77, 102, 41, 88, 83, 26, 20, 11, 92, 21, 29, 105, 87, 30, 42, 93, 107, 56, 94, 15, 95};
	      //int [] row2 = {81, 54, 74, 89, 62, 35, 44, 101, 59, 100, 64, 34, 79, 80, 25, 31, 47, 19, 77, 102, 41, 88, 83, 26, 20, 11, 92, 21, 29, 105, 87, 30, 42, 93, 107, 56, 94, 15, 95};
	      int [] row3 = {58, 93, 53, 37, 11, 88, 56, 71, 97, 21, 78, 83, 102, 57, 64, 80, 94, 108, 29, 12, 51, 15, 76, 52, 82, 99, 40, 17, 91, 18, 69, 13, 74, 10, 103, 67, 65};
	      //int [] row4 = {58, 93, 53, 37, 11, 88, 56, 71, 97, 21, 78, 83, 102, 57, 64, 80, 94, 108, 29, 12, 51, 15, 76, 52, 82, 99, 40, 17, 91, 18, 69, 13, 74, 10, 103, 67, 65};

	      ArrayList<Integer> noDuplicates = new ArrayList<Integer>();
			
			for(Integer i: row3) {
				
				if(!noDuplicates.contains(i)) {
					noDuplicates.add(i); 
				}
				
			}
			
		      System.out.println(noDuplicates);
	}

}
//[47, 65, 38, 51, 27, 41, 84, 59, 36, 99, 97, 33, 54, 47, 12]