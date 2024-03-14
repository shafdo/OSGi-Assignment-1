package subscriber;

import java.util.Scanner;

import javax.naming.Context;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import consumercart.CartPublisher;

public class Activator implements BundleActivator {
	
	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int productNum = 0;
		int quantityreq = 0;
		
		serviceReference = context.getServiceReference(CartPublisher.class.getName());
    	CartPublisher cartPublisher = (CartPublisher)context.getService(this.serviceReference);
		
        
            while(ans != -1) {
                System.out.println("--------------------------------CART--------------------------------");
                System.out.println("If you want to continue and view the products enter 1, else enter -1");
                System.out.println(" 1  -  Continue");
                System.out.println("-1  -  EXIT");
                System.out.println("====================================================================\n");
                System.out.print("Enter your extension: ");

                
                ans = sc.nextInt();
                
                if(ans == 1) {
                	
                	while(productNum != -1) {
                    	cartPublisher.displayProducts();
                    	
                    	System.out.println("\nEnter -1 to exit or proceed to checkout if you have items in your cart");
                        System.out.print("Enter the ID of the product you need to add to cart: ");
                        System.out.println("\n=====================================================");
                        productNum = sc.nextInt();
                        
                        if(productNum == -1) {
                        	break;
                        }
                        System.out.println("Enter the quantity of product required in units: ");
                        quantityreq = sc.nextInt();
                        cartPublisher.addToCart(productNum, quantityreq);
                	}
                	cartPublisher.displayBill();
                	cartPublisher.clearCart();
                }
                else if(ans != 1 && ans != -1){
                	System.out.println("\nPlease enter a valid number!\n");
                }
            } 
            if(ans == -1) {
            	System.out.println("Exiting cart...");
            }
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Cart subscriber successfully stopped");
		context.ungetService(serviceReference);
	}

}
