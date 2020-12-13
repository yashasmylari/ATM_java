import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    // set the customer number

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    //Get the Customer number

    public int getCustomerNumber(){
        return customerNumber;
    }

    // set the pin number

    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    //get the pin number

    public int getPinNumber() {
        return pinNumber;
    }

    // get checking Account balance

    public double getCheckingBalance() {
        return checkingBalance;
    }

    // Get saving Account balance

    public double getSavingBalance() {
        return savingBalance;
    }

    // Calculate checking Account withdrawal

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    // Calculate Saving Account withdrawal

    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    // Calculate Checking Account Deposit
     public double calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
     }

     // Calculate saving Account Deposit

    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    //Customer checking Account withdraw input

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account balance:" + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative " + "\n");
        }
    }

    // Calculate saving Account withdraw input

    public void getSavingWithdrawInput(){
        System.out.println("Saving Account balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from saving Account :");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account balance: " + savingBalance + "\n");
        } else {
            System.out.println("balance cannot be negative " + "\n");
        }
    }

    // calculate Deposit Amount

    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance :" + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to Deposit from Checking Account:");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0){
            calcCheckingDeposit(amount);
            System.out.println("New checking Account balance :" + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative" + "\n");
        }
    }

    // Customer Saving Account Deposit input

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit from saving Account:");
        double amount = input.nextDouble();

        if((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }


    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
}
