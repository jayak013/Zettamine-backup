import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetOfArithProg {
	public static void main(String[] args) {
		int [] numbers = {-130,-13,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0
								,1,2,3,4,5,6,7,8,9,10,32293};
		System.out.println(Arrays.
				toString(getArithmeticProgressiveValuesSubset(1, 3, numbers)));;
	}
	
	public static int[] getArithmeticProgressiveValuesSubset(int firstTerm,
														int commonDif,
														int[] numbers) {
		
		List<Integer> list = new ArrayList<>();
		int[] arrOfArithProg = new int[0];
		if(commonDif<0) {
			int i = 0,j = numbers.length-1;
			while(i<=j) {
				if(((numbers[i]+firstTerm+2)*(-1))%(commonDif*(-1))==0 && numbers[i]<=firstTerm) 
					list.add(numbers[i]);
				if(i==j) break;
				if(((numbers[j]+firstTerm)*(-1))%(commonDif*(-1))==0 && numbers[j]<=firstTerm) 
					list.add(numbers[j]);
				i++;j--;
			}
			arrOfArithProg = new int[list.size()];
			for(int k = 0;k<arrOfArithProg.length;k++) arrOfArithProg[k] = list.get(k);
			Arrays.sort(arrOfArithProg);
			return arrOfArithProg;
		}
		if(commonDif==0) {
			int i = 0,j = numbers.length-1;
			while(i<=j) {
				if(numbers[i] == firstTerm || numbers[j] == firstTerm) {
					arrOfArithProg = new int[1];
					arrOfArithProg[0] = firstTerm;
					return arrOfArithProg;
				}
				else return arrOfArithProg;
			}
		}
			int i = 0,j = numbers.length-1;
			while(i<=j) {
				if((numbers[i]-firstTerm)%commonDif==0&&numbers[i]>=firstTerm) 
					list.add(numbers[i]);
				if(i==j) break;
				if((numbers[j]-firstTerm)%commonDif==0&&numbers[j]>=firstTerm) 
					list.add(numbers[j]);
				i++;j--;
			}
			arrOfArithProg = new int[list.size()];
			for(int k = 0;k<arrOfArithProg.length;k++) arrOfArithProg[k] = list.get(k);
			Arrays.sort(arrOfArithProg);
			return arrOfArithProg;
	}
	
}

