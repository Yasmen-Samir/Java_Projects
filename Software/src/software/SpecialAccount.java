package software;

/**
 * class SpecialAccount inherits from class Account
 * special account is a account that his client may withdraws money greater than his balance till 1000 EGP
 * @author sara
 */
public class SpecialAccount extends Account {

    /**
     * This is a function that sets the amount of withdraw
     * and check if the amount of withdraw is greater than the balance 
     * and the difference between the amount of withdraw and the balance is less than or equal to 1000
     * then get the difference between the amount of withdraw and the balance 
     * and if the difference between the amount of withdraw and the balance is greater than 1000
     * then print a message says that it is invalid process and return the balance without modifying
     * @param withdraw is a variable that inherited from class Account that stores the amount of withdraw 
     */
    
    public void withdraw(double withdraw)
    {
     if(super.get_balance() < withdraw && withdraw - super.get_balance() <= 1000)
         
     {
         super.set_balance(super.get_balance() - withdraw);
         System.out.println("Balance after withdraw: " + super.get_balance());
     }
     
     else if(super.get_balance() < withdraw && withdraw - super.get_balance() > 1000)
     {
         System.out.println("Invalid Process, this amount of money exceeds your balance with more than 1000 ");
         System.out.println("Balance after withdraw: " + super.get_balance());
     }
     
     else
     {
         super.withdraw(withdraw);
     }
     
    }
    
}
