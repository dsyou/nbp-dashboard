package pl.dashboard.nbp.features.exchange;

import pl.dashboard.nbp.features.exchange.dto.CurrencyTableDetails;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
public interface CurrencyExchangeService {
    CurrencyTableDetails getCurrencyTableDetailsByDate(String exchangeDate);
}
