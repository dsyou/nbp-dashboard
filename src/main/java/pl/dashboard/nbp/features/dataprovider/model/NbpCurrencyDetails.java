package pl.dashboard.nbp.features.dataprovider.model;

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
public class NbpCurrencyDetails {
    private String tradingDate;
    private String effectiveDate;
    private List<NbpCurrencyExternalDetails> rates;
}
