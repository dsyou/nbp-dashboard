package pl.dashboard.nbp.features.dataprovider.mapper;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author Dawid Janik
 * @since 06.10.2018
 */
public class NbpCurrencyExternalMapperTest {

    NbpCurrencyExternalMapper nbpCurrencyExternalMapper = NbpCurrencyExternalMapper.INSTANCE;

    @Test
    public void toNbpCurrencyExternalDetails() {
        Assert.notNull(nbpCurrencyExternalMapper, "Mapper not generated");
    }
}