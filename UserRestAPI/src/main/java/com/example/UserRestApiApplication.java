package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/**
 * @author biswa
 *
 */
@EntityScan(
        basePackageClasses = {UserRestApiApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication(scanBasePackages={"com.example"})
public class UserRestApiApplication extends SpringBootServletInitializer{

	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserRestApiApplication .class);
    }
    
    public static void main(String[] args) {
		SpringApplication.run(UserRestApiApplication.class, args);
	}
}