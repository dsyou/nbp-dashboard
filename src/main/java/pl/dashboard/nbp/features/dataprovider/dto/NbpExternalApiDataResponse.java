package pl.dashboard.nbp.features.dataprovider.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class NbpExternalApiDataResponse {

    @JsonProperty("table")
    private String table;

    @JsonProperty("no")
    private String no;

    @JsonProperty("tradingDate")
    private String tradingDate;

    @JsonProperty("effectiveDate")
    private String effectiveDate;

    @JsonProperty("rates")
    private List<NbpExternalApiData> rates;
}
