package diantee.amortization.input;

public class Loan{
    protected double initialPrincipal;
    protected int yrs;
    protected double irate;
    protected double prepay;
    protected double currentPrincipal;
    protected int currentYr = 1;
    protected double totalPmt;

    public Loan(double principal, int yrs, double irate, double prepay) {
        this.initialPrincipal = principal;
        this.yrs = yrs;
        this.irate = irate;
        this.prepay = prepay;
        currentPrincipal = initialPrincipal;
        totalPmt = currentPrincipal * ((irate * Math.pow((1 + irate),yrs) /(Math.pow((1 + irate),yrs)-1)));

    }



    public void Amortization() {
        if(prepay > 0) {
            System.out.println("============ Year " + currentYr + " ================");
            System.out.printf("Beginning Balance: $%.2f\n", currentPrincipal);
            double iratePmt = currentPrincipal * irate;
            double principalPmt = totalPmt - iratePmt;
            System.out.printf("Total Payment: $%.2f\n", totalPmt);
            System.out.printf("Interest rate payment: %.2f\n", iratePmt);
            System.out.printf("Principal payment: $%.2f\n", principalPmt);
            currentPrincipal -= principalPmt;
            System.out.printf("Balance Before Prepayment: $%.2f\n", currentPrincipal);
            double prepayAmt = (prepay*initialPrincipal);
            System.out.printf("Subtracting Prepayment: $%.2f\n\n", prepayAmt);
            currentPrincipal -= prepayAmt;
            System.out.printf("Ending Balance: $%.2f\n\n", currentPrincipal);
            totalPmt = currentPrincipal * ((irate * Math.pow((1 + irate),yrs-1) /(Math.pow((1 + irate),yrs-1)-1)));
            currentYr++;
        }
        for(int i = currentYr; i <= yrs; i++) {
            System.out.println("============ Year " + currentYr + " ================");
            System.out.printf("Beginning Balance: $%.2f\n", currentPrincipal);
            double iratePmt = currentPrincipal * irate;
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