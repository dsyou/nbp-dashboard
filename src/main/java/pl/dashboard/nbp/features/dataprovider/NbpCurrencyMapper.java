package pl.dashboard.nbp.features.dataprovider;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import pl.dashboard.nbp.features.dataprovider.dto.NbpExternalApiResponse;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyDetails;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface NbpCurrencyMapper {


    NbpCurrencyDetails toNbpCurrencyDetails(NbpExternalApiResponse apiResponse);
}
