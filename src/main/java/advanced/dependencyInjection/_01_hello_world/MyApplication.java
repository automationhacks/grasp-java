package advanced.dependencyInjection._01_hello_world;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MyApplication {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Greeter greeter = injector.getInstance(Greeter.class);
        greeter.sayHello();
    }

}

class Greeter {
    void sayHello() {
        System.out.println("Hello, world!");
    }
}
