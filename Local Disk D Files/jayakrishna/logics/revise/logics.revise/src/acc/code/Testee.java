package acc.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Testee {
	
	static Integer count = 1;
	
	public static void main(String[] args) {
//		List<String> list = Arrays.asList("jaya krishna","hari prasad","chandu ganesh")
//		.stream().map(e->e.split(" ")[1]).toList();
//		
//		System.out.println(list);
		
//		Map<Integer, String> collect = Arrays.asList("jaya krishna","hari prasad","chandu ganesh","java")
//		.stream().collect(Collectors.toMap(e->count++, e->e,(o,n)->o,TreeMap::new));
//		
//		System.out.println(collect);
//		
//		Map<Character, List<String>> collect2 = Arrays.asList("jaya krishna","hari prasad","chandu ganesh","java").stream()
//		.collect(Collectors.groupingBy(e->e.charAt(0)));
//		System.out.println(collect2);
//		
//		String s = "my name is jaya krishna seethagari";
//		
//		Map<Character,Long> collect3 = s.chars().mapToObj(c->(char)c).filter(c->c!=' ')
//		.collect(Collectors.groupingBy(c->c,Collectors.counting()));
//		
//		System.out.println(collect3);
//		
//		
//		String s1 = "my name is jaya krishna seethagari my name is ";
//		
//		Map<String, Long> collect4 = Arrays.stream(s1.split(" "))
//				.collect(Collectors.groupingBy(e->e,Collectors.counting()));
//		
//		System.out.println(collect4);
//		
//		Map<String, List<Integer>> collect5 = Arrays.asList(1,2,3,4,5,6,7,8,9).stream().collect(Collectors.groupingBy(e->e%2!=0?"odd":"even"));
//		Map<Boolean, List<Integer>> collect6 = Arrays.asList(1,2,3,4,5,6,7,8,9).stream().collect(Collectors.partitioningBy(e->e%2==0));
//		
//		System.out.println(collect5);
//		System.out.println(collect6);
//		
//		
//		Integer[] integerArr = {1,2,3,4,5,6,7,8};
//		
//		Integer[] array = IntStream.rangeClosed(0, integerArr.length-1).map(i->integerArr[integerArr.length-1-i])
//			.mapToObj(Integer::valueOf).toArray(Integer[]::new);
//		
//		System.out.println(Arrays.toString(array));
//		
//		Arrays.asList(1,2,3,4,5,6,7,8,9).stream().collect(Collectors.groupingBy(e->e,Collectors.mapping(null, null)));
		
		
//		String s = "hello world, my name is jaya krishna seethagari";
//		
//		Map<Character, Long> collect = s.chars().mapToObj(c->(char)c)
//				.filter(c->c!=' ').collect(Collectors.groupingBy(c->c,Collectors.counting()))
//				.entrySet().stream().filter(e->e.getValue()>=3)
//				.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
//		
//		System.out.println(collect);
        
        List<List<String>> listofLists = new ArrayList<>();
        
        List<String> list1 = new ArrayList<>();
        list1.add("jaya john");
        list1.add("kittu shan");
        list1.add("molly john");
        
//        list1.stream().map(e->e.split(" ")[1]).map(e->e.equals("john")?"jack":e).forEach(System.out::println);
        
        List<String> list2 = new ArrayList<>();
        list2.add("krishna chole");
        list2.add("krishna mole");
        list2.add("krishna wole");
        
        listofLists.add(list1);
        listofLists.add(list2);
        
//        listofLists.stream().flatMap(e->e.stream()).findFirst().ifPresent(System.out::println);
        
        listofLists.stream().map(e->e.get(0).split(" ")[1]).forEach(System.out::println);
        
	}
	
}
