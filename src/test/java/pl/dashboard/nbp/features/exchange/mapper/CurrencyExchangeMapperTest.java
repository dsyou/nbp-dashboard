package pl.dashboard.nbp.features.exchange.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dashboard.nbp.features.exchange.dto.CurrencyTableDetails;
import pl.dashboard.nbp.features.exchange.model.Currency;
import pl.dashboard.nbp.features.exchange.model.CurrencyCode;
import pl.dashboard.nbp.features.exchange.model.CurrencyTable;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * @author Dawid Janik
 * @since 07.10.2018
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CurrencyExchangeMapperTest {

    private static CurrencyCode usCurrencyCode = CurrencyCode.USD;
    private static String date = "2016-04-04";
    private static Float usAsk = 3.6929f;
    private static Float usBid = 3.7675f;

    CurrencyExchangeMapper currencyExchangeMapper = CurrencyExchangeMapper.INSTANCE;

    @Ignore
    @Test
    public void toCurrencyTableDetails() {

        //given
        Currency currency = Currency.builder()
                .currencyCode(usCurrencyCode)
                .bid(usBid)
                .ask(usAsk)
                .build();

        CurrencyTable currencyTable = CurrencyTable.builder()
                .exchangeDate(date)
                .currencies(Collections.singletonList(currency))
                .build();

        //when
        CurrencyTableDetails currencyTableDetails = currencyExchangeMapper.toCurrencyTableDetails(currencyTable);

        //then
        assertEquals(date, currencyTableDetails.getExchangeDate());
    }
}