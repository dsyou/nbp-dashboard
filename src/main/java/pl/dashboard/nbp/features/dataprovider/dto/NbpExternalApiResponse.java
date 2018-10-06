package pl.dashboard.nbp.features.dataprovider.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
public class NbpExternalApiResponse {

    private String table;
    private String no;
    private LocalDateTime tradingDate;
    private LocalDateTime effectiveDate;


    private List<NbpExternalApiData> rates;
}
