/*
 * Author Anish Katariya
 * Defines the class for notification
 * That is the data to be transported in the form of distributed object
 */
public class Notification implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String accountHolder;
	float amount;
	//Constructor setter and getter methods
	public Notification(String accountHolder,float amount){
		this.accountHolder=accountHolder;
		this.amount=amount;
	}
	
	public String getAccountHolder() {
		return accountHolder;
	}

	public float getAmount() {
		return amount;
	}
	
}
