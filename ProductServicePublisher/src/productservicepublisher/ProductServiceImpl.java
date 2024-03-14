package productservicepublisher;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {

	private static final Product[] PRODUCTS_DATA = {
	        new Product("Coffee", 10.0),
	        new Product("Orange Juice", 20.0),
	        new Product("Water", 30.0)
	};

 	public List<Product> getAllProducts() {
	
	 		System.out.println("Products");
	 		System.out.println("===============");
	 		
	 		int index = 1;
	 		
	 		List<Product> products = new ArrayList<>();
	        for (int i = 0; i < PRODUCTS_DATA.length; i++) {
	            String name = PRODUCTS_DATA[i].getName();
	            double price = PRODUCTS_DATA[i].getPrice();
	            System.out.println((i + 1) + ". " + name + " - Rs " + price);
	            products.add(PRODUCTS_DATA[i]);
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
        	System.out.println("Enter the ID of the product (-2 to quit):");
            int index = scanner.nextInt();
            scanner.nextLine();
            
            if (index == -2) {
                System.out.println("Exiting the function...");
                return null;
            }
        	
	        if (index < 1 || index > PRODUCTS_DATA.length) {
	            System.out.println("Invalid ID. Please enter a valid ID.");
	            continue;
	        }
	
	    System.out.println(PRODUCTS_DATA[index - 1]);
            return PRODUCTS_DATA[index - 1]; 
        }
    }
 	

}