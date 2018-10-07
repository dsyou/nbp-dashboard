package pl.dashboard.nbp.features.exchange.mapper;

import org.junit.Test;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyExternalDetails;
import pl.dashboard.nbp.features.exchange.model.Currency;
import pl.dashboard.nbp.features.exchange.model.CurrencyCode;

import static org.junit.Assert.assertEquals;

/**
 * @author Dawid Janik
 * @since 07.10.2018
 */
public class CurrencyMapperTest {

    private static Float ask = 3.7735f;
    private static Float bid = 3.6987f;
    private static String code = CurrencyCode.USD.name();

    CurrencyMapper currencyMapper = CurrencyMapper.INSTANCE;

    @Test
    public void toCurrency() {

        //given
        NbpCurrencyExternalDetails nbpCurrencyExternalDetails = NbpCurrencyExternalDetails.builder()
                .ask(ask)
                .bid(bid)
                .code(code)
                .build();

        //when
        Currency currency = currencyMapper.toCurrency(nbpCurrencyExternalDetails);

        //then
        assertEquals(ask, currency.getAsk());
        assertEquals(bid, currency.getBid());
        assertEquals(code, currency.getCurrencyCode().name());
    }

}