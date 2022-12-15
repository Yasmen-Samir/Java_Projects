package gofo;

/**
 *
 * @author LENOVO
 */
public class Team {
    
    /**
     *
     */
    private String name;

    /**
     *
     */
    private double score;

    /**
     *
     */
    private Player player;
    
    /**
     *
     */
    public Team()
    {
        
    }
        
    /**
     *
     * @param name
     * @param score
     */
    public Team(String name, double score)
    {
        this.name = name;
        this.score = score;
    }
            
    /**
     *
     * @param player1
     */
    public void Add_Member(Player player1)
    {
        player = player1; 
    }

    /**
     *
     * @param player1
     */
    public void Delete_Member(Player player1)
    {
        player = null; 
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("\n" +"Name:" + " " + name + "\n" + "Score:" + " " + score + "\n");
    }
}

