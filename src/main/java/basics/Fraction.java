package basics;

public class Fraction extends Number implements Comparable<Fraction> {
    private Integer numerator;
    private Integer denominator;

    public Fraction(Integer top, Integer bottom) {
        this.numerator = top;
        this.denominator = bottom;
    }

    public Fraction(Integer top) {
        /** Overloading constructor
         * Adds a denominator value of 1
         */
        this.numerator = top;
        this.denominator = 1;
    }

    // Below methods are implementation of abstract class
    // Number's abstract methods.
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    public int intValue() {
        return numerator.intValue() / denominator.intValue();
    }

    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }

    public long longValue() {
        return numerator.longValue() / denominator.longValue();
    }

    public Fraction add(Fraction otherFraction) {
        Integer newNum, newDen, common;

        // Read https://www.mathsisfun.com/fractions_addition.html 
        newNum = this.numerator * otherFraction.denominator + 
        otherFraction.numerator * this.denominator;
        newDen = this.denominator * otherFraction.denominator;
        
        // GCD (Greatest common divisor) is used to simplify the fraction
        common = gcd(newNum, newDen);

        return new Fraction(newNum/common, newDen/common);
    }

    public Fraction add(Integer other) {
        // overloading add to accept an integer
        // convert as a new fraction and call normal "Fraction add" func.
        Fraction otherFraction = new Fraction(other);
        return add(otherFraction);
    }

    private static Integer gcd(Integer m, Integer n) {
        // NTS: find out and explain the logic for below.
        while (m % n !=0) {
            Integer oldm = m;
            Integer oldn = n;
            m = oldn;
            n = oldm % oldn;
        }
        return n;
    }

    public String toString() {
        // Overriding default toString implementation
        // to print out a fraction.
        return numerator.toString() + " / " + denominator.toString();
    }

    public boolean equals(Fraction other) {
        /**
         * Overriden default Object classes equals method
         * to work for fractions.
         */
        Integer num1 = this.numerator * other.denominator;
        Integer num2 = this.denominator * other.numerator;
        if (num1 == num2) {
            return true;
        }
        else {
            return false;
        }
    }

    public int compareTo(Fraction other) {
//        /**
//         * Impl for Comparable interface's method.
//         * This is pre-requisite to implement sorting of fractions.
//         */
//        this.num1 = numerator * other.denominator;
//        this.num2 = denominator * other.denominator;
//        return num1 - num2;
        return 1;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 4);
        Fraction f2 = new Fraction(1, 3);

        System.out.println(f1.add(f2));
    }
}