package pl.dashboard.nbp.features.exchange.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import pl.dashboard.nbp.features.exchange.dto.CurrencyTableDetails;
import pl.dashboard.nbp.features.exchange.model.CurrencyTable;
import pl.dashboard.nbp.features.util.CentralConfigMapper;

/**
 * @author Dawid Janik
 * @since 07.10.2018
 */
@Mapper(
        config = CentralConfigMapper.class,
        uses = {CurrencyMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CurrencyExchangeMapper {

    CurrencyExchangeMapper INSTANCE = Mappers.getMapper(CurrencyExchangeMapper.class);

    @Mapping(target = "exchangeDate", source = "exchangeDate")
    @Mapping(target = "currencyDetails", source = "currencies")
    CurrencyTableDetails toCurrencyTableDetails(CurrencyTable currencyTable);
}
