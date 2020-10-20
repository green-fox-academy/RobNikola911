package com.exercise.webapp;

import com.exercise.webapp.services.MyColor;
import com.exercise.webapp.services.RedColorImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappApplication implements CommandLineRunner {

    private final MyColor myColor;

    public WebappApplication(MyColor myColor) {
        this.myColor = myColor;
    }

//    @Autowired
//    public WebappApplication(Printer printer, RedColorImpl redColor) {
//        this.printer = printer;
//        this.redColor = redColor;
//    }

    public static void main(String[] args) {
        SpringApplication.run(WebappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        myColor.printColor();
//        myColor.printColor();
//        printer.log("I am the Printer service");
//        redColor.printColor();
    }
}
