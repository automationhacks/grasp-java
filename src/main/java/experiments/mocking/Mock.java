package experiments.mocking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.Parameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class Mock {

    private ClientAndProxy proxy;
    private ClientAndServer mockServer;

    @Before
    public void setup() {
        mockServer = ClientAndServer.startClientAndServer(1080);
        proxy = ClientAndProxy.startClientAndProxy(1090);
    }

    @After
    public void teardown() {
        proxy.stop();
        mockServer.stop();
    }

    @Test
    public void theTest() throws IOException {
        mockServer
                .when(
                        HttpRequest.request()
                                .withMethod("GET")
                                .withPath("/view/cart")
                                .withQueryStringParameters(
                                        Parameter.param("cartId", "abcd")
                                )
                )
                .respond(
                        HttpResponse.response()
                                .withBody("{\n" +
                                        "  \"Success\": true\n" +
                                        "}"));

        // Make http request
        URL url = new URL("http://localhost:1080/view/cart?cartId=abcd");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        System.out.println(con.getResponseCode());
        System.out.println(con.getResponseMessage());

        // Writing response
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("=== Response from mock server ===");
        System.out.println(response.toString());
    }

    @Test
    public void liveNetworkCallsTest() throws InterruptedException, IOException {
        Proxy testProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort"))));
        URL url = new URL("http://localhost:1080/view/cart?cartId=abcd");
        url.openConnection(testProxy);

        System.out.println("Starting sleep time");
        Thread.sleep(10000);
        System.out.println("Slept");
        HttpRequest[] recordedRequests = proxy.retrieveRecordedRequests(HttpRequest.request());
        System.out.println(recordedRequests.length);
        Thread.sleep(5000);
    }
}


