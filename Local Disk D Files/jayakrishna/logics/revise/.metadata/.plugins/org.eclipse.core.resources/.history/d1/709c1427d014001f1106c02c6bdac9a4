package logics.revise;

import java.util.Arrays;

public class ArrayDuplicatesRemover {
	public static void main(String[] args) {
//		String [] a = {"hi","hi","hi","hello","hi"};
// 		System.out.println(Arrays.toString(duplicateRemover(a)));
//		Integer[] a = {1,2,1,1,2,1,3,2};
//		System.out.println(sortOutPairSocksCount(a));
		
		System.out.println(countingValley(10, "UDDUDDUDUU"));
	}
	
	public static String[] duplicateRemover(String[] array) {
		Integer count = 0;
		String[] distinctVal = new String[array.length];
		for(int i = 1;i<array.length;i++) {
			if(!array[i-1].equals(array[i])) {
				distinctVal[count++] = array[i];
			}
		}
		return distinctVal;
	}
	
	public static Integer sortOutPairSocksCount(Integer[] array) {
		Arrays.sort(array);
		Integer countOfColoredPairs = 0;
		for(int i = 1;i<array.length;i++) {
			if(array[i-1]==array[i]) 
				countOfColoredPairs++;
			else 
				countOfColoredPairs = countOfColoredPairs-1;
		}
		return countOfColoredPairs;
	}
	
	public static int countingValley(int n, String path)
    {
        int level=0,valley=0;
        for(int i=0;i<n;i++)
        {
            if(path.charAt(i)=='U')
                level++;
            else if(path.charAt(i)=='D')
            {
                if(level==1)
                    valley++;
                level--;
            }
        }
        return valley;
    }
}
