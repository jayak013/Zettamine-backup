package acc.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Deterministic and Non-deterministic algorithms
public class DaNda {
    private static List<Integer>[] splitListInToTwoDA(List<Integer> list) {
        List<Integer> part1 = new ArrayList<Integer>();
        List<Integer> part2 = new ArrayList<Integer>();
        
        Collections.sort(list);
        int midIdx = list.size() / 2;
        for(int i = 0; i < list.size(); i++) {
            if(i < midIdx) 
                part1.add(list.get(i));
            else
                part2.add(list.get(i));
        }
        
        List<Integer>[] retVal = new List[] {part1, part2};
        
        return retVal;
    }
    
    private static List<Integer>[] splitListInToTwoNDA(List<Integer> list) {
        List<Integer> part1 = new ArrayList<Integer>();
        List<Integer> part2 = new ArrayList<Integer>();
        
        Collections.shuffle(list);
        int midIdx = list.size() / 2;
        for(int i = 0; i < list.size(); i++) {
            if(i < midIdx) 
                part1.add(list.get(i));
            else
                part2.add(list.get(i));
        }
        
        List<Integer>[] retVal = new List[] {part1, part2};
        
        return retVal;
    }
    
    public static void main(String[] args) {
        List<Integer> sampleData = new ArrayList<Integer>();
        sampleData.add(25);
        sampleData.add(2);
        sampleData.add(99);
        sampleData.add(14);
        sampleData.add(7);
        sampleData.add(56);
        
        List<Integer>[] daResult = splitListInToTwoDA(sampleData);

        System.out.println("~~~~Attempt-1~~~DA~~~~");
        System.out.println(daResult[0]);
        System.out.println(daResult[1]);

        System.out.println("~~~~Attempt-1~~~NDA~~~~");
        List<Integer>[] ndaResult = splitListInToTwoNDA(sampleData);
        System.out.println(ndaResult[0]);
        System.out.println(ndaResult[1]);
        

        System.out.println("~~~~Attempt-2~~~DA~~~~");
        daResult = splitListInToTwoDA(sampleData);
        System.out.println(daResult[0]);
        System.out.println(daResult[1]);

        System.out.println("~~~~Attempt-2~~~NDA~~~~");
        ndaResult = splitListInToTwoNDA(sampleData);
        System.out.println(ndaResult[0]);
        System.out.println(ndaResult[1]);
    }
    
}