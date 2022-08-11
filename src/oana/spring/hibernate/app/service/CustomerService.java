package oana.spring.hibernate.app.service;

import java.util.List;

import oana.spring.hibernate.app.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
