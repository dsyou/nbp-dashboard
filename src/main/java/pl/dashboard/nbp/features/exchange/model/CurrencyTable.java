package pl.dashboard.nbp.features.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Dawid Janik
 * @since 07.10.2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyTable {
    private String exchangeDate;
    private List<Currency> currencies;
}
