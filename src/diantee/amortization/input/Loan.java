package diantee.amortization.input;

public class Loan{
    private double initialPrincipal;
    private int yrs;
    private double iRate;
    private double prePaymentRate;
    private double currentPrincipal;
    private int currentYr = 1;
    private double totalPmt;

    public Loan(double principal, int yrs, double irate, double prePaymentRate) {
        this.initialPrincipal = principal;
        this.yrs = yrs;
        this.iRate = irate;
        this.prePaymentRate = prePaymentRate;
        currentPrincipal = initialPrincipal;
        totalPmt = currentPrincipal * ((irate * Math.pow((1 + irate),yrs) /(Math.pow((1 + irate),yrs)-1)));

    }



    public void Amortization() {
        if(prePaymentRate > 0) {
            System.out.println("============ Year " + currentYr + " ================");
            System.out.printf("Beginning Balance: $%.2f\n", currentPrincipal);
            double iratePmt = currentPrincipal * iRate;
            double principalPmt = totalPmt - iratePmt;
            System.out.printf("Total Payment: $%.2f\n", totalPmt);
            System.out.printf("Interest rate payment: %.2f\n", iratePmt);
            System.out.printf("Principal payment: $%.2f\n", principalPmt);
            currentPrincipal -= principalPmt;
            System.out.printf("Balance Before Prepayment: $%.2f\n", currentPrincipal);
            double prepayAmt = (prePaymentRate*initialPrincipal);
            System.out.printf("Subtracting Prepayment: $%.2f\n\n", prepayAmt);
            currentPrincipal -= prepayAmt;
            System.out.printf("Ending Balance: $%.2f\n\n", currentPrincipal);
            totalPmt = currentPrincipal * ((iRate * Math.pow((1 + iRate),yrs-1) /(Math.pow((1 + iRate),yrs-1)-1)));
            currentYr++;
        }
        for(int i = currentYr; i <= yrs; i++) {
            System.out.println("============ Year " + currentYr + " ================");
            System.out.printf("Beginning Balance: $%.2f\n", currentPrincipal);
            double iratePmt = currentPrincipal * iRate;
            double principalPmt = totalPmt - iratePmt;
            System.out.printf("Total Payment: $%.2f\n", totalPmt);
            System.out.printf("Interest rate payment: $%.2f\n", iratePmt);
            System.out.printf("Principal payment: $%.2f\n", principalPmt);
            currentPrincipal -= principalPmt;
            System.out.printf("Ending Balance: $%.2f\n\n", currentPrincipal);
            currentYr++;
        }
    }

}