package pl.dashboard.nbp.features.dataprovider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.dashboard.nbp.features.dataprovider.dto.NbpExternalApiResponse;
import pl.dashboard.nbp.features.dataprovider.exception.InvalidDateProblem;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyDetails;

import java.util.Optional;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NbpCurrencyProviderImpl implements NbpCurrencyProvider {

    private static final String NBP_API_ENDPOINT = "http://api.nbp.pl/api/exchangerates/tables/c/today/";

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

        String verifiedNip = checkDate(exchangeDate)
                .orElseThrow(() -> new InvalidDateProblem(exchangeDate));

        NbpCurrencyDetails nbpCurrencyDetails;
        RestTemplate restTemplate = getRestTemplate();
        Optional<NbpCurrencyDetails> detailsOptional = getNbpRates(exchangeDate, restTemplate);
        if (detailsOptional.isPresent()) {
            nbpCurrencyDetails = detailsOptional.get();
//            nbpCurrencyMapper.toNbpCurrencyDetails(nbpCurrencyDetails);
        } else {
            nbpCurrencyDetails = null;
        }
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
            NbpExternalApiResponse resp = restTemplate.getForObject(NBP_API_ENDPOINT + exchangeDate,
                    NbpExternalApiResponse.class);
            return Optional.of(nbpCurrencyMapper.toNbpCurrencyDetails(resp));
        } catch (RestClientException ex) {
            log.warn("Connection failed to load NBP data from NBP API");
            return Optional.empty();
        }
    }
}
