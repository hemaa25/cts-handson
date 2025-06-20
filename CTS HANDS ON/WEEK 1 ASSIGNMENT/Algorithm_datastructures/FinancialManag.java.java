import java.util.Scanner;

public class FinancialManag{

    public static double forecastRecursive(double value, double rate, int years) {
        if (years == 0) return value;
        return forecastRecursive(value * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial value: ");
        double initial = sc.nextDouble();
        System.out.print("Enter annual growth rate (as decimal, e.g., 0.05 for 5%): ");
        double rate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureValue = forecastRecursive(initial, rate, years);
        System.out.printf("Future value after %d years: ₹%.2f%n", years, futureValue);
    }
}
