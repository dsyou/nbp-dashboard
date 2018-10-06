package pl.dashboard.nbp.features.dataprovider.mapper;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author Dawid Janik
 * @since 06.10.2018
 */
public class NbpCurrencyMapperTest {

    NbpCurrencyMapper nbpCurrencyMapper = NbpCurrencyMapper.INSTANCE;

    @Test
    public void nbpCurrencyMapper() {
        Assert.notNull(nbpCurrencyMapper, "Mapper not generated");
    }
}
