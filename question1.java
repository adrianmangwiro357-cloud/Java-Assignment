import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// creating an abstract class
abstract class Bank {
    protected String accountName;
    protected double balance;

    public Bank(String accountName, double initialBalance){
        this.accountName = accountName;
        this.balance = initialBalance;
    }
    // creating abstract methods
    public abstract void deposit( double amount);
    public abstract void withdraw(double amount);
    public abstract double getBalance();

    // creating method to record transactions
    protected void recordTransaction(String type, double amount, String status){
       try(PrintWriter writer = new PrintWriter(new FileWriter("bank.txt", true))){
        writer.println("Account: "+ accountName + "|Transaction: " + type + "|Amount: " + amount + "|Balance: " + balance + "|status " + status);
        
       } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
       }
    }
}
// creating Account class extending Bank
class Account extends Bank{
    public Account(String accountName,double initialBalance){
        super(accountName, initialBalance);
    }
    @Override
    public void deposit ( double amount){
        if (amount >0) {
            balance += amount;
            recordTransaction("DEPOSIT", amount, "SUCCESS");
        }else{recordTransaction("DEPOSIT", amount, "FAILED-(Invalid amount");}

    }
    @Override
    public void withdraw( double amount){
        if (amount > balance) {
            recordTransaction("WITHDRAWAL", amount, "FAILED-(Insufficient funds)");
            System.out.println("Withdrawal amount exceeded account balance");
        }else if ( amount <= 0){
            recordTransaction("WITHDRAW", amount, "FAILED-(invalid amount)");
        }else{
            balance -=amount;
            recordTransaction("WITHDRAW", amount, "SUCCESS");
        }
    }
    @Override
    public double getBalance(){
        recordTransaction("BALANCE_CHECK", 0, "SUCCESS");
        return balance;
    }
}
//Test class
class AccountTest{
    public static void main(String[] args) {
        //creating account with balance
        Account account = new Account("Adrian Mangwiro", 1000.00);
        //testing deposits
        account.deposit(500.00);
        account.deposit(-200.00);
        //testing withdrawals
        account.withdraw(200.00);
        account.withdraw(3000.00);
        account.withdraw(-50.00);

        //testing balance check
        double balance = account.getBalance();
        System.out.println("Current balance: $" + balance);

        account.deposit(300.00);
        account.withdraw(400.00);

        System.out.println("Final balance: $"+ account.getBalance());

    }
}