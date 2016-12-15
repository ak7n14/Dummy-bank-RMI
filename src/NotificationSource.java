/*
 *Author Anish Katariya
 *Generated notifications and inform the sink about it
 *Also contains the methods to manipulate data and create notifications
 */
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
import java.rmi.RemoteException;
public class NotificationSource extends UnicastRemoteObject implements NotificationSink {
	ArrayList<NotificationSink> registeredSinks;
	private ArrayList<Notification> notifications;
	private Stack<Notification>pendingNotifications = new Stack<Notification>();
	protected NotificationSource() throws RemoteException {
		super();
		registeredSinks = new ArrayList<NotificationSink>();
		notifications = new ArrayList<Notification>();
		
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
	//Adds sinks to the arrayList if the sink added was previously lost connection
	//Tries to send the unsent messages
	public synchronized void registerSink(NotificationSink call)
			throws RemoteException {
		if(!this.registeredSinks.contains(call)){
			registeredSinks.add(call);
			notifications.addAll(new ArrayList<Notification>(20));
		}
		if(this.registeredSinks.contains(call)){
			checkPendingNotifications(call);
		}
		
	}

	//Removes sinks when connection is lost
	public synchronized void deRegisterSink(NotificationSink call)
			throws RemoteException {
		if(this.registeredSinks.contains(call)){
			notifications.remove(registeredSinks.indexOf(call));
			registeredSinks.remove(call);
			
		}
	}
	//Retries sending pending Notifications of lost connections
	public synchronized void checkPendingNotifications(Object call){
		if(pendingNotifications.isEmpty()){
			System.out.println("pending notification sent");
			for(int i=0;i<pendingNotifications.size();i++){
				pendingNotifications.get(i).sendNotification();
			}
		}
	}
}
