import java.net.InetAddress;

import java.net.UnknownHostException;
 

public class Converter {


	public static void main(String[] args) {
		String name = "";
		String ip = "";
		long ip2 = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter website domain");
		System.out.println("** Do not put http:// or https:// before the domain name**");
		System.out.print(":: ");
		name = input.nextLine();
		convertByName(name);
		
		System.out.print("Please enter IP address: ");
		ip = input.nextLine();
		convertByIp(ip);
		
		System.out.print("IP address to decimal: ");
		ip = input.nextLine();
		System.out.println("Answer: " + ipToLong(ip));
		
		System.out.print("Decimal to IP address: ");
		ip2 = input.nextLong();
		System.out.println("Answer: " + longToIp(ip2));

	}

	public static void convertByName(String name) {

		try {
			
			InetAddress inetHost = InetAddress.getByName(name);
			String hostName = inetHost.getHostName();
			System.out.println("The host IP address is: " + inetHost.getHostAddress());
			System.out.println();
	
		} catch(UnknownHostException ex) {

			System.out.println("Unrecognized host");
		}

	}

	public static void convertByIp(String ip){
		
		try {
			InetAddress host = InetAddress.getByName(ip);
			System.out.println("Domain name is: "+ host.getHostName());
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		}
	}

	
	public static long ipToLong(String ipAddress) {

		String[] ipAddressInArray = ipAddress.split("\\.");

		long result = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {

			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			result += ip * Math.pow(256, power);

		}

		return result;

	}

	public static String longToIp(long ip) {

		return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);

	}


}
