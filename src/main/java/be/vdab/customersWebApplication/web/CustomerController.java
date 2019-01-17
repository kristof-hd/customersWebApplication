package be.vdab.customersWebApplication.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.customersWebApplication.entities.Customer;
import be.vdab.customersWebApplication.services.CustomerService;

@Controller
@RequestMapping("/")
class CustomerController {

	private final CustomerService customerService; 
	private static final String TOEVOEGEN_VIEW = "toevoegen";
	
	CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	@GetMapping("toevoegen") 
	ModelAndView toevoegen() {
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Customer()); 
	}
	
	@PostMapping("toevoegen")
	ModelAndView toevoegen(Customer customer) {
		customerService.produceMessage(customer); 
		return new ModelAndView(TOEVOEGEN_VIEW); 
	}

}