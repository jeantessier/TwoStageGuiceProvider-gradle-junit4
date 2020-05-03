package generic;

import org.junit.Test;
import service.Service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TestGenericModule {
    private GenericModule sut = new GenericModule();

    @Test
    public void testProvideService() {
        Service actualService = sut.provideService();
        assertThat(actualService, is(notNullValue()));
        assertThat(actualService.getState(), is(equalTo("generic")));
    }
}
