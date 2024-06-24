package logics.revise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HackerRankPractive {	
	static final int i; //final blank variable
	final int j;
	static {
		i=20;
	}
	
	
	public HackerRankPractive(int j) {
		super();
		this.j = j;
	}

	public static int m1() {
		return 0;
	}
	
	public static double m1(int m) {
		return 1;
	}
	
	public static void main(String[] args) {
		
		Set<String> set = new LinkedHashSet<>();
		List<Integer> list = Arrays.asList(1,3,10,2,6,5,8,4,9,7);
		
//		Arrays.asList(1,2,3,4,5,8,6,7,8,9,10).stream().filter(e->!set.add(e)).forEach(System.out::println);
//		list.stream().filter(e->Collections.frequency(list, e)>1).distinct().forEach(System.out::println);
//		list.stream().max(Integer::compare).ifPresent(System.out::println);
		
		String s = "java articles are awesome";
//		s.chars().mapToObj(c->(char)c)
//					.collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
//					.entrySet().stream()
//					.filter(e->e.getValue()==1).findFirst().ifPresent(e->System.out.print(e.getKey()));
//					
		
		
//		s.chars().mapToObj(c->(char)c).filter(e->!set.add(e)).findFirst().ifPresent(System.out::println);
		
//		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
//		boolean anyMatch = Arrays.asList(1,2,3,).stream()
//				.collect(Collectors.groupingBy(e->e)).entrySet()
//								.stream().anyMatch(e->e.getValue().size()==2)
//								;
		
//		System.err.println(anyMatch);
		
//		System.err.println(Stream.of("apple","aeroplane","banana","balloon","car","dog")
//		.collect(Collectors.groupingBy(e->e.charAt(0))));
		
//		Arrays.asList(4,5,6,7,1,2,3).stream().map(v->(int)Math.pow(v, 3)).filter(v->v>50).forEach(System.out::println);
//		Integer[] a = {1,3,4,7,5,6,2,9,8,10};
//		Arrays.parallelSort(a);
//		System.err.println(Arrays.toString(a));
		
//		Arrays.asList("aa","bb","cc","dd").stream().map(String::toUpperCase).forEach(System.out::println);
		

//		Map<String, Long> collect = Stream.of("apple","apple","banana","car","car","car")
//		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		System.out.println(collect);
		
//		Map<String, Long> collect = Stream.of("apple","apple","banana","car","car","car")
//		.collect(Collectors.groupingBy(e->e,Collectors.counting()))
//		.entrySet().stream().filter(e->!(e.getValue()==1))
//		.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
//		
//		System.out.println(collect);
		
//		 List<Notes> noteLst = new ArrayList<>();
//		    noteLst.add(new Notes(1, "note1", 11));
//		    noteLst.add(new Notes(2, "note2", 22));
//		    noteLst.add(new Notes(3, "note3", 33));
//		    noteLst.add(new Notes(4, "note4", 44));
//		    noteLst.add(new Notes(5, "note5", 55));
//
//		    noteLst.add(new Notes(6, "note4", 66));
//
//
//		    Map<String, Long> notesRecords = noteLst.stream()
//		                                            .sorted(Comparator
//		                                            .comparingLong(Notes::getCount)
//		                                            .reversed()) // sorting is based on TagId 55,44,33,22,11
//		                                            .collect(Collectors.toMap
//		                                            (Notes::getNote, Notes::getCount,
//		                                            (oldValue, newValue) -> oldValue,LinkedHashMap::new));
//		// consider old value 44 for dupilcate key
//		// it keeps order
//		        System.out.println("Notes : " + notesRecords);
		
		
		String s1 = new String("welcome");
		String s2 = new String("welcome").intern();
		s1=s1.intern();
		String s3 = "welcome";
		
		System.err.println(s2==s1);
		
		

	}
	
	public static void diamondNumPattern(int n) {
		int spaces = n/2;
		int nums = 1;
		for(int i = 1;i<=n;i++) {
			for(int k = 1;k<=spaces;k++) System.out.print(" ");
			for(int j = 1;j<=nums;j++) {
				if(j>=10) System.out.print(j%10==0?1:j%10+1);
				else System.out.print(j);
			}
			if(i<=n/2) {
				spaces--;
				nums+=2;
			}else {
				spaces++;
				nums-=2;
			}
			System.out.println();
		}
	}
	
	
	
}

class Notes implements Comparable<Notes>{
	private long id;
	private String note;
	private long count;
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public Notes(long id, String note, long count) {
		super();
		this.id = id;
		this.note = note;
		this.count = count;
	}
	@Override
	public int compareTo(Notes o) {
		return (int)(this.id-o.id);
	}
	
	
	
}
