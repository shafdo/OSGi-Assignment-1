package consumercart;

public class Products {
	private String productName;
	private double productPrice;
	private int productQuantity;
	
	public Products(String productName,double productPrice,int productQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	
	public Products() {
		super();
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductprice() {
		return productPrice;
	}
	public void setProductprice(double productprice) {
		this.productPrice = productprice;
	}
	public int getproductQuantity() {
		return productQuantity;
	}
	public void setproductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
