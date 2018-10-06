package pl.dashboard.nbp.features.dataprovider.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import pl.dashboard.nbp.features.dataprovider.dto.NbpExternalApiDataResponse;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyDetails;
import pl.dashboard.nbp.features.util.CentralConfigMapper;

/**
 * @author Dawid Janik
 * @since 2018.10.05
 */
@Mapper(
        config = CentralConfigMapper.class,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {NbpCurrencyExternalMapper.class}
)
public interface NbpCurrencyMapper {

    NbpCurrencyMapper INSTANCE = Mappers.getMapper(NbpCurrencyMapper.class);

    @Mapping(target = "tradingDate", source = "tradingDate")
    @Mapping(target = "effectiveDate", source = "effectiveDate")
    @Mapping(target = "rates", source = "rates")
    NbpCurrencyDetails toNbpCurrencyDetails(NbpExternalApiDataResponse apiResponse);
}
