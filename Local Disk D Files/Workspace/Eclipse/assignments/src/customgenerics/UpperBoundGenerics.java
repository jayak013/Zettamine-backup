package customgenerics;

import java.util.List;

public class UpperBoundGenerics<T extends Number> {
	
	private T t;
	
	public T get(T t) {
		return t;
	}
	
	public void set(T t) {
		this.t = t;
	}
	
	public <T> T[] test(List<T> list) {
		int size = list.size();
		Object[] o = new Object[size];
		for(int i = 0;i<size;i++) o[i] = list.get(i);
		return (T[])o;
	}
}
