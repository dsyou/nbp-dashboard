package pl.dashboard.nbp.features.dataprovider.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import pl.dashboard.nbp.features.dataprovider.dto.NbpExternalApiData;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyExternalDetails;
import pl.dashboard.nbp.features.util.CentralConfigMapper;

/**
 * @author Dawid Janik
 * @since 06.10.2018
 */
@Mapper(
        config = CentralConfigMapper.class,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface NbpCurrencyExternalMapper {

    NbpCurrencyExternalMapper INSTANCE = Mappers.getMapper(NbpCurrencyExternalMapper.class);

    @Mapping(target = "code", source = "code")
    @Mapping(target = "ask", source = "ask")
    @Mapping(target = "bid", source = "bid")
    NbpCurrencyExternalDetails toNbpCurrencyExternalDetails(NbpExternalApiData nbpExternalApiData);
}
