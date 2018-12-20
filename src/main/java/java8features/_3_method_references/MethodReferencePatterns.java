package java8features._3_method_references;

import java.util.ArrayList;
import java.util.List;

/**
 * The logic in the methods are dummy.
 * Used just to illustrate some selection
 */
class Person {
    static boolean isRealPerson(String name) {
        return !name.equalsIgnoreCase("");
    }

    boolean isLegalName(String name) {
        return name.length() > 4;
    }
}

public class MethodReferencePatterns {
    /**
     * Usage pattern 1:
     * Lambda expressions which call an existing method can be called using ClassName::MethodName
     * format
     */
    private void referenceToStaticMethod(List<String> people) {
        // Below we call the isRealPerson() using a lambda
        boolean isReal = people.stream()
                .anyMatch(person -> Person.isRealPerson(person));
        System.out.println(isReal);

        // The above can be refactored to directly call the static method using method reference
        boolean isRealWithMethRef = people.stream().anyMatch(Person::isRealPerson);
        System.out.println(isRealWithMethRef);
    }

    /**
     * Usage pattern 2:
     * Reference to instance method can be done by following pattern containingInstance::MethodName
     * In below ex: We create an instance of person class and use that to call the instance method
     * in side the filter() clause of stream api
     */
    private void referenceToInstanceMethod(List<String> people) {
        Person person = new Person();
        boolean isLegalName = people.stream().anyMatch(person::isLegalName);
        System.out.println(isLegalName);
    }

    /**
     * Usage pattern 3:
     * We can refer to the instance method of an object of a particular type using syntax: ContainingType::methodName
     * Here: isEmpty is a method in String type, we can apply it to this list of Strings
     */
    private void referenceToInstanceMethodOfAType(List<String> people) {
        long personNames = people.stream().filter(String::isEmpty).count();
        System.out.println(personNames);
    }


    public static void main(String[] args) {
        List<String> people = new ArrayList<>();
        people.add("Gaurav");
        people.add("");
        people.add("Smith");
        people.add("");

        MethodReferencePatterns patterns = new MethodReferencePatterns();
        patterns.referenceToStaticMethod(people);

        System.out.println(">>> referenceToInstanceMethod");
        patterns.referenceToInstanceMethod(people);

        System.out.println(">>> referenceToInstanceMethodOfAType");
        patterns.referenceToInstanceMethodOfAType(people);
    }
}
