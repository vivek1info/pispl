package com.pispl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class InfosystemApplication {
	
	@Bean
	public AuditorAware<String>auditorAware()
	{
		return new SpringSecusityAuditorAware();
	}

	public static void main(String[] args) {
		SpringApplication.run(InfosystemApplication.class, args);
	}

}
