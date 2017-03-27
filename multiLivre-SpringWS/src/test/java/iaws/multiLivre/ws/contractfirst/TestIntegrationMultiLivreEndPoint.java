package iaws.multiLivre.ws.contractfirst;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;


import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.springframework.ws.test.server.ResponseMatchers.*;


import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import static org.springframework.ws.test.server.RequestCreators.withPayload;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/application-context.xml")
public class TestIntegrationMultiLivreEndPoint {

    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockClient;

    @Before
    public void createClient() {
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Test
    public void multiLivreEndpoint() throws Exception {
        Source requestPayload = new StreamSource(new ClassPathResource("RequestType.xml").getInputStream() );
        Source responsePayload = new StreamSource(new ClassPathResource("ResponseType.xml").getInputStream());
        
        System.out.println(requestPayload);

        mockClient.sendRequest(withPayload(requestPayload)).
                andExpect(payload(responsePayload));
    }
}
