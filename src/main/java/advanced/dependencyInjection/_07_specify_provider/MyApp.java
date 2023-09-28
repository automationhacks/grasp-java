package advanced.dependencyInjection._07_specify_provider;

import com.google.inject.*;
import com.google.inject.Module;

import java.util.Random;

public class MyApp {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DisplayModule());
        NewGreeter greeter = injector.getInstance(NewGreeter.class);
        greeter.sayHello();
    }
}

class DisplayModule implements Module {
    public void configure(Binder binder) {
        // use toProvider() to specify the class that can make the decision
        binder.bind(Displayer.class).toProvider(DisplayerPicker.class);
    }
}

class NewGreeter {
    @Inject
    Displayer displayer;

    void sayHello() {
        displayer.display("Hello, world");
    }
}

// If your app does not know which flavor to get then this
// could be delegated to a class that implements Provider interface
// and can provide the desired dependency
class DisplayerPicker implements Provider<Displayer> {
    public Displayer get() {
        int random = new Random().ints(0, 5).findFirst().getAsInt();
        if (random < 2) {
            return new TimesSquareDisplayer();
        } else {
            return new StdOutDisplayer();
        }
    }
}

// Interface (ADT) specifying what behaviors it can have
interface Displayer {
    void display(String s);
}

// One flavor is the StdOutDisplayer
class StdOutDisplayer implements Displayer {
    public void display(String s) {
        System.out.println(s);
    }
}

// Another flavour is the TimesSquareDisplayer
class TimesSquareDisplayer implements Displayer {
    public void display(String s) {
        System.out.println("SQUARED " + s);
    }
}



