package gofo;

/**
 *
 * @author LENOVO
 */
public class Booking {
    
    /**
     *
     */
    private double hours;

    /**
     *
     */
    private String date;

    /**
     *
     */
    private Playground playground;
    
    /**
     *
     */
    public Booking()
    {
        
    }
               
    /**
     *
     * @param hours
     * @param date
     * @param playground
     */
    public Booking(double hours, String date, Playground playground)
    {
        this.hours = hours;
        this.date = date;
        this.playground = playground;
    }
                       
    /**
     *
     * @param booking
     */
    public void add_Booking(Booking booking)
    {
        hours = booking.hours;
        date = booking.date;
        playground = booking.playground;
    }
       
    /**
     *
     * @param booking
     */
    public void Cancel_Booking(Booking booking)
    {
        hours = 0;
        date = null;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
    return String.format("\n" + "Hours:" + " " + hours + "\n" + "Date:" + " " + date + "\n" + "Playground:" + " " + playground + "\n");
    }
                
}
