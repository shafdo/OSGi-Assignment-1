package productsubscriber;


import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


import productservicepublisher.ProductPublish;

public class ProductActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	
	private char selection;
	Scanner input = new Scanner(System.in);
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		

		System.out.println("Start subscriber service");
		System.out.println();
		
		while(true) {
		System.out.println("Do you want to add products to the store?");
		System.out.println();
		System.out.println("Press S to stop");
		System.out.print("Press Y to continue: ");
		selection = input.next().charAt(0);
		
		while(selection=='Y' || selection=='y') {
		
			serviceReference=context.getServiceReference(ProductPublish.class.getName());
			ProductPublish productpublish=(ProductPublish)context.getService(serviceReference);
			selection = productpublish.publishproduct();
		}
		
		
		
		if(selection=='S' || selection=='s') {
			System.out.println("-------------------------------------");
			System.out.println("Ending of products addition ");
			System.out.println("-------------------------------------");
			
			System.out.print("Do you want to view the product list: Press Y if yes or press S to exit? ");
			selection = input.next().charAt(0);
			
			if (selection == 'Y' || selection == 'y') {
				serviceReference=context.getServiceReference(ProductPublish.class.getName());
				ProductPublish productpublish=(ProductPublish)context.getService(serviceReference);
				productpublish.viewlist();
				
				System.out.print("Would you like to add the products to the store. Press Y if you confirm. Or press N if you want to remove the previously added products");
				selection = input.next().charAt(0);
				System.out.println();
				
				if (selection == 'Y' || selection == 'y') {
					serviceReference=context.getServiceReference(ProductPublish.class.getName());
					productpublish=(ProductPublish)context.getService(serviceReference);
					selection = productpublish.addProducts();
				} else {
					serviceReference=context.getServiceReference(ProductPublish.class.getName());
					productpublish=(ProductPublish)context.getService(serviceReference);
					selection = productpublish.deleteProducts();
				}
				
			} else {
				break;
			}
		}	
	}
	
	
	
	
	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Stop supplier service");
		context.ungetService(serviceReference);
		
	}



}


