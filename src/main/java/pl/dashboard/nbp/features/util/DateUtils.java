package pl.dashboard.nbp.features.util;

import lombok.extern.slf4j.Slf4j;
import pl.dashboard.nbp.features.util.exception.NotProperDateException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * @author Dawid Janik
 * @since 07.10.2018
 */
@Slf4j
@SuppressWarnings("unused")
public class DateUtils {

    public static String checkDate(String givenDate) {
        try {
            String epochTime = "2002-01-02"; // value taken from api.nbp 2 January 2002 <- convert to javadoc,
            LocalDate epochDate = LocalDate.parse(epochTime);
            if (!LocalDate.parse(givenDate).isAfter(epochDate)) {
                throw new NotProperDateException("Given date: " + givenDate + " is older than  ");
            }
            return givenDate;
        } catch (DateTimeParseException ex) {
            throw new NotProperDateException("Given value: " + givenDate + " is not proper date");
        }
    }
}
