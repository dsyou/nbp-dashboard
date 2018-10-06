package pl.dashboard.nbp.features.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyTableDetails {
    private String date;
    private String description;
    // USD ; [
    //    @JsonProperty("code")
    //    private String code;
    //
    //    @JsonProperty("bid")
    //    private Long bid;
    //
    //    @JsonProperty("ask")
    //    private Long ask;
    // ]
}
