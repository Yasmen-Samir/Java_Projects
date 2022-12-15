package gofo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PlaygroundOwner {

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String Password;

    /**
     *
     */
    private String Email;

    /**
     *
     */
    private String Address;
    
    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private String phoneNo;
    
    /**
     *
     */
    private Ewallet ewallet = new Ewallet();
    
    /**
     *
     */
    public PlaygroundOwner()
    {
        
    }
   
    /**
     *
     * @param name
     * @param Password
     * @param Email
     * @param Address
     */
    public PlaygroundOwner(String name , String Password , String Email , String Address)
   {
        this.name = name;
        this.Password = Password;
        this.Email = Email;
        this.Address = Address;
   }

    /**
     *
     * @param name
     * @param Password
     * @param Email
     * @param Address
     * @param phoneNo
     */
    public void Login(String name , String Password , String Email , String Address, String phoneNo)
    {
        this.name = name;
        this.Password = Password;
        this.Email = Email;
        this.Address = Address;
        this.phoneNo = phoneNo;
        
    }
   
    /**
     *
     * @param firstName
     * @param lastName
     * @param Password
     * @param Email
     * @param Address
     * @param phoneNo
     */
    public void Register(String firstName , String lastName , String Password , String Email , String Address , String phoneNo)
   {
       this.firstName = firstName;
       this.lastName = lastName;
       this.Password = Password;
       this.Email = Email;
       this.Address = Address;
       this.phoneNo = phoneNo;      
   }
      
    /**
     *
     * @param playground
     * @return
     */
    public Playground Get_Playground_Information (Playground playground)
    {
        return playground;
    }
    
    /**
     *
     * @param money
     */
    public void Get_Money(double money)
    {
        ewallet.Withdraw_Money(money);
    }
    
    /**
     *
     * @param money
     */
    public void Deposit_Money(double money)
    {
        ewallet.Add_Money(money);
    }
    
    /**
     *
     * @return
     */
    public double Check_Balance()
    {
        return ewallet.Display_Available_Money();
    }
          
    /**
     *
     */
    ArrayList<Booking> bookings = new ArrayList<Booking>();
    
    /**
     *
     * @param booking
     */
    public void add_Booking(Booking booking)
    {
        bookings.add(booking);
    }
    
    /**
     *
     * @return
     */
    public List<Booking> ShowBookings()
    {
        return bookings;
    }  
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
    return String.format("\n" + "Name:" + " " + name + "\n" + "Email:" + " " + Email + "\n");
    }
}
