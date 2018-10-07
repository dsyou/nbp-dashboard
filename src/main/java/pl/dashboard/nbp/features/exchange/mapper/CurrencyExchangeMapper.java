package pl.dashboard.nbp.features.exchange.mapper;

import org.mapstruct.Mapper;
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
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CurrencyExchangeMapper {

    CurrencyExchangeMapper INSTANCE = Mappers.getMapper(CurrencyExchangeMapper.class);

    CurrencyTableDetails toCurrencyTableDetails(CurrencyTable currencyTable);
}
