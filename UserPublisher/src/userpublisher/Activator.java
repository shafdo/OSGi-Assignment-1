package userpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration regService;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("[+] Register Publisher Starting..!");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("[+] Stopping Register Publisher..!");
		regService.unregister();
	}

}
