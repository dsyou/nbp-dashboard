package pl.dashboard.nbp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.dashboard.nbp.features.exchange.CurrencyExchangeService;

import java.util.Arrays;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Slf4j
@SpringBootApplication
public class NbpApplication  {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(NbpApplication.class, args);
    }


}
