package caveofprogramming._25_accessmodifiers.base;

public class Oak extends Plant {

    public Oak() {
        // allowed, height is protected.
        this.height = "Large";
        this.width = 100;
    }
}
