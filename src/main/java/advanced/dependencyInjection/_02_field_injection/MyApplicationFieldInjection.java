package advanced.dependencyInjection._02_field_injection;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class MyApplicationFieldInjection {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Greeter greeter = injector.getInstance(Greeter.class);
        greeter.sayHello();
    }

}

class Greeter {
    @Inject
    Displayer displayer;

    void sayHello() {
        displayer.display("Hello, world! via field injection");
    }
}

class Displayer {
    void display(String s) {
        System.out.println(s);
    }
}
