package pl.dashboard.nbp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Slf4j
@SpringBootApplication
public class NbpApplication  {

    public static void main(String[] args) {
         SpringApplication.run(NbpApplication.class, args);
    }

}
