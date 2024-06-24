package assignments;

public enum UOM {
	
	KG(1),TON(3),LT(1),GAL(2);
	
	private final int displayValue;
	
	private UOM(int displayValue) {
		this.displayValue = displayValue;
	}
	
	public static int getValue(UOM s) {
		int value = 0;
		for(UOM u:UOM.values()) {
			if(u.equals(s)) {
				value = u.displayValue;
				break;
			}
		}
		return value;
	}
}
