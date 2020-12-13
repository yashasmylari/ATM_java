import java.text.DecimalFormat;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    // Validate Login information customer number and pin number

    public void getLogin() throws IOException {
        int x = 1;
        do{
            try{

                data.put(1234567, 9396);
                data.put(123567, 9996);
                data.put(1236767, 9196);
                data.put(34234567, 9496);
                data.put(123224567, 9896);
                data.put(1265634567, 9392);
                data.put(234534567, 9393);

                System.out.println("Welcome to the ATM project");

                System.out.println("Enter Your Account number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter Your Pin number");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()){
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong customer Number or Pin Number" + "\n");
        } while (x == 1);
    }

    // Display Account type Menu with selection

    public void getAccountType() {
        System.out.println("select the Account you want to access:");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using this ATM, please visit next time , until then bye");
                break;

            case 4:
                System.out.println("\n" + "Invalid choice" + "\n");
                getAccountType();
                break;
        }
    }

    // Display checking Account Menu with selections

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance ");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice :  ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM. We are always like to serve you");
                break;

            default:
                System.out.println("\n" + "Input choice." + "\n");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " +  moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("\n" + "Invalid choice" + "\n");
                getSaving();
        }
    }

    int selection;
}
