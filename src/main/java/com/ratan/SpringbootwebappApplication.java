package com.ratan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebappApplication.class, args);
		
	}
	
	
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource ms) {
		
		LocalValidatorFactoryBean lvfb=new LocalValidatorFactoryBean();
		lvfb.setValidationMessageSource(ms);
		
		return lvfb;
		
	}
	
	
	

}
