package gofo;

/**
 *
 * @author LENOVO
 */
public class Playground {
    
    /**
     *
     */
    private String name;

    /**
     *
     */
    private String location;

    /**
     *
     */
    private double price_for_purchase;

    /**
     *
     */
    private double price_for_reservation;

    /**
     *
     */
    private double size;

    /**
     *
     */
    private double Available_Hours;

    /**
     *
     */
    private PlaygroundOwner owner;

    /**
     *
     */
    private Booking booking;
    
    /**
     *
     */
    public Playground()
    {
        
    }
    
    /**
     *
     * @param name
     * @param location
     * @param price_for_purchase
     * @param price_for_reservation
     * @param size
     * @param Available_Hours
     * @param owner
     */
    public Playground (String name, String location, double price_for_purchase,double price_for_reservation, double size, double Available_Hours , PlaygroundOwner owner)
    {
        this.name = name;
        this.location = location;
        this.price_for_purchase = price_for_purchase;
        this.price_for_reservation = price_for_reservation;
        this.size = size;
        this.Available_Hours = Available_Hours;
        this.owner = owner;
    }
    
    /**
     *
     * @param owner
     */
    public void Set_Owner (PlaygroundOwner owner)
    {
        this.owner = owner;
    }
    
    /**
     *
     * @return
     */
    public double Get_Price_Per_Hour()
    {
        return price_for_reservation/Available_Hours;
    }
    
    /**
     *
     * @param playground
     * @return
     */
    public Playground Update_Playground_Informationn(Playground playground)
    {
        name = playground.name;
        location = playground.location;
        price_for_purchase = playground.price_for_purchase;
        price_for_reservation = playground.price_for_reservation;
        size = playground.size;
        Available_Hours = playground.Available_Hours;
        
        return playground;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("\n" +"Name:" + " " + name + "\n" + "Location:" + " " + location + "\n" + "price for purchase:" + " " + price_for_purchase + "\n" + "price for reservation:" + " " + price_for_reservation + "\n" + "Size:" + " " + size + "\n" + "Available Hours:" + " " + Available_Hours + "\n" + "\n" + "playground owner:" + " " + owner + "\n");
    }
    
}
