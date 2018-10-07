package pl.dashboard.nbp.features.exchange.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import pl.dashboard.nbp.features.dataprovider.model.NbpCurrencyExternalDetails;
import pl.dashboard.nbp.features.exchange.dto.CurrencyDetails;
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

    @Mapping(target = "currencyCode", source = "code")
    @Mapping(target = "bid", source = "bid")
    @Mapping(target = "ask", source = "ask")
    Currency toCurrency(NbpCurrencyExternalDetails nbpCurrencyExternalDetails);

    @Mapping(target = "currencyCode", source = "currencyCode")
    @Mapping(target = "bid", source = "bid")
    @Mapping(target = "ask", source = "ask")
    CurrencyDetails toCurrencyDetails(Currency currency);
}
