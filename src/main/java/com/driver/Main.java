package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        CurrentAccount account1 = new CurrentAccount("Ram",10000.00,"ABCD");
        account1.validateLicenseId();

        SavingsAccount account2 = new SavingsAccount("Sohan",5000.00,2000,15.6);
        account2.withdraw(3000);
        account2.withdraw(6000);
        account2.withdraw(1000);
        account2.getSimpleInterest(2);
        account2.getCompoundInterest(3,1);

        StudentAccount account3 = new StudentAccount("Raj Kumar",1000,"AccioJob");
    }
}