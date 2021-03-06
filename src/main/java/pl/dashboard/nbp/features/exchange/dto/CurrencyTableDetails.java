package pl.dashboard.nbp.features.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyTableDetails {
    private String exchangeDate;
    private List<CurrencyDetails> currencyDetails;
}
