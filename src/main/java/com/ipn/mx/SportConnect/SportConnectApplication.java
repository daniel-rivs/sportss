package com.ipn.mx.SportConnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Esta anotación incluye @Configuration, @EnableAutoConfiguration y @ComponentScan
public class SportConnectApplication {
//Si se quisiera implementar código aquí (códigos de prueba), se tiene que crear el método run
    //e implementar el CommandLineRunner
    public static void main(String[] args) {
        SpringApplication.run(SportConnectApplication.class, args);
    }
}
