/*
 * Author Anish Katariya
 * Creates an interface for RMI
 */
import java.rmi.*;    
public interface NotificationSink extends Remote{  
	public Notification getUpdate(Notification current)
			throws RemoteException;  
}  