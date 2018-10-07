package pl.dashboard.nbp.features.exchange.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyExternalDetails;
import pl.dashboard.nbp.features.exchange.model.Currency;
import pl.dashboard.nbp.features.util.CentralConfigMapper;

/**
 * @author Dawid Janik
 * @since 07.10.2018
 */
@Mapper(
        config = CentralConfigMapper.class,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CurrencyMapper {

    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    Currency toCurrency(NbpCurrencyExternalDetails nbpCurrencyExternalDetails);
}
