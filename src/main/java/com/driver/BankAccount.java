package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        try{
            long start = (long) Math.pow(10, digits-1);
            long end = (long) Math.pow(10, digits)-1;
            String ans = null;

            while(start <= end) {
                int currentSum = 0;
                long temp = start;
                while (temp != 0) {
                    currentSum += temp % 10;
                    temp /= 10;
                }

                if (currentSum == sum){
                    ans = String.valueOf(start);
                    break;
                }
                start++;
            }
            if(ans.equals(sum)){
                return ans;
            }
            else{
                throw new Exception("Account Number can not be generated");
            }
        }

        catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        try{
            if((balance-amount) >= minBalance){
                balance -= amount;
            }
            else{
                throw new Exception("Insufficient Balance");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}