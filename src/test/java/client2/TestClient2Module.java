package client2;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import service.Service;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

public class TestClient2Module {
    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();

    private Client2Module sut;

    @Before
    public void setUp() {
        sut = new Client2Module();
    }

    @Test
    public void testConfigure() {
        sut.configure();
    }

    @Test
    public void testProvideService() {
        final Service mockService = context.mock(Service.class);

        context.checking(new Expectations() {{
            oneOf (mockService).setupClient2();
        }});

        Service actualService = sut.provideService(mockService);
        assertThat(actualService, is(sameInstance(mockService)));
    }
}
