package assignments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ArraysAndMaterials {
	public static void main(String[] args) {
		String[] matDesc = {"steel","iron","zinc","carbonsteel","lubricant oil","coconut oil","edible oil"};
		Material[] m = getRandomMaterials(10, 501, 600, matDesc, 10000, 50000, UOM.values());
		
		for(Material material:m) {
			System.out.println(material);
		}
		
		Arrays.sort(m,sortMaterialByUOMAndQuantity());
		
		System.out.println("~".repeat(40));
		System.out.println("After sorting");
		
		for(Material material:m) {
			System.out.println(material);
		}
	}
	private static Material[] getRandomMaterials(int noOfMats, int minMatId,
												int maxMatId,
												String[] matDesc,
												int minQuantity,
												int maxQuantity,
												UOM[] uom) {
		Random random = new Random();
		Material[] materials = new Material[noOfMats];
//		UOM[] unitOfM = uom.values();
		for(int i = 0;i<noOfMats;i++) {
			materials[i] = new Material(random.nextInt(maxMatId-minMatId+1)+minMatId,
										matDesc[random.nextInt(matDesc.length)],
										random.nextInt(maxQuantity-minQuantity+1)+minQuantity,
										uom[random.nextInt(uom.length)]);
		}
		return materials;
		
	}
	
	private static Comparator<Material> sortMaterialByUOMAndQuantity(){
		return new Comparator<Material>() {
			
			@Override
			public int compare(Material o1, Material o2) {
				int uomValue = (o1.getUom().getValue(o1.getUom()))-(o2.getUom().getValue(o2.getUom()));
				if(uomValue==0) 
					return o1.getQuantity()-o2.getQuantity();
				return uomValue;
			}
		};
		
		
	}
	private static Comparator<Material> sortMaterialById(){
		return new Comparator<Material>() {
			@Override
			public int compare(Material o1, Material o2) {
				return o1.getMatId()-o2.getMatId();
			}
		};
	}
	
	private static Comparator<Material> sortMaterialByDesc(){
		return new Comparator<Material>() {
			@Override
			public int compare(Material o1, Material o2) {
				return o1.getMatDesc().compareTo(o2.getMatDesc());
			}
		};
	}
}
