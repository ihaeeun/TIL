package hello.world;

import javax.inject.Singleton;

// bean으로 만드는 annotation
@Singleton
class HelloService {
    public String hello(){
        return "Hellow World";
    }
}