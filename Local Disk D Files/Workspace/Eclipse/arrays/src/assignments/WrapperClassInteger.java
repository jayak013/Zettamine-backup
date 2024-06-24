package assignments;

public class WrapperClassInteger {
	public static void main(String[] args) {
		int primitiveValue = 10;
		
		System.out.println(primitiveValue+" -> printed as a int value");
		
		Integer autoBoxing = primitiveValue;//auto-boxing is done implicitly by java(jvm) 
											//by calling Integer.valueOf(int value)->
											//this returns (instance of Integer)
		
		System.out.println(autoBoxing+" -> auto boxed value printed as a String value");
		//System.out.println(Object x) method will be revoked here and prints object as String
		
		int autoUnBoxing = autoBoxing;	//auto-unboxing is done implicitly by java(jvm)
										//by calling (instance of Integer).intValue()->
										//this returns int value from Integer instance
		
		System.out.println(autoUnBoxing+" -> auto unboxed value printed as a int value");
		
		Integer boxing = Integer.valueOf(primitiveValue); //boxing done explicitly
		
		System.out.println(boxing+" -> auto boxed value printed as a String value");
		
		int unBoxing = boxing.intValue(); //unboxing done explicitly
		
		System.out.println(unBoxing+" -> auto unboxed value printed as a int value");
	}
}
