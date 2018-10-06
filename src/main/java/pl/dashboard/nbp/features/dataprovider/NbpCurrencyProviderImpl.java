package pl.dashboard.nbp.features.dataprovider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.dashboard.nbp.features.dataprovider.dto.NbpExternalApiDataResponse;
import pl.dashboard.nbp.features.dataprovider.mapper.NbpCurrencyMapper;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyDetails;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NbpCurrencyProviderImpl implements NbpCurrencyProvider {

    private static final String NBP_API_ENDPOINT = "http://api.nbp.pl/api/exchangerates/tables/";
    private static final String NBP_API_CURRENCY_TABLE = "c/";

    private static final int TIMEOUT = 10000;

    private final RestTemplateBuilder restTemplateBuilder;

    private final NbpCurrencyMapper nbpCurrencyMapper;

    private RestTemplate getRestTemplate() {
        restTemplateBuilder.setConnectTimeout(TIMEOUT);
        restTemplateBuilder.setReadTimeout(TIMEOUT);
        return restTemplateBuilder.build();
    }

    @Override
    public NbpCurrencyDetails getNbpRates(String exchangeDate) {
        NbpCurrencyDetails nbpCurrencyDetails;
        RestTemplate restTemplate = getRestTemplate();
        Optional<NbpCurrencyDetails> detailsOptional = getNbpRates(exchangeDate, restTemplate);

        nbpCurrencyDetails = detailsOptional.orElseThrow(null); // TODO NULL
        return nbpCurrencyDetails;
    }

    private Optional<String> checkDate(String exchangeDate) {
        String result = null;
        if (true == true) { // todo dj <-()
            result = exchangeDate;
        }
        return Optional.ofNullable(result);
    }

    private Optional<NbpCurrencyDetails> getNbpRates(String exchangeDate, RestTemplate restTemplate) {
        try {
            NbpExternalApiDataResponse[] resp = restTemplate.getForObject(
                    NBP_API_ENDPOINT + NBP_API_CURRENCY_TABLE + exchangeDate,
                    NbpExternalApiDataResponse[].class
            );
            if (resp == null) {
                log.error("There is not output from NBP Api"); // + throw
            }

            List<NbpExternalApiDataResponse> nbpExternalApiDataResponses = Arrays.asList(resp);
            if (nbpExternalApiDataResponses.size() != 1) {
                log.error("Incorrect parsing NBP data into NbpCurrencyDetails.class");
            }

            NbpExternalApiDataResponse nbpExternalApiDataResponse = nbpExternalApiDataResponses.get(0);
            return Optional.of(nbpCurrencyMapper.toNbpCurrencyDetails(nbpExternalApiDataResponse));
        } catch (RestClientException ex) {
            log.warn("Connection failed to load NBP data from NBP API");
            return Optional.empty();
        }
    }
}
