import java.util.*;

public class ATMinter {

    static boolean process = true;

    // Withdraw Method --------------->
    public int ToWithdraw(int amount, int Balance) {
        if (amount > Balance) {
            System.out.println("Insufficient Balance....");
            return Balance;
        } else {
            Balance = Balance - amount;
            System.out.println("Withdraw Successful....");
            return Balance;
        }
    }

    // Deposit Method ----------------->
    public int ToDeposit(int amount, int Balance) {
        Balance = amount + Balance;
        System.out.println("Deposit successful....");
        return Balance;
    }

    public static void main(String[] args) {

        // User Interface------------>
        User_Bank_Account user_pin = new User_Bank_Account();
        Scanner obj = new Scanner(System.in);

        while (process) {

            System.out.println("                 WELCOME TO ATM SERVICE !!");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println();
            System.out.println("Withdraw ------ Press ----- 1");
            System.out.println("Deposit ------- Press ----- 2");
            System.out.println("Check Balance - Press ----- 3");
            System.out.println("To Exit ------- Press ----- 0");
            System.out.println();
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
           
            System.out.print("Enter Your Choice : ");
            int choice = obj.nextInt();

            if (choice == 0) {
                break;
            }
            if(choice==1||choice==2||choice==3)
            {
              
           

            System.out.println("Enter ATM pin--->");
            int pin = obj.nextInt();

            user_pin.Account_Details(pin, choice);
        }else{
            System.out.println("Enter valid choice");
        }
           
        }
    }
}

class User_Bank_Account extends ATMinter {

    Scanner obj = new Scanner(System.in);

    private int balance1001 = 100; // Balance for account holder 1001
    private int balance1002 = 500;

    public void Account_Details(int pin, int choice) {

        ATMinter pAtMinterface = new ATMinter();

        switch (pin) {
            case 1001:
                System.out.println("##################################################################");
                System.out.println();
                System.out.println("Account Holder's Name: Gugan J");
                System.out.println("Account NO: 12345678");
                System.out.println();
                balance1001 = transationProcess(balance1001, choice);
                System.out.println();
                break;

            case 1002:
                System.out.println("##################################################################");
                System.out.println();
                System.out.println("Account Holder's Name: Gowtham  M");
                System.out.println("Account NO: 974645454");
                System.out.println();
                balance1002 = transationProcess(balance1002, choice);
                System.out.println();
                break;

            default:
                System.out.println("Invalid pin");
                break;
        }
        System.out.println("         THANK YOU FOR YOUR TRANSACTION !!");
        System.out.println();
        System.out.println("To Exit Press 0 Or Press Anything..");
        char exit = obj.next().charAt(0);
        if (exit == '0') {
            pAtMinterface.process = false;
        }
    }

    // transactionProcess-------------------------------->
    public int transationProcess(int Balance, int choice) {

        if (choice == 1) {
            System.out.print("Enter Amount to Withdraw : ");
            int amount = obj.nextInt();

            Balance = ToWithdraw(amount, Balance);

        } else if (choice == 2) {
            System.out.print("Enter Amount to Deposit : ");
            int amount = obj.nextInt();

            Balance = ToDeposit(amount, Balance);

        } else if (choice == 3) {
            System.out.println("Total Balance :  " + Balance);
        }

        return Balance;
    }
}
