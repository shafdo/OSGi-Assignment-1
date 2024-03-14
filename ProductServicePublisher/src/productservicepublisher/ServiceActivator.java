package productservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Producer Started!!!");
		ProductService productsService = new ProductServiceImpl();
	
		publishServiceRegistration = context.registerService(ProductService.class.getName(), productsService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Producer Stopped!!!");
		publishServiceRegistration.unregister();
	}

}
