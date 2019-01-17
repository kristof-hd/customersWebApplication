package be.vdab.customersWebApplication.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

import be.vdab.customersWebApplication.entities.Customer;

@Component
public class CustomerMessageProducer {

	private final RabbitTemplate template;
	
	public CustomerMessageProducer(RabbitTemplate template) {
		this.template=template;
	}
	
	public void produceMessage(Customer customer) {
		template.setMessageConverter(new Jackson2JsonMessageConverter()); 
		template.convertAndSend("newCustomerQueue", customer);
	}
	
}