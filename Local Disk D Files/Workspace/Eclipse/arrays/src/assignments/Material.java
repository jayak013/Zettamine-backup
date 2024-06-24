package assignments;

public class Material {
	private int matId;
	private String matDesc;
	private UOM uom;
	private int quantity;
	@Override
	public String toString() {
		return "Material [matId=" + matId + ", matDesc=" + matDesc + ", quantity=" + quantity + ", uom=" + uom + "]";
	}
	public Material() {}
	public Material(int matId, String matDesc, int quantity, UOM uom) {
		super();
		this.matId = matId;
		this.matDesc = matDesc;
		this.quantity = quantity;
		this.uom = uom;
	}
	public int getMatId() {
		return matId;
	}
	public void setMatId(int matId) {
		this.matId = matId;
	}
	public String getMatDesc() {
		return matDesc;
	}
	public void setMatDesc(String matDesc) {
		this.matDesc = matDesc;
	}
	public UOM getUom() {
		return uom;
	}
	public void setUom(UOM uom) {
		this.uom = uom;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
