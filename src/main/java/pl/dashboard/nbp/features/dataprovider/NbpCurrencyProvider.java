package pl.dashboard.nbp.features.dataprovider;

import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyDetails;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
public interface NbpCurrencyProvider {
    NbpCurrencyDetails getNbpRates(String exchangeDate);
}
