package be.vdab.customersWebApplication.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.customersWebApplication.entities.Customer;
import be.vdab.customersWebApplication.messaging.CustomerMessageProducer;

@Service
@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
class DefaultCustomerService implements CustomerService {

	private final CustomerMessageProducer customerMessageProducer; 
	
	DefaultCustomerService(CustomerMessageProducer customerMessageProducer) {
		this.customerMessageProducer=customerMessageProducer; 
	}
	
	@Override
	public void produceMessage(Customer customer) {
		customerMessageProducer.produceMessage(customer); 
	}
	
}