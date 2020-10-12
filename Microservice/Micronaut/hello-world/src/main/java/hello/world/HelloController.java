package hello.world;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import javax.inject.Inject;

@Controller("/hello")
public class HelloController {
    @Inject
    HelloService helloService;

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return helloService.hello() ; // <4>
    }
}
