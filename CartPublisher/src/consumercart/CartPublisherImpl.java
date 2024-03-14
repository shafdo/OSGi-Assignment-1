package consumercart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartPublisherImpl implements CartPublisher{
	
	private List<Products> productsInCart;
	private List<ProductsDisplay> allProducts;
	final Scanner sc = new Scanner(System.in);
	
	String[] productSample = {"Light Bulb", "Magnets", "Postcards", "T-shirts", "Perfume"};
	
	public CartPublisherImpl(){
		this.productsInCart = new ArrayList();
		this.allProducts = new ArrayList();
		retrieveItemsAndStore();
	}
	public void retrieveItemsAndStore() {	
		for(int i = 0; i < 5; i++) {
			String productName = productSample[i];
            double productPrice = 100 * (1+i);
            int productIndex = i;
            ProductsDisplay product = new ProductsDisplay(productName, productPrice, productIndex);
            allProducts.add(product);
		}
	}
	
	private void generateBill() {
		double finalBill = 0;
		for (Products product : productsInCart) {
            System.out.println(" Name: " + product.getProductName() + ", Price: " + product.getProductprice() + ", Quantity: " + product.getproductQuantity());
            finalBill = (product.getProductprice() * product.getproductQuantity())  + finalBill;
        }
		System.out.println("Final bill amount is: " + finalBill);
	}
	
	@Override
	public void displayProducts() {
		// TODO Auto-generated method stub
		System.out.println("\n------------------ Product list ------------------\n");
        for (ProductsDisplay product : allProducts) {
            System.out.println((product.getProductIndex() + 1) + " Name: " + product.getProductName() + ", Price: " + product.getProductprice());
        }
	}
	@Override
	public void addToCart(int productNum, int quantityreq) {
		// TODO Auto-generated method stub
		for (ProductsDisplay product : allProducts) {
            int tempInd = product.getProductIndex();
            String name = product.getProductName();
            double price = product.getProductprice();
            
            if(tempInd == productNum - 1) {
            	Products addproduct = new Products(name, price, quantityreq);
            	productsInCart.add(addproduct);
            	System.out.println(name + " was successfully added to cart!");
            }
        }
	}
	@Override
	public void displayBill() {
		// TODO Auto-generated method stub
		double finalBill = 0;
		System.out.println("\n==================== Bill ====================");
		for (Products product : productsInCart) {
            System.out.println("Product name: " + product.getProductName() + ", Price: " + product.getProductprice() + ", Quantity: " + product.getproductQuantity());
            finalBill = (product.getProductprice() * product.getproductQuantity())  + finalBill;
        }
		System.out.println("\nTotal bill amount is: Rs." + finalBill);
		System.out.println("================================================\n");
	}
	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		productsInCart.clear();
	}
}
