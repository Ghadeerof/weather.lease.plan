package com.weather.leaseplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@SpringBootApplication
@ComponentScan({
		"com.weather.leaseplan.config",
		"com.weather.leaseplan.controller",
		"com.weather.leaseplan.service",
		"com.weather.leaseplan.repository"
})
@EntityScan("com.weather.leaseplan.entity")
public class LeasePlanApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(LeasePlanApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try{
			System.out.println("Our DataSource is = " + dataSource);
			//seedDatabase();
		}catch (Exception ex){
			System.out.println("Lease Plan Application : " + ex.getMessage());
		}
	}

}
