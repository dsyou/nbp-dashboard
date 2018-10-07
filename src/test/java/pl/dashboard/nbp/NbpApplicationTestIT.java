package pl.dashboard.nbp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dashboard.nbp.features.exchange.CurrencyExchangeService;
import pl.dashboard.nbp.features.exchange.dto.CurrencyDetails;
import pl.dashboard.nbp.features.exchange.dto.CurrencyTableDetails;
import pl.dashboard.nbp.features.exchange.model.CurrencyCode;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Dawid
 * @since 07.10.2018
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class NbpApplicationTestIT {

    private static String date = "2016-04-04";
    private static Float usBid = 3.6929f;
    private static Float usAsk = 3.7675f;

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @Test
    public void main() {
        CurrencyTableDetails currencyTableDetailsByDate = currencyExchangeService.getCurrencyTableDetailsByDate(date);

        assertEquals(date, currencyTableDetailsByDate.getExchangeDate());

        List<CurrencyDetails> currencyDetails = currencyTableDetailsByDate.getCurrencyDetails();
        assertEquals(4, currencyDetails.size());

        currencyDetails.forEach(
                c -> {
                    if (!c.getCurrencyCode().equals(CurrencyCode.USD.name())) {
                        return;
                    } else {
                        assertEquals(usAsk, c.getAsk());
                        assertEquals(usBid, c.getBid());
                    }
                }
        );
    }

}