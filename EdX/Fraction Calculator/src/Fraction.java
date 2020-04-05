public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must be greater than 0");
        }

        if (denominator < 0) {
            this.numerator = -1 * numerator;
            this.denominator = -1 * denominator;
        }
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public Fraction add(Fraction other) {
        if (this.denominator == other.denominator) {
            return new Fraction((this.numerator + other.numerator), this.denominator);
        } else {

            this.numerator = this.numerator * (mcm(this.denominator, other.denominator) / this.denominator);
            other.numerator = other.numerator * (mcm(this.denominator, other.denominator) / other.denominator);
            return new Fraction(this.numerator + other.numerator, (mcm(this.denominator, other.denominator)));
        }

    }

    public Fraction subtract(Fraction other) {
        if (this.denominator == other.denominator) {
            return new Fraction((this.numerator - other.numerator), this.denominator);
        } else {

            this.numerator = this.numerator * (mcm(this.denominator, other.denominator) / this.denominator);
            other.numerator = other.numerator * (mcm(this.denominator, other.denominator) / other.denominator);
            return new Fraction(this.numerator - other.numerator, (mcm(this.denominator, other.denominator)));
        }

    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            Fraction otherfrac = (Fraction) other;
            return this.numerator == otherfrac.numerator && this.denominator == ((Fraction) other).denominator;
        } else {
            return false;
        }
    }

    public void toLowestTerms() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    public static int mcm(int den1, int den2) {
        return (den1 * den2) / gcd(den1, den2);
    }

    public static int gcd(int den1, int den2) {

        if (den1 <= den2) {
            int t = den1;
            den1 = den2;
            den2 = t;
        }

        while (den2 != 0) {
            int t = den2;
            den2 = den1 % den2;
            den1 = t;
        }

        return den1;
    }

}
