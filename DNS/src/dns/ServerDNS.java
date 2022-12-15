package dns;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ServerDNS extends Thread{
	
	///used map to assign name of website and ip in key and value
	static Map<String, String> localMap = new HashMap<String, String>();
	static Map<String, String> rootMap = new HashMap<String, String>();
	static Map<String, String> TLDMap = new HashMap<String, String>();
	static Map<String, String> authoritativeMap = new HashMap<String, String>();
	
	static Boolean author = false;
	static Boolean rootBool = false;
	static Boolean notFound = false;
	static Boolean CNameBool=false;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			///list reading all lines in the files
			List<String> local = Files.readAllLines(Paths.get("local_dns_table.txt"));
			List<String> root = Files.readAllLines(Paths.get("root_dns_table.txt"));
			List<String> TLD = Files.readAllLines(Paths.get("TLD_dns_table.txt"));
			List<String> authoritative = Files.readAllLines(Paths.get("authoritative_dns_table.txt"));
			
			String tempIP = "";
			String tempName = "";
			String wantedIpAddress="";

			
			///assigning list in map by function down
			AddMap(local,localMap);
			AddMap(root, rootMap);
			AddMap(TLD, TLDMap);
			AddMap(authoritative, authoritativeMap);
			
			
			// Create an object of DatagramSocket for the server to listen at port 4000.
			DatagramSocket serverSocket = new DatagramSocket(4000);
			System.out.println("Server is booted up and is waiting for clients to send requests.");

			// Create Array of bytes to receive client's request and send server's response.
			byte[] requestByte = new byte[4096];
			byte[] responseByte = null;
			
			// Take Input from console.
			System.out.println("Server is ready to communicate with any Client");

			while (true) {
				CNameBool=false;
				author=false;
				rootBool=false; 
				notFound=false;
				
				// Create a client packet for receiving the client's request.
				DatagramPacket clientPacket = new DatagramPacket(requestByte, requestByte.length);
				// Receive client's request from the client packet.
				serverSocket.receive(clientPacket);
				

				// Convert Data byte to string
				String req = new String (clientPacket.getData());
				
				System.out.println("Client: " + req.trim());
				
				wantedIpAddress=localFinder(req.trim());
				//System.out.println(wantedIpAdress);
				
				if (CNameBool)
				{
					tempIP = "";
					tempName = "";
					Boolean bToSeperate = true;
					// Creating array of string length 
			        char[] ch = new char[wantedIpAddress.length()]; 
			  
			        // Copy character by character into array
			        for (int j = 0; j < wantedIpAddress.length(); j++) 
			        {
                        ch[j] = wantedIpAddress.charAt(j);
                        if (bToSeperate) 
                        {
                            if (ch[j]!=' ') 
                            {
                            	tempIP+=ch[j];
                            }else
                            {
                                bToSeperate=false;
                            }
                        }
                        else 
                        {
                        	tempName+=ch[j];
                        }
                    }
				}
				
				///================================================
				///Printing CNAMe
				if (CNameBool)
				{
					String toBeSentString="";
					///printing in server side
					System.out.println("Client requested: "+req.trim()+"\nURL	:: "+req.trim()+"\nQuery type: A");
					System.out.println("IP address: "+tempIP+"\nQuery type: CNAME");
					System.out.println("Canonical Name: "+tempName+"\nAliases: "+req.trim());
					
					///assign to variable to send it to client
					toBeSentString+="URL = "+req.trim()+"\nIP Address = "+tempIP+
							"\nQuery type = A, CNAME\nServer name: TLD DNS\nCanonical name: "+tempName+
							"\nAliases: "+req.trim();
					
					///convert Sent message to response bytes
					responseByte=toBeSentString.getBytes();
				}
				
				
				///================================================
				///printing authoritative 
				else if (author) 
				{
					String toBeSentString="";
					///printing in Server
					System.out.println("Client requested: "+req.trim()+"\nURL	:: "+req.trim()+"\nQuery type: A");
					System.out.println("IP address: "+wantedIpAddress+"\nQuery type: NS");
					System.out.println("Found recorded on authoritative DNS servers:");
					System.out.println("Name: authoritative_dns_table.txt\nIP= "+serverSocket.getInetAddress());
					
					///assign to variable to send it for client
					toBeSentString+="URL = "+req.trim()+"\nIP Address = "+wantedIpAddress+
							"\nQuery type = A, NS\nServer name: authoritative DNS\nAuthoritative answer"+
							"\nName: authoritative DNS\nIP= "+serverSocket.getInetAddress();
					
					///convert Sending message to byte
					responseByte=toBeSentString.getBytes();
				}
				
				///================================================
				///printing rootDNS
				else if (rootBool) 
				{
					String toBeSentString="";
					
					///to be printed in server side
					System.out.println("Client requested: "+req.trim()+"\nURL	:: "+req.trim());
					System.out.println("Query type: A"+"\nIP address: "+wantedIpAddress);
				
					///assign string variable with the value that will print in client side
					toBeSentString+="URL= "+req.trim()+"\nIP address: "+wantedIpAddress+"\nQuery type: A"+"\nName: root DNS";
					///convert sending message to response byte
					responseByte=toBeSentString.getBytes();
				}
				
				
				///================================================
				///print for not found 
				else if (notFound) 
				{
					///what will be printed in client side 
					String toBeSentString = "The address you requested wasn't found!";
					///convert sending message to response byte
					responseByte=toBeSentString.getBytes();
				}
				
				///================================================
				///printing local DNS
				else
				{
					String toBeSentString="";
					
					///what will print in server side
					System.out.println("Client requested: "+req.trim()+"\nURL	:: "+req.trim());
					System.out.println("Query type: A"+"\nIP address: "+wantedIpAddress);
					
					///assign what will be printed in client side to string
					toBeSentString+="URL= "+req.trim()+"\nIP address: "+wantedIpAddress+"\nQuery type: A"+"\nServer Name: local DNS";
					///convert sending message to response byte
					responseByte=toBeSentString.getBytes();
				}

				// Extract the IP address & port number of the client.
				InetAddress clientIP = clientPacket.getAddress();
				int clientPort = clientPacket.getPort();

				// Create a server packet for sending the server's response to the client.
				DatagramPacket serverPacket = new DatagramPacket(responseByte, responseByte.length, clientIP,
						clientPort);
				// Send server's response to the client.
				serverSocket.send(serverPacket);

				// Clear the buffer after every message.
				responseByte = null;
				requestByte = new byte[15000];

			}
			
			
		} catch (Exception e) {
			System.out.println("Error in Server!!");
		}

	}
	
	
	///=========================================================================================================
	static void AddMap(List<String> l, Map<String, String> m) 
	{
		for (int i = 0; i < l.size(); i++) 
		{
			String NameString = "" ,ipString = "";
			Integer index=0;
			// Creating array of string length 
	        char[] ch = new char[l. get(i).length()]; 
	  
	        // Copy character by character into array
	        for (int j = 0; j < l.get(i).length(); j++) 
	        { 
	            ch[j] = l.get(i).charAt(j);
	        }
	        /// copy characters to string nameString
	        for (int j = 0; j < ch.length; j++)
	        {
				if (ch[j]==' ')
				{
					index=j;
					break;
				}
				else
				{
					NameString+=ch[j];
				}
			}
	        ///copy IP in string 
	        for (int j = index+1; j < ch.length; j++) 
	        {
				ipString+=ch[j];
			}
	        
	        
	        ///adding the name and IP in map
	        m.put(NameString, ipString);
	       
		}
	}
	
	///============================================================
	static String localFinder(String s) {
		Integer Counter=0;
	       Set<Entry<String, String>> st = localMap.entrySet();
	       for (Entry<String, String> me:st) 
	       {
	    	   Counter++;
	          if (me.getKey().equalsIgnoreCase(s))///if key of the map == the paramter string 
	          {
				return me.getValue(); ///return the value 
				//// map contains to string the first is key and second is value of the key
			  }
	          
	          else if(Counter==localMap.size())
	          {
				return rootFinder(s);
			  }
	       }
	       return null;
	}
	
	///============================================================
	static String rootFinder(String s) {
		Integer Counter=0;
	       Set<Entry<String, String>> st = rootMap.entrySet();

	       for (Entry<String, String> me:st) 
	       {
	    	   Counter++;
	          if (me.getKey().equalsIgnoreCase(s)) {
	        	  rootBool=true;
				return me.getValue();
			}else if(Counter==rootMap.size()){
				return TLDFinder(s);
			}
	       }
		return null;
	}
	
	
	///============================================================
	private static String TLDFinder(String s) {
		Integer Counter = 0;
		// Returns Set view
	       Set<Entry<String, String>> st = TLDMap.entrySet();

	       for (Entry<String, String> me:st) 
	       {
	    	   Counter++;
	          if (me.getKey().equalsIgnoreCase(s)) 
	          {
	        	  CNameBool=true;
				return me.getValue();
		   	}
	          else if(Counter == TLDMap.size())
	          {
				return authoritativeFinder(s);
			  }
	       }
		return null;
	}
	
	
	///============================================================
	private static String authoritativeFinder(String s) {
		Integer Counter=0;
		// Returns Set view
	       Set<Entry<String, String>> st = authoritativeMap.entrySet();

	       for (Entry<String, String> me:st) 
	       {
	    	   Counter++;
	          if (me.getKey().equalsIgnoreCase(s))
	          {
	        	  author=true;
				return me.getValue();
			}
	          else if(Counter==authoritativeMap.size())
	          {
				notFound=true;
				String notFoundString = "The IP address you requested wasn't found";
				return notFoundString;
			}
	       }
		return null;
	}
}


