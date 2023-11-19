import java.util.*;
public class PolynomialEvaluation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polynomial poly = new Polynomial();
        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();
        for (int i = 0; i < terms; i++) {
            System.out.print("Enter coeff for term " + (i + 1) + ": ");
            double coeff = scanner.nextDouble();
            System.out.print("Enter power for term " + (i + 1) + ": ");
            int power = scanner.nextInt();
            poly.addTerm(coeff, power);
        }
        System.out.print("Enter the value of x: ");
        double x = scanner.nextDouble();
        scanner.close();
        System.out.println("Polynomial Degree: " + poly.Degree());
        System.out.println("Number of Terms: " + poly.totalterms());
        if(poly.totalterms()==1)
        {
            System.out.println("**ITS A MONOMIAL**");
        } else if (poly.totalterms()==2) {
            System.out.println("**ITS A BINOMIAL**");
        }
        else if (poly.totalterms() ==3) {
            System.out.println("**ITS A TRINOMIAL**");
        }
        else
            System.out.println("**ITS A POLYNOMIAL**");
        poly.printPolynomial();
        double res = poly.evaluate(x);
        System.out.println("res for x = " + x + " is: " + res);
    }
}
