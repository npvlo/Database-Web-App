package oana.spring.hibernate.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oana.spring.hibernate.app.dao.CustomerDAO;
import oana.spring.hibernate.app.entity.Customer;
import oana.spring.hibernate.app.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//injecting the customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//get customers from the service
		List<Customer> customers = customerService.getCustomers();
		
		//add customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
