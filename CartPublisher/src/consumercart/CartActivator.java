package consumercart;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class CartActivator implements BundleActivator {
	
	ServiceRegistration serviceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		final CartPublisher serviceMenu = (CartPublisher) new CartPublisherImpl();
        this.serviceRegistration = context.registerService(CartPublisher.class.getName(), (Object)serviceMenu, null);
		System.out.println("Cart server started!");
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Cart server stopped");
		serviceRegistration.unregister();
	}

}
