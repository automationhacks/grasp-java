package advanced.dependencyInjection._03_method_injection;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class MyApplication {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Greeter greeter = injector.getInstance(Greeter.class);
        greeter.sayHello();
    }

}

class Greeter {
    Displayer displayer;

    @Inject void setDisplayer(Displayer displayer) {
        this.displayer = displayer;
    }

    void sayHello() {
        displayer.display("Hello, world! via method injection");
    }
}

class Displayer {
    void display(String s) {
        System.out.println(s);
    }
}

