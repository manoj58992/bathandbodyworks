package com.bathandbodyworks.maintest;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bathandbodyworks.entities.CustomerEntity;
import com.bathandbodyworks.entities.CustomerLoginEntity;
import com.bathandbodyworks.repositories.CustomerRepository;

public class OneToOneCustomerTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("bathandbody-context.xml");

		CustomerRepository cr = (CustomerRepository) ctx.getBean("customerRepository");

		CustomerEntity c = new CustomerEntity();
		c.setName("Manoj Regmi");
		c.setEmail("manoz.chettri@gmail.com");
		c.setGender("Male");

		CustomerLoginEntity login = new CustomerLoginEntity();
		login.setUsername("manoj");
		login.setPassword(DigestUtils.sha256Hex("jackson123"));
		login.setLastSignOn(new Date());

		login.setCustomer(c);

		cr.save(login);
		cr.save(c);
	}

}
