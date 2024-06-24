package org.jfs.day01;

public class Material implements Cloneable{
	private final int materialNo;
	private String materialDesc;
	private IndustrialSector industrialSector;
	
	public Material() {
		this.materialNo = 0;
		}
	public Material(int materialNo,String materialDesc,IndustrialSector industrialSector) {
		this.materialNo = materialNo;
		this.materialDesc = materialDesc;
		this.industrialSector = industrialSector;
	}
	public Material(Material m) {
		this.materialNo = m.materialNo;
		this.materialDesc = m.materialDesc;
		this.industrialSector = m.industrialSector;
	}
	@Override
	public String toString() {
		return "Material [materialNo=" + materialNo + ", materialDesc=" + materialDesc + ", industrialSector="
				+ industrialSector + "]";
	}
	public int getMaterialNo() {
		return materialNo;
	}
//	public void setMaterialNo(int materialNo) {
//		this.materialNo = materialNo;
//	}
	public String getMaterialDesc() {
		return materialDesc;
	}
	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}
	public IndustrialSector getIndustrialSector() {
		return industrialSector;
	}
	public void setIndustrialSector(IndustrialSector industrialSector) {
		this.industrialSector = industrialSector;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
