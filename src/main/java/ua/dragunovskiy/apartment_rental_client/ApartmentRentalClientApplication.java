package ua.dragunovskiy.apartment_rental_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.dragunovskiy.apartment_rental_client.config.MyConfiguration;

@SpringBootApplication
public class ApartmentRentalClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApartmentRentalClientApplication.class, args);
    }

}
