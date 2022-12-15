package osass2;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class Semaphore {

    protected int counter = 0;

    protected Semaphore() {
        counter = 0;
    }

    protected Semaphore(int initial) {
        counter = initial;
    }

    public synchronized void Wait() {
        counter--;
        if (counter < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void Signal() {
        counter++;
        if (counter <= 0) {
            notify();
        }
    }
    
    public boolean IsAvailablePlace() {
		return counter > 0;
	}
}
    
class Router{
	private Device[] Connections_List;
	private Semaphore semaphore;

	public Router(int counter) {
		semaphore = new Semaphore(counter);
		Connections_List = new Device[counter];
		for(int i = 0 ;  i < counter ; i++)
			Connections_List[i] = null;
	}

	public int occupy(Device device) {
		synchronized (semaphore){
			if (semaphore.IsAvailablePlace()) {
				System.out.println("(" + device.name + ")" + " (" + device.type + ")" + " arrived");
			} else {
				System.out.println("(" + device.name + ")" + " (" + device.type + ")" + " arrived and waiting");
			}
			semaphore.Wait();
			int index = 0 ;
			for (int i = 0 ; i < Connections_List.length; i++) {
				if (Connections_List[i] == null) {
					Connections_List[i] = device;
					break;
				}
			}
			System.out.println("Connection " + (index+1) + ": "+ device.name + " (" + device.type + ") "  + "Occupied");
			return index;
		}
	}
	
	public void release(Device device) {
		synchronized (semaphore){
			for (int i = 0; i < Connections_List.length; i++) {
				if (Connections_List[i] == device) {
					System.out.println("Connection " + (i + 1) + ": " + device.name + " (" + device.type + ") " + "Logged out");
					Connections_List[i] = null;
					semaphore.Signal();
					break;
				}
			}
		}
	}
}

class Device extends Thread {

    String name;
    String type;
    int connections_number;
    Random random = new Random();
    private Router router;

    protected Device(String name, String deviceType, Router router) {
        this.name = name;
        this.router = router;

        if (deviceType.equals("mobile") || deviceType.equals("tablet") || deviceType.equals("laptop") || deviceType.equals("pc")) {
            type = deviceType;
        } else {
            type = "Device";
        }

    }

    public void Connect() {
        connections_number = router.occupy(this);
    }

    public void Disconnect() {
        router.release(this);
    }

    public void PreformActivity() {
        try {
            System.out.println("Connection " + (connections_number + 1) + ": " + name + " (" + type + ") " + "login");
            System.out.println("Connection " + (connections_number + 1) + ": " + name + " (" + type + ") " + "Performs online activity");
            Device.sleep(10000 + random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.Connect();
        this.PreformActivity();
        this.Disconnect();
    }

}


public class Network {

    public static void main(String args[]){
        
        int number_of_connections;
        int number_of_devices;
                
     try{
        PrintStream myconsole = new PrintStream(new File("E:\\JAVA\\/output.txt"));
        System.setOut(myconsole);
      
        Scanner input = new Scanner(System.in);
        
       // System.out.println("What is the number of WI-FI Connections?");
        number_of_connections = input.nextInt();
        Router router = new Router(number_of_connections);
        
       // System.out.println("What is the number of devices Clients want to connect?");
        number_of_devices = input.nextInt();
        for(int i = 0; i < number_of_devices; ++i){
            String name = input.next();
            String type = input.next();
            Device device = new Device(name, type, router);
            device.start();
        }
       } 
         catch(FileNotFoundException fx)
     {
         System.out.println(fx);
     }
     
    }
}