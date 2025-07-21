package software;

/**
 * This is a class Account that stores the information of client's account (his account number , his balance)
 * @author sara
 */
public class Account {

    private double balance;
    private int account_number;

    /**
     * This is a default constructor
     */
    public Account()
    {
        
    }
    
    /**
     * This is a parameterized constructor that takes account number and balance as parameters
     * @param account_number is a variable that store the number of the client's account
     * @param balance is a variable that store the balance of the client
     */
    public Account(int account_number,double balance )
    {
        this.account_number = account_number;
        this.balance = balance;      
    }
    
    /**
     * This is a function that sets the account number of the client
     * @param account_number
     */
    public void set_account_number(int account_number )
    {
        this.account_number =  account_number ;
    }

    /**
     *
     * @return the account number of the client
     */
    public double get_account_number()
    {
      return account_number;
    }

   /**
     * This is a function that sets the balance of the client
     * @param balance
     */
    public void set_balance(double balance)
    {
        this.balance = balance;
    }
     
    /**
     *
     * @return the balance of the client
     */
    public double get_balance()
    {
      return balance;
    }
    
    /**
     *
     * @return the information of the account
     */
    public String toString()
    {
        return "Acount Number is:" + " " + account_number + " " + ",,," + " " + "and Balance is:" + " " + balance + "\n";   
    }
    
    /**
     * This is a function that sets the amount of withdraw that the client want
     * @param withdraw
     */
    public void withdraw(double withdraw)
    {
     if(balance >= withdraw)
     {
        balance = balance - withdraw;
        System.out.println("Balance after withdraw: " + balance);
     }
     else
         System.out.println("It is an invalid process, this amount of money exceeds your balance");
    }

    /**
     *
     * @return the balance after withdraw
     */
    public double get_withdraw()
    {
        return balance;
    }
    
    /**
     * This is a function that sets the amount of deposit that the client want
     * @param deposit
     */
    public void deposit(double deposit)
    {
        balance = balance + deposit;
    }
    
    /**
     *
     * @return the balance after deposit
     */
    public double get_deposit()
    {
        return balance;
    }
      
}

    
    
    
    
    
    


    


    
    
    
    
    

