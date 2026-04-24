public class Program {

    // Inner immutable class
    public static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Getter (optional)
        public double getValue() {
            return value;
        }

        // Override equals method
        @Override
        public boolean equals(Object obj) {
            // Step 1: Same reference check (reflexive)
            if (this == obj) {
                return true;
            }

            // Step 2: Null and type check
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Step 3: Safe casting
            Feet other = (Feet) obj;

            // Step 4: Compare using Double.compare
            return Double.compare(this.value, other.value) == 0;
        }

        // Recommended: override hashCode when equals is overridden
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        Feet f3 = new Feet(2.0);

        System.out.println("1.0 ft vs 1.0 ft: " + f1.equals(f2)); // true
        System.out.println("1.0 ft vs 2.0 ft: " + f1.equals(f3)); // false
        System.out.println("1.0 ft vs null: " + f1.equals(null)); // false
        System.out.println("Same reference: " + f1.equals(f1));   // true
    }
}