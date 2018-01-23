package za.co.student.fix.it.communication.engine.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * App class for bootstrapping the communication app class
 */
@SpringBootApplication
@ComponentScan(basePackages = {"za.co.student.fix.it.communication.engine.web",
        "za.co.student.fix.it.communication.engine.email.config"})
public class SpringBootWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
