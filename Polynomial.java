import java.util.LinkedList;
class Polynomial {
    LinkedList<Term> coeffs;
    public Polynomial() {
        coeffs = new LinkedList<>();
    }
    // Add a term to the polynomial
    public void addTerm(double coeff, int power) {
        if (coeff != 0) {
            Term nextterm = new Term(coeff, power);
            if (coeffs.isEmpty() || power >= coeffs.getFirst().power) {
                coeffs.addFirst(nextterm);
            } else if (power <= coeffs.getLast().power) {
                coeffs.addLast(nextterm);
            } else {
                for (int i = 0; i < coeffs.size(); i++) {
                    if (power <= coeffs.get(i).power) {
                        coeffs.add(i, nextterm);
                        break;
                    }
                }
            }
        }
    }
    // Evaluate the polynomial for a given value of x
    public double evaluate(double xValue) {
        double res = 0.0;
        for (Term term : coeffs) {
            res += term.coeff * Math.pow(xValue, term.power);
        }
        return res;
    }
    // Get the degree of the polynomial
    public int Degree() {
        int degree = 0;
        for (Term term : coeffs) {
            if (term.power > degree) {
                degree = term.power;
            }
        }
        return degree;
    }
    // Get the number of non-zero terms
    public int totalterms() {
        return coeffs.size();
    }
    // Print the polynomial
    public void printPolynomial() {
        StringBuilder polynomialString = new StringBuilder();
        for (Term term : coeffs) {
            if (term.coeff > 0) {
                polynomialString.append(" + ");
            } else {
                polynomialString.append(" - ");
            }
            polynomialString.append(Math.abs(term.coeff));
            polynomialString.append("x^");
            polynomialString.append(term.power);
        }
        if (polynomialString.length() > 0) {
            System.out.println("Polynomial: " + polynomialString.substring(3));
        } else {
            System.out.println("Polynomial: 0");
        }
    }
}