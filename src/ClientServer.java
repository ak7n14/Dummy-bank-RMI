/*
 * Author Anish
 * Defines the server of the client that connects to the bannk server
 * Recieves information form the server in form of notification
 */
import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;	
public class ClientServer {

	private static Scanner input;

	public static void main(String[] args){
	try{
		input = new  Scanner(System.in);
	//To change to seperate machine change the code below:
		NotificationSink remote =(NotificationSink)Naming.lookup("rmi://localhost/bank");//change to name of machine
		Naming.lookup("rmi://localhost/bank");//Change to name of machine
		//=================================================================
		System.out.println("Server Connected");//Shows when the connection is established
		System.out.println("Please enter Details:");//asks for user details
		System.out.printf("Account Holder name:");
		String name = input.nextLine();
		int amount;
		System.out.printf("\n Account Balance:");
		amount = input.nextInt();
		//Initialzing the gui
		ClientServerGUI gui = new ClientServerGUI(name,amount);
		gui.init();
		Customer cust = new Customer(name,amount);
		//Getting notification and updating the information
		while(true){
			Notification notification = new Notification(cust.getAccountHoldername(),cust.getBalance());
			Notification update=remote.getUpdate(notification);
			cust.setBalance(update.getAmount());
			gui.setAmount(cust.getBalance());
		}
		} catch(Exception e){System.out.println(e);}
	}
}
