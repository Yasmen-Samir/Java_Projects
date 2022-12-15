/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saraf
 */
public class Player {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraf
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
    int Player_Number;
    
    /**
     *
     */
    private Playground playground;

    /**
     *
     */
    private Booking booking;

    /**
     *
     */
    private Team team;
    
    /**
     *
     */
    public Player()
    {
        
    }
   
    /**
     *
     * @param name
     * @param Email
     * @param Password
     * @param phoneNo
     * @param Player_Number
     * @param booking
     * @param team
     */
    public Player(String name, String Email, String Password, String phoneNo, int Player_Number, Booking booking, Team team)
            
    {
        this.name = name;
        this.Email = Email;
        this.Password = Password;
        this.phoneNo = phoneNo;
        this.Player_Number = Player_Number;
        this.playground = playground;
        this.booking = booking;
        this.team = team;
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
     * @param num
     */
    public void Set_PlayerNum (int num)
   {
       this.Player_Number = num;
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
     * @param booking
     */
    public void Request_Booking(Booking booking)
    {
        booking.add_Booking(booking);
        this.booking = booking;
    }
    
    /**
     *
     * @param booking
     */
    public void Cancel_Request(Booking booking)
    {
        booking.Cancel_Booking(booking);
    } 
    
    /**
     *
     * @param playground
     */
    public void Select_Playground(Playground playground)
    {
        this.playground = playground;
    }

    /**
     *
     * @return
     */
    public Playground Get_Playground()
    {
        return this.playground;
    }
    
    /**
     *
     * @param team
     */
    public void Join_Team(Team team)
    {
        team.Add_Member(this);
        this.team = team;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Name:" + " " + name + "\n" + "Email:" + " " + Email + "\n" + "Player Number:" + " " + Player_Number + "\n" + "\n" + "Booking:" + " " + booking + "\n" + "Team:" + " " + team + "\n");
    }

    /**
     *
     */
    ArrayList<Team> teams = new ArrayList<Team>();

    /**
     *
     */
    ArrayList<Playground> playgrounds = new ArrayList<Playground>();
    
    /**
     *
     * @param team
     */
    public void add_Team(Team team)
    {
        teams.add(team);
    }
    
    /**
     *
     * @param playground
     */
    public void add_Playground(Playground playground)
    {
        playgrounds.add(playground);
    }
    
    /**
     *
     * @return
     */
    public List<Playground> ViewPlaygrounds()
    {
        return playgrounds;
    }    
       
    /**
     *
     * @return
     */
    public List<Team> ShowTeams()
    {
        return teams;
    } 
    
}




