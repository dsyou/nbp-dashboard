package pl.dashboard.nbp.features.dataprovider;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Dawid Janik
 * @since 06.10.2018
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class NbpCurrencyProviderTest {

    private static String properDate = "2016-03-30";
    private static String notProperDate = "2016-03-40";

    @Autowired
    NbpCurrencyProvider nbpCurrencyProvider;

    @Test
    public void stage0_testDate() {
        nbpCurrencyProvider.getNbpRates(properDate);
    }
}
