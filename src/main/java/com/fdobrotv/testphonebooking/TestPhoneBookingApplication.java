package com.fdobrotv.testphonebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.fdobrotv.testphonebooking")
@EnableTransactionManagement
public class TestPhoneBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestPhoneBookingApplication.class, args);
	}

}
