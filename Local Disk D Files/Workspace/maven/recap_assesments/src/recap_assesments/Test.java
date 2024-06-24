package recap_assesments;

import java.util.ArrayList;

public class Test<T extends SearchCriteria> {
	public static void main(String[] args) {
		Test<Demo> test = new Test<Demo>();
		test.test(new Demo());
	}
	public void test(T t) {
		System.out.println(t instanceof SearchCriteria);
	}
}
