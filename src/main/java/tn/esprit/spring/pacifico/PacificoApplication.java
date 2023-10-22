package tn.esprit.spring.pacifico;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class PacificoApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(PacificoApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper()
    {

        return new ModelMapper();
    }

}
