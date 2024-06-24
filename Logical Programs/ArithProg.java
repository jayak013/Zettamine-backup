import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArithProg {
	public static void main(String[] args) {
		int [] numbers = {1,2,3,4,5,7,4,6,20,11,18,35,21,33,30};
		System.out.println(Arrays.toString(getArithmeticProgressiveValues(5, 3, numbers)));;
	}
	public static int[] getArithmeticProgressiveValues(int firstTerm,int commonDif,int[] numbers) {
		if(commonDif<=0) throw new ArithmeticException("Common Difference should be >=1");
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<numbers.length;i++) {
			if((numbers[i]-firstTerm)%commonDif==0&&numbers[i]>=firstTerm) list.add(numbers[i]);
		}
		int[] arrOfArithProg = new int[list.size()];
		for(int i = 0;i<arrOfArithProg.length;i++) arrOfArithProg[i] = list.get(i);
		Arrays.sort(arrOfArithProg);
		return arrOfArithProg;
	}
	
}