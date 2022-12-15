//yasmen samir
//20190619

package tcp.pkg2;
 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Clientt  {
    
        Clientt(){
            
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip);
            Socket server = new Socket(ip, 22000);
            
            
        
            int [] x = new int[10];;
            Scanner read = new Scanner(System.in);
           
            for(int i=0; i<10; i++)
            {
                x[i]=read.nextInt();
            }
                     
                for (int i=0; i<10; i++){
                DataOutputStream WriteToServer = new DataOutputStream(server.getOutputStream());
                WriteToServer.writeInt(x[i]);
                }
                
                
                int[] arr1= new int[10];
                for(int i =0; i<10; i++){
                    DataInputStream ReadFromServer = new DataInputStream(server.getInputStream());
                    arr1[i]=ReadFromServer.readInt();
        }
                               
                System.out.println("your items in ascending way are:"+ Arrays.toString(arr1));
                
                              
                int[] arr2= new int[10];
                for(int i =0; i<10; i++){
                    DataInputStream ReadFromServer = new DataInputStream(server.getInputStream()); 
                    arr2[i]=ReadFromServer.readInt();
        } 
                
                System.out.println("Descending"+Arrays.toString(arr2));
                
            
        } catch (IOException ex){
      	Logger.getLogger(Serverr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    


    

