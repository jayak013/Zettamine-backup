package customgenerics;

import java.util.List;

public class GenericsDemo<T> {
	
	private T t;
	
	public T get(T t) {
		return t;
	}
	
	public T set(T t) {
		return this.t = t;
	}
	
	public Object[] test(List<T> list) {
		int size = list.size();
		Object[] o = new Object[size];
		for(int i = 0;i<size;i++) o[i] = list.get(i);
		return o;
	}
}
