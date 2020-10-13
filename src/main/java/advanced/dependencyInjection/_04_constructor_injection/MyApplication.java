package advanced.dependencyInjection._04_constructor_injection;

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
    final Displayer displayer;
    final Person person;

    @Inject
    Greeter(Displayer displayer, Person person) {
        this.displayer = displayer;
        this.person = person;
    }

    void sayHello() {
        displayer.display("Hello, world! " + person.name);
    }
}

class Displayer {
    void display(String s) {
        System.out.println(s);
    }
}


class Person {
    String name;

    @Inject
    public Person(String name) {
        this.name = name;
    }
}

