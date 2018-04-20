# Amortization Schedule Calculator

An application that calculates a loan's amortization schedule for payments made on an annual basis.

## Anatomy of a Loan object:
- *Principal* - Total principal balance of the loan.
- *yrs* - Term length of the loan.
- *irate* The annual interest rate paid on the loan. Will be passed in as a decimal value .05 for 5% for example.
- *prePaymentRate* - The rate at which the loan is paid down. Passed in as a decimal. The rate represents a percentage of the total principal balance that is paid early due to the borrower refinancing to take advantage of lower interest payments.
