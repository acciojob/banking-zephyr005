package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            CurrentAccount account1 = new CurrentAccount("Ram",10000,"ABCDDFF");
            System.out.println(account1.getTradeLicenseId());
            account1.withdraw(500);
            account1.deposit(20000);
            account1.validateLicenseId();
            System.out.println(account1.getBalance());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            SavingsAccount account2 = new SavingsAccount("Sohan",5000.00,2000,15.6);
            account2.withdraw(1000);
            System.out.println(account2.getSimpleInterest(2));
            System.out.println(account2.getCompoundInterest(3,1));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            BankAccount account4 = new BankAccount("Kyle",1000,500);
            System.out.println(account4.generateAccountNumber(6,16));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        StudentAccount account3 = new StudentAccount("Raj Kumar",1000,"AccioJob");
    }
}