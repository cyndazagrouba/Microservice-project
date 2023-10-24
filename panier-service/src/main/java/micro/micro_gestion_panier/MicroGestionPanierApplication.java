package micro.micro_gestion_panier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroGestionPanierApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroGestionPanierApplication.class, args);
    }

}
