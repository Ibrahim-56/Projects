package std;

public class Drug {
 private String name;
 private String type;
 private int stock;
 private double pricePerUnit;
 public Drug(String name,String type, int stock,double pricePerUnit) {
	 this.name = name;
	 this.type = type;
	 this.stock= stock;
	 this.pricePerUnit = pricePerUnit;
 }
	public String getName() {
		return name;
	}
	public int getstock() {
		return stock;
	}
	public void setstock(int stock) {
		this.stock = stock;
	}
	public double getpricePerUnit() {
		return pricePerUnit;
	}
	
	
	
	
	
	
	
	
	
	
}
