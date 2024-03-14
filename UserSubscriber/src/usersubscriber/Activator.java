package usersubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		Utils utils = new Utils();
		
		System.out.println("Hello Welcome to eCommerce Store!");
		System.out.println("---------------------------------\n");
		
		boolean running = true;
		
		while(running) {
			
			if(!utils.AccountExists()) {
				boolean res = utils.RegisterInterface();
				if(res) {
					continue;				
				}
			} else {
				boolean res = utils.LoginInterface();
				if(res) {
					break;		
				}
				continue;
			}
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
