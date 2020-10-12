import io.helidon.config.Config;
import io.helidon.config.ConfigSources;
import io.helidon.config.spi.ConfigSource;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

public class Main {
    public static void main(String[] args) throws Exception{
//        ServerConfiguration serverConfig = ServerConfiguration.builder()
//                .port(8080).build();
        ConfigSource configSource = ConfigSources.classpath("application.yaml").build();
        Config serverConfig = Config.builder().sources(configSource).build();

        Routing routing = Routing.builder()
                .get("/greet", (request, response) -> response.send("Hello World!")).build();

        WebServer.create(serverConfig, routing)
                .start()
                .thenAccept(ws -> System.out.println("Server started"));
    }
//    public static void main(String[] args) throws Exception{
//        ConfigSource configSource = ConfigSources.classpath("application.yaml").build();
//        Config config = Config.builder().sources(configSource).build();
//
//    }
}
