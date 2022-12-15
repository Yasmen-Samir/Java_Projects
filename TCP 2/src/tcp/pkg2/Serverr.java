//yasmen samir
//20190619

package tcp.pkg2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Serverr {
          Serverr(){      
    {
        try {
            ServerSocket server = new ServerSocket(22000);
            
            Socket client = server.accept();          
            
           int[] arr3= new int[10];
           for(int i =0; i<10; i++){
                DataInputStream ReadFromClient = new DataInputStream(client.getInputStream()); 
                arr3[i]=ReadFromClient.readInt();
        }
          
           Arrays.sort(arr3);
           
   
           int [] arr4 = new int[10];
           for(int i=0; i<10; i++){
           
                arr4[i]=arr3[i];
           
       }
        
           for(int i=0; i<10; i++){
           
            int temp = arr4[i]; 
            arr4[i] = arr4[10 - i - 1]; 
            arr4[10 - i - 1] = temp; 
       }
           
           for(int i =0; i<10; i++){
                DataOutputStream WriteToClient = new DataOutputStream(client.getOutputStream());
                WriteToClient.writeInt(arr3[i]);
       }
       
       
           for(int i =0; i<10; i++){
                DataOutputStream WriteToClient = new DataOutputStream(client.getOutputStream());
                WriteToClient.writeInt(arr4[i]);
       }
           
        } catch (IOException ex){
      	Logger.getLogger(Serverr.class.getName()).log(Level.SEVERE, null, ex);      
        }
    }
  }       
}

    
