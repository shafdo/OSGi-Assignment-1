package com.subscriber.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.publisher.service.ServicePublisher;

public class ServiceActivator implements BundleActivator {

	// Service reference handler
	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Service Subscriber Started...");
		
		// Create new reference to the Service Publisher
		serviceReference = context.getServiceReference(ServicePublisher.class.getName());
		
		ServicePublisher servicePublish = (ServicePublisher)context.getService(serviceReference);
		System.out.println(servicePublish.publishService());
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping Service Subscriber...");
		context.ungetService(serviceReference);
	}

}
