package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    int withdrawlTime;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
        withdrawlTime = 0;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        try{
            if(withdrawlTime > getMaxWithdrawalLimit()){
                throw new Exception("Maximum Withdraw Limit Exceed");
            }
            else{
                if(getBalance()-amount < 0){
                    throw new Exception("Insufficient Balance");
                }
                else{
                    setBalance(getBalance()-amount);
                    withdrawlTime++;
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double simpleInterest = getBalance()+ (getBalance() * getRate() * years)/100;
        return simpleInterest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundInterest = getBalance() * (Math.pow((1+getRate()/100),years));
        return compoundInterest;
    }

}
