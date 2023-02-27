import java.util.Scanner;
class Account
{
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accNumber, String accHolder, double bal)
    {
        this.accountNumber = accNumber;
        this.accountHolder = accHolder;
        this.balance = bal; 
    }

    public double getBalance()
    {
        return balance;
    }

    public void processDeposit(double amount)
    {
        /* Scanner cin = new Scanner(System.in);
        double sum;
        System.out.println();
        System.out.println("What amount would you like to deposit ? ")
        sum = cin.nextDouble();*/
        balance = balance + amount;
    }

    public void processCheck(double amount)
    {
        /*double check=0;
        Scanner cin = new Scanner(System.in);
        System.out.println();
        System.out.println("What amount would you like to withdraw using the check? (if the balance of the account is negative 1000 there will be a surcharge of 15)")
        check = cin.nextDouble();*/
        if(balance <= -1000)
        {
            amount = amount + 15;
        }
        balance = balance - amount;
    }
}

public class AccountTest
{
    public static void main (String[] args )
    {
        Account account1 = new Account("01", "Ovidiu",2700.30);
        Account account2 = new Account("02", "Andrei",-1000);
        System.out.println("Account 1: " + account1.getBalance() + "(RON)");
        System.out.println("Account 2: " + account2.getBalance() + "(RON)");
        account1.processDeposit(2000);
        account2.processCheck(1500);
        System.out.println();
        System.out.println("Account 1: " + account1.getBalance() + "(RON)");
        System.out.println("Account 2: " + account2.getBalance() + "(RON)");
    }
}