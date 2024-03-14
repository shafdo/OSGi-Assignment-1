package productservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class ProductActivator implements BundleActivator {
	ServiceRegistration publishServiceRegistration;
	

	public void start(BundleContext Context) throws Exception {
		System.out.println("Product Add-On service Service Start");
		ProductPublish parmacyservice = new ProductPublishImpl();
		publishServiceRegistration = Context.registerService(
		ProductPublish.class.getName(), parmacyservice, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Parmacy service Service Stop");
		publishServiceRegistration.unregister();
	}

}
