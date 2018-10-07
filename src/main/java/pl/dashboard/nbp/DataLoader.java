package pl.dashboard.nbp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.dashboard.nbp.features.exchange.CurrencyExchangeService;

import java.util.Arrays;

/**
 * @author Dawid
 * @since 07.10.2018
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final CurrencyExchangeService currencyExchangeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        log.info("NonOptionArgs: {}", args.getNonOptionArgs());
        log.info("OptionNames: {}", args.getOptionNames());

        for (String name : args.getOptionNames()) {
            log.info("arg-" + name + "=" + args.getOptionValues(name));
        }

        boolean containsOption =  true ;// args.containsOption("exchange.date");
        log.info("Contains exchange.date: " + containsOption);
        String sourceArg = "";
        if (containsOption && args.getSourceArgs().length == 1) {
            sourceArg = args.getSourceArgs()[0];
            currencyExchangeService.getCurrencyTableDetailsByDate(sourceArg);
        } else {
            log.error("Runner do not contain proper argument called {}", sourceArg);
        }
    }
}
