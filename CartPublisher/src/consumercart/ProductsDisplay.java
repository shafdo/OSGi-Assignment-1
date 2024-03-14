package consumercart;

public class ProductsDisplay {
	private int productIndex;
	private String productName;
	private double productPrice;
	
	public ProductsDisplay(String productName,double productPrice,int productIndex) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productIndex = productIndex;
	}
	
	public ProductsDisplay() {
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
	public int getProductIndex() {
		return productIndex;
	}
	public void setProductIndex(int productIndex) {
		this.productIndex = productIndex;
	}
}
