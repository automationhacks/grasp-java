package advanced.dependencyInjection._05_interface;

import com.google.inject.*;
import com.google.inject.Module;

public class MyApplication {
    public static void main(String[] args) {
        // 3. Register the Display module with the Guice.createInjector method
        Injector injector = Guice.createInjector(new DisplayModule());
        Greeter greeter = injector.getInstance(Greeter.class);
        greeter.sayHello();
    }
}

// 1. This line would throw below error without being bound
// No implementation for advanced.dependencyInjection._05_interface.Displayer was bound.
class Greeter {

    @Inject
    Displayer displayer;

    void sayHello() {
        displayer.display("Hello, world! ");
    }
}

interface Displayer {
    void display(String s);
}

class StdOutDisplayer implements Displayer {
    public void display(String s) {
        System.out.println(s);
    }
}

// 2. Add an implementation of Module interface and bind
class DisplayModule implements Module {
    public void configure(Binder binder) {
        // Takes a java concrete type (class, enum, abstract type) and binds it to
        // to an interface
        binder.bind(Displayer.class).to(StdOutDisplayer.class);
    }
}