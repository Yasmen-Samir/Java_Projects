package os;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Terminal {

    Parser parser;
    String input;
    
    public String echo(String name)
    {
        return name;
    }
    
    public String pwd()
    {
       String path = System.getProperty("user.dir");
       return(path);
    } 
    
    public void cd()
    {
        String homeDirectory = System.setProperty( "user.dir", "\\user\\username" );
        System.out.println(homeDirectory);
        
    } 
    public void ls() throws IOException 
    {
         Files.list(Paths.get(".")).sorted().forEach(System.out::println);    
    }
    
    public void lsr () throws IOException {
        
       File current = new File (System.getProperty("user.dir"));
       String arr [] = current.list();
       for (int i = arr.length-1; i >= 0; i--)
       {
           System.out.println(arr[i]);
       }
          
    }
    
    public void mkdir (String dir) throws IOException
    {   
        Path path = Paths.get(dir);
        Files.createDirectories(path);
        System.out.println("directory is created..");
   }
    
    public long rmdir (String arg) throws IOException 
    {   
        File f = new File(arg);
        String listFiles[] = f.list();
        long totalSize = 0;
        for (String file : listFiles) {

            File folder = new File(arg + "/" + file);
            if (folder.isDirectory()) {
                totalSize += rmdir(folder.getAbsolutePath());
            } else {
                totalSize += folder.length();
            }
        }

        if (totalSize ==0) {
            f.delete();
        }

        return totalSize;
    }
    
    public void touch (String arg) {
        
       try {
	     File f = new File(arg);
             boolean flag = f.createNewFile();
	     if (flag){
	          System.out.println("File has been created successfully");
	     }
	     else{
	          System.out.println("File already present at the specified location");
	     }
    	} catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
	  }           
    }
        
    public void chooseCommandAction() throws IOException
    {
        do
     {
        System.out.println("Please enter the command name");
     
        String string;
        Scanner scanInput = new Scanner(System.in);
        input = scanInput.next();
       
        if(input.equals("echo"))
        {
            string = scanInput.next();
            System.out.println(string);
        }
        else if(input.equals("pwd"))
        {
            System.out.println(pwd());
        }
        else if(input.equals("cd"))
        {
            cd();
        }
        else if(input.equals("ls")  )
        {
             try
             {
                  ls();
             }
             catch(IOException ioe)
             {
                 System.out.println("This is incorrect");
             }

        }
        
        else if (input.equals("ls-r"))
        {
            try
             {
                 lsr();
             }
             catch(IOException ioe)
             {
                 System.out.println("couldn't make directory");
             }
        }
        
        else if (input.equals("mkdir"))
        {
            try{
            String userInput = scanInput.next();
            mkdir(userInput);
            }
            catch(IOException ioe)
             {
                 System.out.println("couldn't create directory");
             }
            
        }
        
        else if (input.equals("rmdir"))
        {
            try{
            String userInput = scanInput.next();
            if (userInput.equals("*"))
            {
                userInput = System.getProperty("user.dir");
            }
            rmdir(userInput);
            System.out.println("directory deleted..");
            }
            catch(IOException ioe)
             {
                 System.out.println("couldn't remove directory");
             }
            
        }
        
        else if (input.equals("touch"))
        {
            String userInput = scanInput.next();
            touch(userInput);           
        }
        
      }
        while(!input.equals("exit"));
            
        
    }
   
    public static void main(String[] args) throws IOException  {
       

      Terminal terminal = new Terminal();
      terminal.chooseCommandAction();
       
      
       
    }
    
}
