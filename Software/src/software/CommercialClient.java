package software;

/**
 * this is a class CommercialClient that stores the CommercialClient information
 * @author yasmen
 */
public class CommercialClient extends Client {
    
    private long commercialID;
  
    /**
     * this is a function that sets the commercial id of the commercial client
     * @param commercialID
     */
    public void setCommercialID(long commercialID) {
        
        this.commercialID = commercialID;
    }

    /**
     *
     * @return the commercial id of the commercial client
     */
    public long getCommercialID(){
        
        return commercialID;
    }

    /**
     * this is a default constructor
     */
    public CommercialClient()
    {
        
    }
    
    /**
     * this is a parametrized constructor that takes name, commercial id, address, phone and account of the commercial client as parameters 
     * @param name that stores the client's name
     * @param commercialID that stores the client's national id
     * @param address that stores the client's address
     * @param phone that stores the client's phone
     * @param account that stores the client's account
     */
    public CommercialClient(String name, long commercialID, String address, long phone, Account account ){
        
        super (name, 00000000000000, address, phone, account); 
        this.commercialID = commercialID;
        
    }
    
    /**
     *
     * @return the information of the commercial client
     */
    @Override
    public String toString() {
        return String.format("Name:" + " " + super.getName() + "\n" + "commercial ID:" + " " + commercialID + "\n" + "Address:" + " " + super.getAddress() + "\n" + "Phone Number:" + " " + super.getPhone() + "\n" + "Account:" + " " + super.getAccount() + "\n");
    }
                     
}