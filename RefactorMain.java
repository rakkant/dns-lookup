import java.net.InetAddress;

import java.net.UnknownHostException;
 

public class Main {
    
 
    public void performNSLookup() {
        
        try {
            
            InetAddress inetHost = InetAddress.getByName("facebook.com");
            String hostName = inetHost.getHostName();
            System.out.println("The host name was: " + hostName);
            System.out.println("The hosts IP address is: " + inetHost.getHostAddress());
            
        } catch(UnknownHostException ex) {
            
            System.out.println("Unrecognized host");
        }
    }

    public static void main(String[] args) {
        new RefactorMain().performNSLookup();
    }
}