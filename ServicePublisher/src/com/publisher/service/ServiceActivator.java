package com.publisher.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	// Register service handler
	ServiceRegistration publisherServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Service Publisher Started...");
		ServicePublisher publishService = new ServicePublisherImpl();
		
		// Register ServicePublisher
		publisherServiceRegistration = context.registerService(ServicePublisher.class.getName(), publishService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Service Publisher...");
		publisherServiceRegistration.unregister();
	}

}
