import java.util.Date;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    // Default constructor
    public Loan() {
        this(2.5, 1, 1000);
    }

    // Constructor with specified values
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date(); // current date
    }

    public double getAnnualInterestRate() { return annualInterestRate; }
    public int getNumberOfYears() { return numberOfYears; }
    public double getLoanAmount() { return loanAmount; }
    public Date getLoanDate() { return loanDate; }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        double r = annualInterestRate / 1200;      // monthly interest rate
        int n = numberOfYears * 12;                // total number of payments
        if (r == 0) return loanAmount / n;         // avoid division by zero
        return (loanAmount * r) / (1 - Math.pow(1 + r, -n));
    }

    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    public static void main(String[] args) {
        Loan loan = new Loan(2.5, 1, 1000);
        System.out.printf("Monthly: %.2f%n", loan.getMonthlyPayment());
        System.out.printf("Total:   %.2f%n", loan.getTotalPayment());
        System.out.println("Date:    " + loan.getLoanDate());
    }
}
