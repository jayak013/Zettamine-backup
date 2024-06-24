package customgenerics;

public class CustomArrayList {
	private static int size = 0;
	private static final int DEFAULT_SIZE = 0;
	private Object array[]; 
	
	public CustomArrayList() {
		array = new Object[DEFAULT_SIZE];
	}
	
	public CustomArrayList(int initialCapacity) {
		array = new Object[initialCapacity];
	}
	
	public void add(Object t) {
		if(isFull()) reSize();
		array[size++] = t;
	}
	
	private boolean isFull() {
		return array.length==size;
	}
	
	public void add(int index,Object t) {
		if(index<0 && index>size) throw new IndexOutOfBoundsException();
		if(isFull()) reSize();
		for(int i = size();i>index;i--) array[i+1] = array[i];
		array[index] = t;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public void removeAt(int index) {
		if(index<0 && index>size) throw new IndexOutOfBoundsException();
		for(int i = index+1;i<size;i++) 
			array[i-1] = array[i];
		array[--size] = null;
	}
	
	private void reSize() {
		Object[] temp = new Object[(array.length + array.length/2)+1];
		for(int i = 0;i<array.length;i++) temp[i] = array[i];
		array = temp;
	}
	
	public Object get(int index) {
		return array[index];
	}
	
	public String toString() {
		String s = "["+ get(0).toString();
		for(int i = 1;i < size;i++) {
			String temp = ", " + get(i).toString();
			s += temp;
		}
		return s+"]";
	}
	
	public int indexOf(Object o) {
		int idx = -1;
		for(int i = 0;i<size();i++) {
			if(o.equals(get(i))) {
				return i;
			}
		}
		return idx;
	}
	
	public void remove(Object o) {
		int idx = indexOf(o);
		if(idx!=-1) remove(idx);
	}
}
