package com.exercise.webapp;

import com.exercise.webapp.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappApplication implements CommandLineRunner {

    private final Printer printer;

    @Autowired
    public WebappApplication(Printer printer) {
        this.printer = printer;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        printer.log("Hello Bean!");
    }
}
