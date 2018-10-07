package pl.dashboard.nbp.features.util;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Dawid Janik
 * @since 07.10.2018
 */
@Slf4j
@SuppressWarnings("unused")
public class CollectorsUtils {

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }
}
