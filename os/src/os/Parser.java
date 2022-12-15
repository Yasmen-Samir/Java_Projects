package os;

public class Parser {
    String commandName;
    String[] args; 
    //This method will divide the input into commandName and args
    //where "input" is the string command entered by the user
    public boolean parse(String input)
    {
        if(commandName == input);
           return true;
    }
    public String getCommandName()
    {
        return commandName;
    }
    public String[] getArgs(String args[])
    {
        return args;
    }
}

