package pl.dashboard.nbp.features.util.exception;

/**
 * @author Dawid
 * @since 07.10.2018
 */
public class NotProperDateException extends IllegalArgumentException {
    public NotProperDateException(String message) {
        super(message);
    }
}
