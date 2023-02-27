import java.util.Calendar;
abstract class BankAccount 
{

    private int id;
    protected double balance;
    private String Owner;
    private static int idCurrentBankAccount = 1;

    public BankAccount(long balance, String owner) 
    {
        this.balance = balance;
        this.Owner = owner;
        this.id = idCurrentBankAccount;
        idCurrentBankAccount++;
    }

    public BankAccount(String Owner) 
    {
        this.id = idCurrentBankAccount;
        idCurrentBankAccount++;
        this.Owner = Owner;
        this.balance = 0;
    }

    public void deposit(double sum) 
    {
        this.balance = this.balance + sum;
    }

    public void withdraw(double suma) 
    {
        if (this.balance >= suma)
            this.balance = this.balance - suma;
        else
            System.out.print("Insufficient funds!");
    }

    public int getId() 
    {
        return id;
    }

    public double getBalance() 
    {
        return balance;
    }

    public String getOwner() 
    {
        return Owner;
    }

    public abstract void endOfMonth();

    public String toString() 
    {
        return "Owner " + this.Owner + " ,id " + this.id + " has " + this.balance + " lei";
    }
}

class SavingsBankAccount extends BankAccount 
{
    private double interest;

    public SavingsBankAccount(String owner, double interestRate) 
    {
        super(owner);
        this.interest = interestRate;
    }

    public SavingsBankAccount(String owner, double balance, double interestRate) 
    {
        super((long)balance, owner);
        this.interest = interestRate;
    }

    public void applyinterest() 
    {
        deposit(getBalance() * this.interest);
    }

    public double getInterest() 
    {
        return interest;
    }

    public void endOfMonth() 
    {
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        int nextDayMonth = cal.get(Calendar.MONTH);
        if(currentMonth != nextDayMonth)
            applyinterest();
    }

    public String toString() 
    {
        return getClass() + " " + super.toString() + " with interest rate " + this.interest;
    }
}

class CurrentAccount extends BankAccount 
{
    private int transactionNo;
    private final int FREE_TRANSATION = 3;
    private final double TRANSATION_COST;

    CurrentAccount(String owner, double balance, int transNR, int TransCost) 
    {
        super((long) balance, owner);
        this.TRANSATION_COST = transNR;
        this.transactionNo = transNR;

    }

    private void dischargeExpenses() 
    {
        super.balance = super.balance-((this.transactionNo - this.FREE_TRANSATION) * this.TRANSATION_COST);
    }

    public void deposit(double sum) 
    {
        super.deposit(sum);
    }

    public void withdraw(double suma) 
    {
        super.withdraw(suma);
    }

    public void endOfMonth() 
    {

        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        int nextDayMonth = cal.get(Calendar.MONTH);
        if (currentMonth != nextDayMonth) 
        {
            dischargeExpenses();
            this.transactionNo = 0;
        }
    }

    public String toString() 
    {

        return getClass() + " " + super.toString();
    }
}

public class TestAccount4 
{

    public + void main(String[] args) 
    { 
        
        CurrentAccount b1 = new CurrentAccount("Ovidiu", 2140, 10, 5);
        CurrentAccount b2 = new CurrentAccount("Andrei", 5120, 111, 10);

        SavingsBankAccount s1 = new SavingsBankAccount("Mihai", 500, 20);
        SavingsBankAccount s2 = new SavingsBankAccount("Ionut", 2000, 20);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println();
        b1.deposit(5000);
        b2.withdraw(120);
        System.out.println(b1);
        System.out.println(b2);
        b1.endOfMonth();
        s1.endOfMonth();
        System.out.println(b1);
        System.out.println(s1);
    }

}