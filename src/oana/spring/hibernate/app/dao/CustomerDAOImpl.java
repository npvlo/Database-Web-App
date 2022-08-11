package oana.spring.hibernate.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oana.spring.hibernate.app.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//inject hibernate session factory - DAO uses it to talk to the database
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> query = 
				currentSession.createQuery("from Customer", Customer.class);
		
		//execute the query and get result list
		List<Customer> customers = query.getResultList();
		
		//return the results
		return customers;
	}

}
