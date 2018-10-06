package pl.dashboard.nbp.features.util;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * @author Dawid Janik
 * @since 06.10.2018
 */
@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CentralConfigMapper {
}
