package pl.dashboard.nbp.features.exchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dashboard.nbp.features.exchange.dto.CurrencyTableDetails;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Override
    public CurrencyTableDetails getCurrencyTableDetailsByDate(String date) {
        return null;
    }
}
