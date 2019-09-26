package com.shani.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@ServletComponentScan
@SpringBootApplication
public class VehicleManagmentSystemApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {

		SpringApplication.run(VehicleManagmentSystemApplication.class, args);
	}

}
