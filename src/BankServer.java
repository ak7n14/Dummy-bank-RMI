/*
 *Author Anish Katariya
 *Defines a server for the client to connect to 
 */
import java.rmi.*;
import java.rmi.server.*;
public class BankServer {
	public static void main(String[] args){
		try{
			BankServerGUI gui = new BankServerGUI();
			gui.init();
			NotificationSource bank=new NotificationSource();
			Naming.rebind("bank",bank);
			//Changes label to show bank ready when the registry is established
			//And the server is up and running
			gui.setLabel("Bank Ready....");
		} catch(Exception e){}
	}
}
  