import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NotificationSource extends UnicastRemoteObject implements NotificationSink {

	protected NotificationSource() throws RemoteException {
		super();
		
	}
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public Notification getUpdate(Notification current) throws RemoteException {
		try {
			Thread.sleep(36000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		float balance = current.getAmount();
		balance =getNewAmount(balance);
		return new Notification(current.getAccountHolder(),balance);
	}
	
	public float getNewAmount(float balance){
		float interest = (float) (balance *0.1);
		return balance+interest; 
	}

}
