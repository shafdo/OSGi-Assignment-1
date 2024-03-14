package productservicepublisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {

	 private static final HashMap<String, Double> PRODUCTS_DATA = new HashMap<>();

	    static {
	        
	        PRODUCTS_DATA.put("Coffee", 10.0);
	        PRODUCTS_DATA.put("Orange Juice", 20.0);
	        PRODUCTS_DATA.put("Water", 30.0);
	    }

 	public List<Product> getAllProducts() {
	
	 		System.out.println("Products");
	 		System.out.println("===============");
	 		
	 		int index = 1;
	 		
	        List<Product> products = new ArrayList<>();
	        
	        for (Map.Entry<String, Double> entry : PRODUCTS_DATA.entrySet()) {
	            String name = entry.getKey();
	            double price = entry.getValue();
	            System.out.println(index + ". " + name + " - Rs " + price);
	            index++;
	        }

	        return products;
	}
 	
 	public void displayProductsOrExit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you the admin? (Y/N)");
        String input = scanner.nextLine().trim().toLowerCase();
        
        if(input.equals("n")) {
            getAllProducts();
            System.out.println("Note: Enter -1 to checkout");
            String input2 = scanner.nextLine();
            
            	if(input2.equals("-1")) {
            		System.out.println("Redirecting to the cart");
            		getProductByIndex();
            		
            	}
        }else {
            System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            displayProductsOrExit(); 
        }
    }
 	
 	public Product getProductByIndex() {
 		Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("Enter the index of the product (-2 to quit):");
            int index = scanner.nextInt();
            scanner.nextLine();
            
            if (index == -2) {
                System.out.println("Exiting the function...");
                return null;
            }
        	
	        if (index < 1 || index > PRODUCTS_DATA.size()) {
	            System.out.println("Invalid index. Please enter a valid index.");
	            return null;
	        }
	
	        int currentIndex = 1;
	        for (Map.Entry<String, Double> entry : PRODUCTS_DATA.entrySet()) {
	            if (currentIndex == index) {
	                String name = entry.getKey();
	                double price = entry.getValue();
	                System.out.println(name + " -  Rs" + price);
	                return new Product(name, price);
	            }
	            currentIndex++;
	        }
	
	        
        }
    }
 	

}