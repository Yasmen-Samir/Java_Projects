package software;

/**
 * this is a class Client that stores the information of the client (name, national id, address, phone, account)
 * @author yasmen
 */
public class Client {
    
    private String name;
    private long nationalID;
    private String address;
    private long phone;
    private Account account;

    /**
     * this is a default constructor
     */
    public Client()
    {
        
    }
   
    /**
     * this is a parametrized constructor that takes client's name, national id, address, phone and account as parameters 
     * @param name that stores the client's name
     * @param nationalID that stores the client's national id
     * @param address that stores the client's address
     * @param phone that stores the client's phone
     * @param account that stores the client's account
     */
    public Client (String name, long nationalID, String address, long phone, Account account){
    
        this.name = name;
        this.nationalID = nationalID;
        this.address = address;
        this.phone = phone;
        this.account = account;
      
    }
    
    /**
     * this is a function that sets the client's name
     * @param name
     */
    public void setName(String name){
    
        this.name = name;
    }
   
    /**
     * this is a function that sets the client's national id
     * @param nationalID
     */
    public void setNationalID(long nationalID){
    
       this.nationalID = nationalID;
    } 
    
    /**
     * this is a function that sets the client's address
     * @param address
     */
    public void setAddress(String address){
    
       this.address = address;
    }      

    /**
     * this is a function that sets the client's phone
     * @param phone
     */
    public void setPhone(long phone){
    
       this.phone = phone;
    }    

    /**
     * this is a function that sets the client's account
     * @param account
     */
    public void setAccount(Account account){
    
       this.account = account;
    } 
  
    /**
     *
     * @return the client's name
     */
    public String getName(){
        return name;
    }  
   
    /**
     *
     * @return the client's national id
     */
    public long getNationalID(){
        return nationalID;
    }      

    /**
     *
     * @return the client's address
     */
    public String getAddress(){
        return address;
    }   

    /**
     * 
     * @return the client's phone
     */
    public long getPhone(){
        return phone;
    }   
 
    /**
     *
     * @return the client's account
     */
    public Account getAccount(){
        return account;
    }      

    /**
     *
     * @return the information of the client
     */
    @Override
    public String toString() {
        return String.format("Name:" + " " + name + "\n" + "National ID:" + " " + nationalID + "\n" + "Address:" + " " + address + "\n" + "Phone Number:" + " " + phone + "\n" + "Account:" + " " + account + "\n");
    }
      
}    
    
   
