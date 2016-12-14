import java.rmi.*;    
public interface NotificationSink extends Remote{  
	public Notification getUpdate(Notification current)
			throws RemoteException;  
}  