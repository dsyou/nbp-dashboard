package pl.dashboard.nbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.dashboard.nbp.features.exchange.CurrencyExchangeService;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@SpringBootApplication
public class NbpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(NbpApplication.class, args);
        CurrencyExchangeService currencyExchangeService = ctx.getBean(CurrencyExchangeService.class);

        currencyExchangeService.getCurrencyTableDetailsByDate("2016-03-30");
    }
}
