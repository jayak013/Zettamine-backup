package org.jfs.day01;

public class MaterialManagement {
	public static void main(String[] args) {
		Material m1 = new Material(435,"steel",IndustrialSector.MANUFACTURING_INDUSTRY);
		Material m2 = new Material(m1);
		try {
			Material m3 = (Material)m1.clone();
			Material m4 = (Material)m3.clone();
			System.out.println(m3);
			System.out.println(m4);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
