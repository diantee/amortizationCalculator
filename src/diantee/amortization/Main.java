package diantee.amortization;

import diantee.amortization.input.Loan;

public class Main {

    public static void main(String[] args) {

        Loan loan1 = new Loan(500000, 25, .07, .10);
        loan1.Amortization();

    }
}
