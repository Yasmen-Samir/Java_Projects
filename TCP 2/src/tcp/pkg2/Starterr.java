//yasmen samir
//20190619

package tcp.pkg2;

import java.util.Scanner;

public class Starterr {
    
            public static void main(String[] args) {
            Scanner scan = new Scanner (System.in);
                
            if(scan.next().equals("server")){
                // code Server
                Serverr s = new Serverr();
            }
            else{
                // code client
                Clientt c = new Clientt();
            }
    }
    
}
    
