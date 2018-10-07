package pl.dashboard.nbp.features.exchange;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dashboard.nbp.features.dataprovider.NbpCurrencyProvider;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyDetails;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyExternalDetails;
import pl.dashboard.nbp.features.exchange.dto.CurrencyTableDetails;
import pl.dashboard.nbp.features.exchange.mapper.CurrencyExchangeMapper;
import pl.dashboard.nbp.features.exchange.mapper.CurrencyMapper;
import pl.dashboard.nbp.features.exchange.model.Currency;
import pl.dashboard.nbp.features.exchange.model.CurrencyCode;
import pl.dashboard.nbp.features.exchange.model.CurrencyTable;

import java.util.Arrays;
import java.util.List;

import static pl.dashboard.nbp.features.util.CollectorsUtils.toSingleton;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final NbpCurrencyProvider nbpCurrencyProvider;

    private final CurrencyMapper currencyMapper;
    private final CurrencyExchangeMapper currencyExchangeMapper;

    @Override
    public CurrencyTableDetails getCurrencyTableDetailsByDate(String exchangeDate) {
        log.info("Getting NBP Rates for following date: {}", exchangeDate); // todo reverse string
        // todo compare dates from param and returning from response
        NbpCurrencyDetails currencyDetails = nbpCurrencyProvider.getNbpRates(exchangeDate);
        List<NbpCurrencyExternalDetails> rates = currencyDetails.getRates();

        final Currency eur = rates.stream()
                .filter(r -> r.getCode().equals(CurrencyCode.EUR.name()))
                .map(currencyMapper::toCurrency)
                .collect(toSingleton());

        final Currency chf = rates.stream()
                .filter(r -> r.getCode().equals(CurrencyCode.CHF.name()))
                .map(currencyMapper::toCurrency)
                .collect(toSingleton());

        final Currency usd = rates.stream()
                .filter(r -> r.getCode().equals(CurrencyCode.USD.name()))
                .map(currencyMapper::toCurrency)
                .collect(toSingleton());

        final Currency gbp = rates.stream()
                .filter(r -> r.getCode().equals(CurrencyCode.GBP.name()))
                .map(currencyMapper::toCurrency)
                .collect(toSingleton());


        List<Currency> currencies = Arrays.asList(eur, chf, usd, gbp);

        CurrencyTable currencyTable = new CurrencyTable(
                exchangeDate,
                currencies
        );

        log.info("Waluta = kupno; sprzedaż");
        log.info("{} = {}; {}", CurrencyCode.EUR.name(), eur.getBid(), eur.getAsk());
        log.info("{} = {}; {}", CurrencyCode.CHF.name(), chf.getBid(), chf.getAsk());
        log.info("{} = {}; {}", CurrencyCode.USD.name(), usd.getBid(), usd.getAsk());
        log.info("{} = {}; {}", CurrencyCode.GBP.name(), gbp.getBid(), gbp.getAsk());

        return Option.of(currencyTable)
                .map(currencyExchangeMapper::toCurrencyTableDetails)
                .get();
    }

}
