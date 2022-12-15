package software;

import java.util.ArrayList;
import java.util.List;

/**
 * this is a class Bank that stores the information of the clients and accounts 
 * @author alaa
 */
public class Bank {
   
    private String name;
    private String address;
    private long phone;

    /**
     *This is a default constructor 
     */
    public Bank()
    {
        
    }

    /**
     *This is a parameterized constructor 
      that takes name ,address and phone as parameters
     * @param name
     * @param address
     * @param phone
     */
    
    public Bank(String name , String address , long phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    /**
     *This function to set name of the client
     * @param name
     */
    public void setName(String name){
    
        this.name = name;
    }
 
    /**
     *This function to set Address of the client
     * @param address
     */
    public void setAddress(String address){
    
       this.address = address;
    }   
 
    /**
     *This function to set Phone of the client
     * @param phone
     */
    public void setPhone(long phone){
    
       this.phone = phone;
    } 
 
    /**
     *
     * @return return the name of the client
     */
    public String getName(){
       return name;
    }  

    /**
     * 
     * @return return the address of the client
     */
    public String getAddress(){
        return address;
    } 

    /**
     *
     * @return return the phone of the client
     */
    public long getPhone(){
        return phone;
    }      
    /*
    *This is ArrayList stores the account object 
     and should be able to be updated if user set balance ,
     balance_after_deposit and account_number
    */
    ArrayList<Account> accounts = new ArrayList<Account>();
    /*
    *This is ArrayList stores the account object 
     and should be able to be updated if user set name,nationalID
     address,phone and creat object from account
    */  
    ArrayList<Client> clients = new ArrayList<Client>();
    ArrayList<CommercialClient> commercialClients = new ArrayList<CommercialClient>();

    /**
     *This function to add a new object of account 
     * @param account
     */
    public void addAccount(Account account)
    {
        accounts.add(account);
    }
 
    /**
     *This function to add a new object of Client
     * @param client
     */
    public void addClient(Client client)
    {
        clients.add(client);
    }
  
    /**
     *This function to add a new object of CommercialClient
     * @param commercialClient
     */
    public void addCommercialClient(CommercialClient commercialClient)
    {
       commercialClients.add(commercialClient);
    }
   
    /**
     *This function to display List of Accounts object
     * @return
     */
    public List<Account> displayAccounts()
    {
        return accounts;
    }
       
    /**
     *This function to display List of Clients object
     * @return
     */
    public List<Client> displayClients()
    {
        return clients;
    }
    
    /**
     *This function to display List ofCommercialClients object
     * @return
     */
    public List<CommercialClient> displayCommercialClients()
    {
        return commercialClients;
    }
    
    
}
    
    
