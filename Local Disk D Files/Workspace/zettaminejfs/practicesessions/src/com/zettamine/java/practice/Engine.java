package com.zettamine.java.practice;

public class Engine {
	
	int horsePower;
	
	public Engine(int horsePower) {
		this.horsePower = horsePower;
	}

	@Override
	public String toString() {
		return "Engine [horsePower=" + horsePower + "]";
	}
	
}
