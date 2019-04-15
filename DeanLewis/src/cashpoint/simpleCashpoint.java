package cashpoint;

import java.util.Scanner;

public class simpleCashpoint {

    private String username = "Dean";
    private String password = "Password";

    private double cAccountBalance;
    private double jAccountBalance;
    private double sAccountBalance;

    Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {

        simpleCashpoint sc = new simpleCashpoint();
        sc.init();
    }

    private void init() {
        System.out.println("Username: ");
        String enteredUsername = myScanner.nextLine();
        System.out.println("Password: ");
        String enteredPassword = myScanner.nextLine();
        if(validateLoginDetails(enteredUsername, enteredPassword)){
            mainMenu();
        }
        else {
            System.out.println("Invalid details have been entered. Please try again");
            init();
        }


    }

    private void mainMenu() {
        System.out.println("What would you like to do?");
        String input = myScanner.nextLine().toLowerCase();
        getAction(input);
    }

    private void getAction(String input) {
        switch(input){
            case "transfer":                transfer();
                break;

            case "deposit":
                deposit();
                break;

            case "balance":
                checkBalance();
                break;

            case "withdraw":
                withdraw();
                break;

            case "logout":
                logout();
                break;

                default:
                    System.out.println("Incorrect input received");
                    System.out.println("Please enter any of the following:");
                    System.out.println("Balance - Check Account Balance");
                    System.out.println("Deposit - Make a deposit to an Account");
                    System.out.println("Withdraw - Make a cash withdrawal");
                    System.out.println("Transfer - Make a transfer between accounts");
                    System.out.println("Logout - sign out of your account");
                    mainMenu();
        }
    }

    private void transfer(){
        System.out.println("Which account would you like to transfer from?");
        String source = myScanner.nextLine();
        System.out.println("Which account would you like to transfer to?");
        String destination = myScanner.nextLine();
        System.out.println("How much would you like to transfer?");
        double amount = Double.parseDouble(myScanner.nextLine());

        if(source.equalsIgnoreCase("Current")){
            if(cAccountBalance >= amount){
                if(destination.equalsIgnoreCase("Joint")){
                    jAccountBalance += amount;
                    cAccountBalance -= amount;
                }
                else if(destination.equalsIgnoreCase("Savings")){
                    sAccountBalance += amount;
                    cAccountBalance -= amount;
                }
                else {
                    System.out.println("Invalid destination account");
                }
            }
        }
        else if(source.equalsIgnoreCase("Joint")){
            if(jAccountBalance >= amount){
                if(destination.equalsIgnoreCase("Current")){
                    cAccountBalance += amount;
                    jAccountBalance -= amount;
                }
                else if(destination.equalsIgnoreCase("Savings")){
                    sAccountBalance += amount;
                    jAccountBalance -= amount;
                }
                else {
                    System.out.println("Invalid destination account");
                }
            }
        }
        else if(source.equalsIgnoreCase("Savings")){
            if(sAccountBalance >= amount){
                if(destination.equalsIgnoreCase("Current")){
                    cAccountBalance += amount;
                    sAccountBalance -= amount;
                }
                else if(destination.equalsIgnoreCase("Joint")){
                    jAccountBalance += amount;
                    sAccountBalance -= amount;
                }
                else {
                    System.out.println("Invalid destination account");
                }
            }
        }
        else {
            System.out.println("Invalid source account");
        }
        mainMenu();

    }

    private void logout() {
        System.out.println("Logging Out");
        init();
    }

    private void deposit() {
        System.out.println("Which account would you like to make a deposit to?");
        String account = myScanner.nextLine();
        System.out.println("how much would you like to deposit?");
        short depositAmount = Short.parseShort(myScanner.nextLine());

        if(account.equalsIgnoreCase("Current")) {
            cAccountBalance += depositAmount;
        }
        else if(account.equalsIgnoreCase("Joint")) {
            jAccountBalance += depositAmount;
        }
        else if(account.equalsIgnoreCase("Savings")) {
            sAccountBalance += depositAmount;
        }
        else {
            System.out.println("Invalid account option provided");
        }
    }

    private void withdraw() {
        System.out.println("Which account would you like to make a withdrawal from?");
        String account = myScanner.nextLine();
        System.out.println("how much would you like to withdraw?");
        short withdrawAmount = Short.parseShort(myScanner.nextLine());

        if(account.equalsIgnoreCase("Current")){
            if(withdrawAmount <= cAccountBalance){
                cAccountBalance -= withdrawAmount;
            }
            else
                System.out.println("Insufficient Funds");
        }
        else if(account.equalsIgnoreCase("Joint")){
            if(withdrawAmount <= jAccountBalance){
                jAccountBalance -= withdrawAmount;
            }
            else
                System.out.println("Insufficient Funds");
        }
        else if(account.equalsIgnoreCase("Savings")){
            if(withdrawAmount <= sAccountBalance){
                sAccountBalance -= withdrawAmount;
            }
            else
                System.out.println("Insufficient Funds");
        }
        else {
            System.out.println("Invalid account option provided");
        }
        mainMenu();
    }

    private void checkBalance() {
        System.out.println("Which account would you like to check the balance of?");
        String account = myScanner.nextLine();
        if(account.equalsIgnoreCase("Current")){
            System.out.println("Your current account balance is: " + cAccountBalance);
        }
        else if(account.equalsIgnoreCase("Joint")){
            System.out.println("Your current account balance is: " + jAccountBalance);
        }
        else if(account.equalsIgnoreCase("Savings")){
            System.out.println("Your current account balance is: " + sAccountBalance);
        }
        else {
            System.out.println("Invalid account option provided");
        }
        mainMenu();
    }

    private boolean validateLoginDetails(String enteredUsername, String enteredPassword){
        if(enteredUsername.equals(username) && enteredPassword.equals(password)){
            return true;
        }
        return false;
    }

}
