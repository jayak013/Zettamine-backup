package customgenerics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test<T extends Employee> {
	public T t;
	public List<T> list = new ArrayList<>();
	public Test() {}
	public void get() {
		System.out.println(t);
	}
	public void addElements(T t) {
		list.add(t);
	}
	@Override
	public String toString() {
		return t.toString();
	}
	
}
