package gofo;

/**
 *
 * @author LENOVO
 */
public class Ewallet {
    
    /**
     *
     */
    private double balance;

    /**
     *
     */
    private int id;
    
    /**
     *
     */
    public Ewallet ()
    {
        balance = 0;
    }
    
    /**
     *
     * @param balance
     * @param id
     */
    public Ewallet(double balance, int id)
    {
        this.balance = balance;
        this.id = id;
    }
    
    /**
     *
     * @param money
     */
    public void Set_Balance(double money)
    {
        balance = money;
    }
    
    /**
     *
     * @param money
     */
    public void Add_Money(double money)
    {
        balance+=money;
    }
    
    /**
     *
     * @param money
     */
    public void Withdraw_Money(double money)
    {
        balance-=money;
    }
    
    /**
     *
     * @return
     */
    public double Display_Available_Money()
    {
        return balance;
    }
    
}
