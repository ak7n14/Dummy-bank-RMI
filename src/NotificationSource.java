/*
 *Author Anish Katariya
 *Generated notifications and inform the sink about it
 *Also contains the methods to manipulate data and create notifications
 */
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
public class NotificationSource extends UnicastRemoteObject implements NotificationSink {

	protected NotificationSource() throws RemoteException {
		super();
		
	}
	
	
	private static final long serialVersionUID = 1L;
	//Methode for producing updated for the client
	@Override
	public Notification getUpdate(Notification current) throws RemoteException {
		try {
			Thread.sleep(36000);//Puts the thread a sleep for 1 min
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		float balance = current.getAmount();
		balance =getNewAmount(balance);
		return new Notification(current.getAccountHolder(),balance);
	}
	//Generates 10% interest
	public float getNewAmount(float balance){
		float interest = (float) (balance *0.1);
		return balance+interest; 
	}

}
