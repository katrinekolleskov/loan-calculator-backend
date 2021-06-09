# Loan-calculator-backend

This is a very simple set-up for an end-point for a user that wishes to apply for a house loan.

# General thoughts

I have not put much effort into making this scaleable. In order for other housing loans to be covered,
I would make the service layer handle different type of loan classes (ex. HouseLoan, CarLoan etc.) and
make a database that had a column loanType with variables that differ based on interest (since different loans
have different interests).

One important thing that is lacking in this program is user input hygiene. I do not check any user input. If I 
was to work on this program further, I would make more checks in POST, PUT and DELETE. I do not check for negative
values or zeros, for example. 
