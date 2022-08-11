package oana.spring.hibernate.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oana.spring.hibernate.app.dao.CustomerDAO;
import oana.spring.hibernate.app.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//injecting the DAO into the controller
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		//get customers from dao
		List<Customer> customers = customerDAO.getCustomers();
		
		//add customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
