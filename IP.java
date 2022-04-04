import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.*;
import java.util.TimeZone;
public class IP {
	public static void main(String[] args) throws UnknownHostException, SocketException {
	System.out.println(Inet4Address.getLocalHost().getHostAddress());
	InetAddress addr= InetAddress.getByName(Inet4Address.getLocalHost().getHostAddress());
	System.out.println("Host name is: "+ addr.getHostName());
	 try {
         // IP Address
         InetAddress addr1
             = InetAddress.getByName("192.168.43.8");

         // Host name
         System.out.println("Host name is: "
                            + addr1.getHostName());

         // Host Address
         System.out.println("Ip address is: "
                            + addr1.getHostAddress());
     }
     catch (UnknownHostException e) {
         System.out.println(e);
     }
	 Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
	 while(e.hasMoreElements())
	 {
	     NetworkInterface n = (NetworkInterface) e.nextElement();
	     Enumeration<InetAddress> ee = n.getInetAddresses();
	     while (ee.hasMoreElements())
	     {
	         InetAddress i = (InetAddress) ee.nextElement();
	         System.out.println(i.getHostAddress());
	     }
	 }
	    //get Calendar instance
	    Calendar now = Calendar.getInstance();
	    //get current TimeZone using getTimeZone method of Calendar class
	    TimeZone timeZone = now.getTimeZone();
	    //display current TimeZone using getDisplayName() method of TimeZone class
	    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZone.getDisplayName()));
	    java.util.Date currentDate = calendar.getTime();
	    System.out.println(currentDate);
	    
	}
}
