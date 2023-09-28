package advanced.dependencyInjection._06_using_annotations;

import com.google.inject.*;
import com.google.inject.Module;

public class MyApp {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DisplayModule());
        NewGreeter greeter = injector.getInstance(NewGreeter.class);
        greeter.sayHello();
    }
}

class DisplayModule implements Module {
    public void configure(Binder binder) {
        // We can create annotations for these and essentially specify which type it
        // should pick up
        binder.bind(Displayer.class).annotatedWith(ForStdout.class).to(StdOutDisplayer.class);
        binder.bind(Displayer.class).annotatedWith(ForTimesSquare.class).to(TimesSquareDisplayer.class);
    }
}

class NewGreeter {
    // At runtime the implementation chooses
    @Inject
    @ForTimesSquare
    Displayer displayer;

    @Inject
    @ForStdout
    Displayer anotherDisplayer;

    void sayHello() {
        displayer.display("Hello, world");
        anotherDisplayer.display("Via Stdout");
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



