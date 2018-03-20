package caveofprogramming._44_enum;

public enum BookingTypes {
    CONSUMER, ECOMMERCE, WEBHOOKS
}

enum Animals {
    // You can instantiate these enum constants if you have
    // created a constructor as below
    DOG("Bozo"), CAT("Billu"), MOUSE("Jerry");

    private String animalName;

    // Constructor
    Animals(String animalName) {
        this.animalName = animalName;
    }

    // We can also create getters here.
    public String getAnimalName() {
        return animalName;
    }
}