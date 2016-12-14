
import java.rmi.*;
import java.rmi.server.*;
public class BankServer {
	public static void main(String[] args){
		try{
			BankServerGUI gui = new BankServerGUI();
			gui.init();
			NotificationSource bank=new NotificationSource();
			Naming.rebind("bank",bank);
			gui.setLabel("Bank Ready....");
		} catch(Exception e){}
	}
}
  