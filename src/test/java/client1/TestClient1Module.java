package client1;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import service.Service;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

@RunWith(JMock.class)
public class TestClient1Module {
    private Mockery context = new Mockery();

    private Client1Module sut;

    @Before
    public void setUp() {
        sut = new Client1Module();
    }

    @Test
    public void testConfigure() {
        sut.configure();
    }

    @Test
    public void testProvideService() {
        final Service mockService = context.mock(Service.class);

        context.checking(new Expectations() {{
            one (mockService).setupClient1();
        }});

        Service actualService = sut.provideService(mockService);
        assertThat(actualService, is(sameInstance(mockService)));
    }
}
