package caveofprogramming._44_enum;

import com.google.common.base.Enums;
import com.google.common.base.Optional;

public class App {

    private static String CONSUMER = "cons";
    private static String ECOMMERCE = "ecom";
    private static String WEBHOOKS = "webhooks";

    private static void beforeEnum(String type) {
        switch (type) {
            case "cons":
                System.out.println("CONSUMER");
                break;
            case "ecom":
                System.out.println("ECOMMERCE");
                break;
            default:
                System.out.println("When nothing works");
        }

    }

    private static void afterEnum() {
        BookingTypes bType = BookingTypes.CONSUMER;

        switch (bType) {
            case CONSUMER:
                System.out.println("Consumer");
                break;
            case WEBHOOKS:
                System.out.println("Webhooks");
                break;
            default:
                System.out.println("Non Consumer or Webhooks case");
        }

        System.out.println(BookingTypes.CONSUMER);
        // Enum values are kinda like objects of the Enum Type
        System.out.println(BookingTypes.CONSUMER.getClass());
        // Enum Types are childs of Enum class instead of Objects.
        System.out.println(BookingTypes.CONSUMER instanceof BookingTypes);
        System.out.println(BookingTypes.CONSUMER instanceof Enum);

    }



    public static void main(String[] args) {
//        beforeEnum(CONSUMER);
//        beforeEnum(ECOMMERCE);

//        afterEnum();
//
//        Animals animal = Animals.DOG;
//
//        System.out.println("Enum constant as string is " + animal.name());
//        System.out.println("Name of animal is " + animal.getAnimalName());
//
//        // Another way of accessing enum constants value is:
//        Animals animal2 = Animals.valueOf("CAT");
//        System.out.println(animal2); // does NOT WORK in java8. Need to check why?
//        System.out.println(animal2.getAnimalName());

//        Animals animal3 = Animals.valueOf("XYZ");
//        System.out.println(animal3); // does NOT WORK in java8. Need to check why?
//        System.out.println(animal3.getAnimalName());

//        System.out.println(Enums.getIfPresent(Animals.class, "DOG").orNull().getClass());
//        System.out.println(Enums.getIfPresent(Animals.class, "xyz").orNull().getClass().getName());

        Optional<Animals> animals = Enums.getIfPresent(Animals.class, "DOG");
        if (animals.isPresent()) {
            System.out.println(animals.get().getAnimalName());
        }
        else {
            System.out.println("Failed");
        }

//        try {
//            System.out.println(animals.getAnimalName());
//        }
//        catch (NullPointerException e) {
//            System.out.println("Boo yah!");
//        }

    }
}
