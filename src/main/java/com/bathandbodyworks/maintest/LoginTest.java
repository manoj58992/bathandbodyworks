package com.bathandbodyworks.maintest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bathandbodyworks.entities.CustomerLoginEntity;
import com.bathandbodyworks.repositories.CustomerLoginRepository;

public class LoginTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("bathandbody-context.xml");

		CustomerLoginRepository ulr = (CustomerLoginRepository) ctx.getBean("customerLoginRepository");

		// username : manoj
		// password : jackson123

		String username = "manoj";
		String password = "jackson123";

		CustomerLoginEntity cl = ulr.getByUsername(username);
		
		if (cl == null) {
			System.out.println("Username : " + username + " doesnt exits");
			
		} else {
			String encryptedPassword = DigestUtils.sha256Hex(password);
			
			if (encryptedPassword.equals(cl.getPassword())) {
				System.out.println("You are logged in");
				System.out.println(cl.getCustomer().toString());
				
			} else {
				System.out.println("Incorrect password");
			}
		}
	}
}
