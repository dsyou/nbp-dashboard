package pl.dashboard.nbp.features.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dawid Janik
 * @since 07.10.2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    private CurrencyCode currencyCode;
    private Float bid;
    private Float ask;
}
