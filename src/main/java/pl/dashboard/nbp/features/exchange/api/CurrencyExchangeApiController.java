package pl.dashboard.nbp.features.exchange.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dashboard.nbp.features.exchange.CurrencyExchangeService;
import pl.dashboard.nbp.features.exchange.dto.CurrencyTableDetails;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("currency-details")
@SuppressWarnings("unused")
public class CurrencyExchangeApiController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("{date}")
    @ResponseStatus(HttpStatus.OK)
    public CurrencyTableDetails getCurrencyTableDetailsByDate(@PathVariable String date) {
        return currencyExchangeService.getCurrencyTableDetailsByDate(date);
    }
}
