package pl.dashboard.nbp.features.dataprovider.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDateProblem extends RuntimeException {
    public InvalidDateProblem(String exchangeDate) {
        super(exchangeDate); // todo dj () <-
    }
}
