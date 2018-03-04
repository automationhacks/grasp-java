// Package allows to organize files and allows duplicate file names in their own context
// Packages can be imported into others
// They should usually be the first statement in a class file.
// Packages are hierarchical, and we can have package under an packaged (called sub package)

// Conventions:
// should be lower case
// com.example is basically a convention to ensure if we distribute code as a jar file then it is unique


package caveofprogramming._24_packages.Main;

import caveofprogramming._24_packages.ocean.Fish;
import caveofprogramming._24_packages.ocean.plants.Seaweed;

public class App {

    public static void main(String[] args) {
        Fish goldFish = new Fish();
        Seaweed weed = new Seaweed();
    }
}
