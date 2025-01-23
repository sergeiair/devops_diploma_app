import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.Instant;

public class HelloWorldServer {

    private final static String buildMade = getDateTimeString();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new HelloHandler());
        server.setExecutor(null);
        server.start();
    }

    static class HelloHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            OutputStream os = exchange.getResponseBody();
            String response = "Hey from Java App at " + getDateTimeString() + "! \r\n \r\n App started at " + buildMade;

            exchange.sendResponseHeaders(200, response.length());

            os.write(response.getBytes());
            os.close();
        }
    }

    public static String getDateTimeString() {
        return Instant.now().toString().split("\\.")[0];
    }
}

