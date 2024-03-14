package productservicesubscriber;

import java.awt.DisplayMode;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import productservicepublisher.ProductService;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Consumer Service");
		serviceReference = context.getServiceReference(ProductService.class.getName());
		ProductService productService = (ProductService)context.getService(serviceReference);
		productService.displayProductsOrExit();
		//System.out.println(productService.getAllProducts());
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!!!");
		context.ungetService(serviceReference);
	}

}
