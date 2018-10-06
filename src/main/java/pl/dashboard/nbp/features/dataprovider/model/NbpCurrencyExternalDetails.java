package pl.dashboard.nbp.features.dataprovider.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dawid Janik
 * @since 06.10.2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NbpCurrencyExternalDetails {
    private String code;
    private Float bid;
    private Float ask;
}
