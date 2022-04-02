package com.example.springtestcontainers.unittest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springtestcontainers.AbstractContainerBaseTest;
import com.example.springtestcontainers.Customer;
import com.example.springtestcontainers.CustomerRepository;

@TCDataJpaTest
class CustomerRepositoryTest extends AbstractContainerBaseTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void create_customer(){
		Customer customer = new Customer(1L, "123", "lee");
		Customer save = customerRepository.save(customer);
		System.out.println("save = " + save.getId());
	}

	@Test
	void schema_script_data_should_be_three() {
		customerRepository.save(new Customer(1L, "123", "lee"));
		customerRepository.save(new Customer(2L, "123", "lee"));
		customerRepository.save(new Customer(3L, "123", "lee"));


		List<Customer> customers = customerRepository.findAll();
		customers.forEach(System.out::println);
		assertEquals(customers.size(), 3);
	}
}