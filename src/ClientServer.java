import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;	
public class ClientServer {

	private static Scanner input;

	public static void main(String[] args){
	try{
		input = new  Scanner(System.in);
	
		NotificationSink remote =(NotificationSink)Naming.lookup("rmi://localhost/bank");
		Naming.lookup("rmi://localhost/bank");
		System.out.println("Server Connected");
		System.out.println("Please enter Details:");
		System.out.printf("Account Holder name:");
		String name = input.nextLine();
		int amount;
		System.out.printf("\n Account Balance:");
		amount = input.nextInt();
		ClientServerGUI gui = new ClientServerGUI(name,amount);
		gui.init();
		Customer cust = new Customer(name,amount);
		while(true){
			Notification notification = new Notification(cust.getAccountHoldername(),cust.getBalance());
			Notification update=remote.getUpdate(notification);
			cust.setBalance(update.getAmount());
			gui.setAmount(cust.getBalance());
		}
		} catch(Exception e){System.out.println(e);}
	}
}
